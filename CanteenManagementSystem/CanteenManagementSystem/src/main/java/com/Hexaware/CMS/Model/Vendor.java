package com.Hexaware.CMS.Model;

import com.Hexaware.CMS.Factory.CustomerFactory;
import com.Hexaware.CMS.Factory.FoodFactory;
import com.Hexaware.CMS.Factory.OrderListFactory;

/**
 * Model Class for Vendor
 * @author Sagnik Bhattacharjee
 */
public class Vendor{
    
    private int vendorId;
    private String vendorPhoneNo;
    private String vendorFName;
    private String vendorLName;
    
    private String vendorEmail;
    private int rating;


    /**
     * getter method for vendorId
     * @return int
     */
    public int getVendorId(){
        return vendorId;
    }

    /**
     * getter method for vendorPhoneNo
     * @return String
     */
    public String getVendorPhoneNo(){
        return vendorPhoneNo;
    }

    /**
     * getter method for vendorFName
     * @return String
     */
    public String getVendorFName(){
        return vendorFName;
    }

    /**
     * getter method for vendorLName
     * @return String
     */
    public String getVendorLName(){
        return vendorLName;
    }

   
    /**
     * getter method for vendorEmail
     * @return String
     */
    public String getVendorEmail(){
        return vendorEmail;
    }
    /**
     * getter method for rating
     * @return int
     */
    public int getRating(){
        return rating;
   }
   /**
    * setter method for vendorId
    * @param argVendorId vendorId int
    */
    public void setVendorId(int argVendorId){
        this.vendorId = argVendorId;
    }

    /**
     * setter method for vendorPhoneNo
     * @param argVendorPhoneNo vendorPhoneNo String
     */

    public void setVendorPhoneNo(String argVendorPhoneNo){
        this.vendorPhoneNo = argVendorPhoneNo;
    }

    /**
     * setter method for vendorFName
     * @param argVendorFName vendorFName String
     */
    public void setVendorFName(String argVendorFName){
        this.vendorFName = argVendorFName;
    }

    /**
     * setter method for vendorLName
     * @param argVendorLName vendorLName String
     */
    public void setVendorLName(String argVendorLName){
        this.vendorLName = argVendorLName;
    }

    /**
     * setter method for Email
     * @param argVendorEmail vendorEmail String
     */
    
    public void setVendorEmail(String argVendorEmail){
        this.vendorEmail = argVendorEmail;
    }

    /**
     * setter method for rating
     * @param rate rating int
     */

    public void setRating(int rate){
        this.rating = rate;
    }
    
    /**Default constructor for vendor */
    public Vendor(){

    }

    /**
     * Parameterized Constructor for vendor
     * @param argVendorId vendorId int
     * @param argVendorFName vendorFName String
     * @param argVendorLName vendorLName String
     * @param argVendorEmail vendorEmail String
     * @param argVendorPhoneNo vendorPhoneNo String
     * @param stars rating int
     */
    public Vendor(int argVendorId,String argVendorFName, String argVendorLName,String argVendorEmail, String argVendorPhoneNo,int stars ){
        this.vendorId = argVendorId;
        this.vendorFName = argVendorFName;
        this.vendorLName = argVendorLName;
        this.vendorEmail = argVendorEmail;
        this.vendorPhoneNo =argVendorPhoneNo;
        this.rating = stars;
    }


    /**
     * to Accept/Deny order
     * @param v Vendor object
     * @param orderId orderId int
     * @param stat status String
     * @return String
     */

    public final String acceptDenyOrder(Vendor v,int orderId,String stat){
        String msg = "Unable to Accept or Reject Order,Please try again.";
        OrderList order = OrderListFactory.getOrderDetails(orderId);

    if(order.getOrderId() !=0){
        Customer c = CustomerFactory.retrieveById(order.getcustId());
        OrderStatus status = order.getOrderStatus();
        if(!status.equals(OrderStatus.PENDING)){
            System.out.println("Status of already Confirmed,Denied or Cancelled Sales cannot be updated ");
        }
        else{
            int res = OrderListFactory.updateOrderStatus(orderId,stat);
            if (res > 0){
            if(stat.equals(OrderStatus.ACCEPTED.name())){
                msg = "Your Order has been Confirmed.Enjoy your Meal!";
            }
            if(stat.equals(OrderStatus.REJECTED.name())){
                double curBal = c.getCustWalletBal();
                double tot = order.getTotalPrice();
                double amt = curBal+tot;
                int r = CustomerFactory.updateWallet(c.getCustId(),amt);
                if(r>0){
                    System.out.println("Amount Credited");
                }else{
                    System.out.println("Unable to Credit Amount.Please contact Customer Service");
                }

                msg ="Sory.We are Unable to fulfill your order at this time.Please try again later.";

                }
            }   
        }
    } 

    return msg;   

    }

    /**
     * to Upload new foodDetails
     * @param name foodName String
     * @param price foodPrice double
     * @param cuisine cuisine String
     * @param hasNonVeg hasNonVeg boolean
     * @param calorie double calorie
     * @param vId vendorId int
     * @return String
     */
    public final String uploadNewFoodDetails(String name,double price,String cuisine,boolean hasNonVeg,double calorie,int vId){
        String str = "Unable to upload Food Details";

        int res = FoodFactory.registerFoodDetails(name,price,cuisine,hasNonVeg,calorie,vId);
        if(res>0){
            str = "Food details added successfully";
        }
        return str;
    }

}