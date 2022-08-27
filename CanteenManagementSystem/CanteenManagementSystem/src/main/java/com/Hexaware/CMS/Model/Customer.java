package com.Hexaware.CMS.Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

import com.Hexaware.CMS.Factory.CustomerFactory;
import com.Hexaware.CMS.Factory.FoodFactory;
import com.Hexaware.CMS.Factory.LoginFactory;
import com.Hexaware.CMS.Factory.OrderListFactory;
import com.Hexaware.CMS.Factory.VendorFactory;

/**Model Class for Customer
 * @author Sagnik Bhattacharjee
 */


public class Customer{
    private int custId;
    private String custFName;
    private String custLName;
    private String custAdress;
    private String custPhoneNo;
    private double custWalletBal;
    private String custEmail;
    

    /**
     * Default Constructor for Customer
     */

    public Customer(){

    }

    /**
     * Parameterized Constructor for Customer
     * @param argCustId  customerId int
     * @param argCustFName customerFirstName String
     * @param argCustLName customerLastName String
     * @param argCustAdress customerAdress String
     * @param argCustPhoneNo customerPhoneNo String
     * @param argCustWalletBal customerWalletBalance double
     * @param argCustEmail customerEmail String
     */
    public Customer(int argCustId,String argCustFName,String argCustLName,String argCustAdress,String argCustPhoneNo,double argCustWalletBal,String argCustEmail){
        this.custId = argCustId;
        this.custFName = argCustFName;
        this.custLName = argCustLName;
        this.custAdress = argCustAdress;
        this.custWalletBal = argCustWalletBal;
        this.custEmail = argCustEmail;

    }

    /**
     * Getter for custId
     * @return int
     */
    
    public int getCustId(){
        return custId;
    }

    /**
     * Getter for custFName
     * @return String
     */
    public String getCustFName(){
        return custFName;
    }

    /**
     * Getter for custLName
     * @return String
     */

    public String getCustLName(){
        return custLName;
    }

    /**
     * Getter for custAdress
     * @return String
     */
    public String getCustAdress(){
        return custAdress;
    }

    /**
     * Getter for custPhoneNo
     * @return String
     */

    public String getCustPhoneNo(){
        return custPhoneNo;
    }

    /**
     * getter for custWalletBalance
     * @return double
     */

    public double getCustWalletBal(){
        return custWalletBal;
    }

    /**
     * getter for custEmail
     * @return String
     */

    public String getCustEmail(){
        return custEmail;
    }


    /**
     * Setter for custId
     * @param argCustId custId int
     */
   

    public void setCustId(int argCustId){
        this.custId = argCustId;
    }


    /**
     * Setter for custFName
     * @param argCustFName customerFirstName String
     */
    public void setCustFName(String argCustFName){
        this.custFName = argCustFName;
    }

    /**
     * Setter for custLName
     * @param argCustLName customerLastName String
     */
    public void setCustLName(String argCustLName){
        this.custLName = argCustLName;
    }

    /**
     * Setter for custAdress
     * @param argCustAdress customerAdress String
     */

    public void setCustAdress(String argCustAdress){
        this.custAdress = argCustAdress;
    }

    /**
     * Setter for custmerPhoneNo
     * @param argCustPhoneNo customerPhoneNo String
     */

    public void setCustPhoneNo(String argCustPhoneNo){
        this.custPhoneNo = argCustPhoneNo;
    }

    /**
     * Setter for customerWalletBalance
     * @param argCustWalletBal customerWalletBal double
     */

    public void setCustWalletBal(double argCustWalletBal){
        this.custWalletBal = argCustWalletBal;
    }

    /**
     * Setter for custEmail
     * @param argCustEmail customerEmail String
     */
    public void setCustEmail(String argCustEmail){
        this.custEmail = argCustEmail;
    }


  /**
   * to register a new customer
   * @param fName customerFName String
   * @param lName customerLName String
   * @param addr address String
   * @param email emailAddr String
   * @param phoneNo Customer Phone No String
   * @param pass password String
   * @return String
   */  
    
    public final String registerCustomer(String fName,String lName,String addr,String email,String phoneNo,String pass){
        String str = "Unable to register user,Please try again";
        double bal = 5000.00;
        int result = CustomerFactory.registerCustomer(fName,lName,email,bal,addr,phoneNo);
        if (result>0){
            int r = LoginFactory.registerUser(email,pass);
            if (r > 0) {
        str = "User Registered Successfully";
        } else {
               System.out.println("Something went wrong. Try again");
        }
        }    
      return str;  
    }


     /**
   * to purchase food
   * @param argFoodId FoodCode int
   * @param c Customer object
   * @param qty quantity int
   * @return String
   */

   public final String purchaseFood(int argFoodId,Customer c,int qty){
        String str = "Unable to complete the purchase. Please try later!";

        Random random = new Random();
        int val = random.nextInt(900) + 100;
        String coupon = "FIRST" + val;

        boolean flag = false;
        double discount = 0.0;
        double amt = 0.0;

        OrderList[] orders = OrderListFactory.getCustomerHistory(c.getCustId());
        if(orders.length == 0){
            flag = true;
        }

        Food food = FoodFactory.getFoodDetails(argFoodId);
        if(!food.equals(null)|| food.getFoodCode() != 0){
            amt = food.getFoodPrice()*qty;
        }

        if(flag){
            discount = amt*0.20;
            amt = amt - discount;
        }

        LocalDate ld = LocalDate.now();
        Date pDate = Date.valueOf(ld);

        String status= OrderStatus.PENDING.name();

        double curBal = c.getCustWalletBal();

        if(curBal>amt){
            
            int res = OrderListFactory.completeFoodOrder(c.getCustId(),amt,argFoodId,pDate,status,food.getvendorId(),qty);

            if(res>0){
                double currentAmount = curBal - amt;
                int s = CustomerFactory.updateWallet(c.getCustId(),currentAmount);
                if(s>0){
                    System.out.println("Your Wallet has been updated");
                }else {
            System.out.println("Unable to update Wallet");
            }
            if (flag) {
            int r = CustomerFactory.updateCoupon(c.getCustId(), coupon);
            if (r > 0) {
              System.out.println("A 20% discount has been applied to your first order");
            }
            }
            str = "Food Purchase Order Completed. You can now track your purchase";
            }
        }else{
            str = "Unable to complete purchase.Wallet Balance is Low, PLease add Money." + c.getCustWalletBal();
        }
        return str;
    }
    

    /**
     * To cancel order
     * @param orderId OrderId int
     * @param c Customer Object
     * @return String
     */
   public final String cancelPurchase(int orderId,Customer c){
       String str = "Unable to cancel purchase! Please try again.";
        OrderList details = OrderListFactory.getOrderDetails(orderId);

        String status = "CANCELLED";

        if(details.getOrderId()!=0){
            OrderStatus stat= details.getOrderStatus();
            LocalDate check = details.getOrderDate();
            LocalDate today = LocalDate.now();
            if(check.isBefore(today)||!check.isEqual(today)){
                System.out.println("Only Today's Purchases can be cancelled");
            }else{
                if(!stat.equals(OrderStatus.PENDING)){
                    System.out.println("Confirmed or Denied Bookings can't be cancelled.");
                }
                else{
                    int res = OrderListFactory.updateOrderStatus(orderId,status);

                    if(res>0){
                        double curBal = c.getCustWalletBal();
                        double purchaseAmt = details.getTotalPrice();
                        double amt = curBal + purchaseAmt;
                        int r = CustomerFactory.updateWallet(c.getCustId(),amt);
                        if(r>0){
                            System.out.println("Amount Credited to Account");
                        }
                        str = "Purchase Cancelled. Thank you for shopping with us";
                    }
                }
            }
        }

    return str;
   }

    /**
   * to give Vendor ratings
   * @param id vendorId int
   * @param rating rating int
   * @return String
   */

   public final String updateRatings(int id,int rating){
       String str = "Unable to update Ratings,Please try later";
       Vendor v = VendorFactory.retrieveById(id);

        int r = v.getRating();
        r = (r+rating)/2;

        int res = VendorFactory.updateRating(id,r);
        if(res > 0){
            str = "Updated Rating for Vendor " + v.getVendorFName() + " " + v.getVendorLName();
        }
        return str;
   }
}

