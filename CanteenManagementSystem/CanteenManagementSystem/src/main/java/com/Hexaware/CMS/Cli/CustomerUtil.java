package com.Hexaware.CMS.Cli;

import java.util.Scanner;

import com.Hexaware.CMS.Factory.CustomerFactory;

import com.Hexaware.CMS.Factory.FoodFactory;
import com.Hexaware.CMS.Factory.OrderListFactory;
import com.Hexaware.CMS.Factory.VendorFactory;
import com.Hexaware.CMS.Factory.LoginFactory;
import com.Hexaware.CMS.Model.Customer;
import com.Hexaware.CMS.Model.Food;
import com.Hexaware.CMS.Model.OrderList;
import com.Hexaware.CMS.Model.Vendor;

public class CustomerUtil {
  private Scanner sc1 = new Scanner(System.in);

  public void customerMenu(Customer c) {
    System.out.println("-----------------------------");
    System.out.println( "  Canteen Management System  " );
    System.out.println("-----------------------------");
    System.out.println( "  Customer Name: "+ c.getCustFName() +" "+ c.getCustLName() );
    System.out.println("-----------------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Placing Order");
    System.out.println("3. Order History");
    System.out.println("4. Profile");
    System.out.println("5. Wallet Balance");
    System.out.println("6. Cancel Order");
    System.out.println("7. Rating Order");
    System.out.println("8. Total Calorie Consumption");
    System.out.println("9. Change Password");
    System.out.println("10. Exit");
    
    System.out.println( " Enter your choice : " );
    int ch = sc1.nextInt();
    customerSubMenu(ch, c);
  }
    
  void customerSubMenu(int ch, Customer ct) {
    switch(ch){
        case 1:

            System.out.println("1.List all Food");    
            System.out.println("2.Show only Veg Food");
            System.out.println("3.Show only NonVeg Food");
            System.out.println("4.Show food by Calorie");
            System.out.println("5.Search food by Cuisine");
            System.out.println("6.Previous menu");
            System.out.print("Enter Choice: ");
            int foodChoice = sc1.nextInt();
            foodSubMenu(foodChoice,ct);
            break;
        case 2:
            Food[] food1 = FoodFactory.listAllFoods();
            for (Food f : food1) {
                System.out.println("Food Code: " + f.getFoodCode()
                        + ", Food Name: " + f.getFoodName() + ", Price: "
                        + f.getFoodPrice() + ", Vendor: " + f.getvendorId());
            }
            System.out.print("Please enter the Food Code: ");
            int fId = sc1.nextInt();
            System.out.print("Please enter the quantity: ");
            int fty = sc1.nextInt();

            String st = ct.purchaseFood(fId,ct,fty);
            System.out.println(st);
            
            break;
        case 3:
            OrderList[] history = OrderListFactory.getCustomerHistory(ct.getCustId());
            if (history.length > 0) {
                for (OrderList o : history) {
                    Food f = FoodFactory.getFoodDetails(o.getFoodCode());
                    Vendor v = VendorFactory.retrieveById(o.getVendorId());
                    System.out.println("Id: " + v.getVendorId() + ", Date: " + o.getOrderDate()
                            + ", CarName: " + f.getFoodName() + ", Brand: " + f.getCuisine()
                            + ", Salesman: " + v.getVendorFName() + ", Quantity: " + o.getQuantity()
                            + ", Total: " + o.getTotalPrice() + ", Status: " + o.getOrderStatus().name());
                }
            } else {
                System.out.println("You seem to be new to us. Please make your first order");
            }
            break;
        case 4:
            System.out.println("PROFILE DETAILS");
            System.out.println("ID: " + ct.getCustId());
            System.out.println("NAME: " + ct.getCustFName()+" "+ct.getCustLName());
            System.out.println("ADDRESS: " + ct.getCustAdress());
            System.out.println("EMAIL: " + ct.getCustEmail());
            System.out.println("WALLETBALANCE: " + ct.getCustWalletBal());
            break;
        case 5:
            System.out.println("Current Wallet Balance: " + ct.getCustWalletBal());
            System.out.print("Do you want to add to your wallet? (1 for yes, 2 for no) ");
            int y1 = sc1.nextInt();
            if (y1 == 1) {
                System.out.print("Please enter the amount to add: ");
                double amt = sc1.nextDouble();
                amt = ct.getCustWalletBal() + amt;
                int result = CustomerFactory.updateWallet(ct.getCustId(), amt);

                if (result > 0) {
                    System.out.println("Wallet updated successfully");
                    System.out.println("Current Balance: " + amt);
                } else {
                    System.out.println("Unable to Add amount. Please try again later");
                }
            }
            break;
        case 6:
            OrderList[] order = OrderListFactory.getPendingOrdersC(ct.getCustId());
            if (order.length > 0) {
                for (OrderList o : order) {
                    Food f = FoodFactory.getFoodDetails(o.getFoodCode());
                    Vendor v = VendorFactory.retrieveById(o.getVendorId());
                    System.out.println("Id: " + o.getOrderId() + ", Date: " + o.getOrderDate()
                            + ", Food Name: " + f.getFoodName() + ", Cuisine: " + f.getCuisine()
                            + ", Vendor: " + v.getVendorFName() + ", Quantity: " + o.getQuantity()
                            + ", Total: " + o.getTotalPrice() + ", Status: " + o.getOrderStatus().name());
                }
                System.out.print("Please enter the purchase you want to cancel: ");
                int cancel = sc1.nextInt();
                System.out.print("Are you sure you want to cancel? (1 for yes, 2 for no)");
                int y = sc1.nextInt();
                if (y == 1) {
                    String msg = ct.cancelPurchase(cancel, ct);
                    System.out.println(msg);
                }
            }
            break;
        case 7:
            System.out.println("Below is the list of Vendor who helped you. Please Rate them");
            OrderList[] purchases = OrderListFactory.listAllOrdersForToday(ct.getCustId());
            if (purchases.length > 0) {
                for (OrderList o : purchases) {
                    Vendor v = VendorFactory.retrieveById(o.getVendorId());
                    System.out.println("Vendor Id: " + v.getVendorId()
                            + ", Name: " + v.getVendorFName());
                    System.out.print("Rating please: (1 to 5): ");
                    int r = sc1.nextInt();
                    String str = ct.updateRatings(v.getVendorId(), r);
                    System.out.println(str);
                }
            }
            break;
        case 8:
            OrderList[] cusHistory = OrderListFactory.getCustomerHistory(ct.getCustId());
            Double totalCalorie = 0.0;
            for(OrderList l:cusHistory){
                Food f = FoodFactory.getFoodDetails(l.getFoodCode());
                totalCalorie = totalCalorie + f.getCalorie();
            }
            System.out.println("Total Calorie consumption till now : "+totalCalorie);
            break;
        case 9:
        System.out.print("Current Password: ");
        String current = sc1.next();
        System.out.print("New Password: ");
        String nPass = sc1.next();
        System.out.print("Confirm New Password: ");
        String pass = sc1.next();
        if(nPass.equals(pass) && !nPass.equals(current)) {
          int r = LoginFactory.updatePassword(ct.getCustEmail(), pass);
          if(r > 0) {
            System.out.println("Password Updated Successfully");
          } else {
            System.out.println("Unable to update. Please try later");
          }
        } else {
          System.out.println("Password Mismatch. Please try again");
        }
        break;
        
        case 10:
            Runtime.getRuntime().exit(0);
        default:
            break;
    }
    
    customerMenu(ct);
}

void foodSubMenu(int ch,Customer c){

    switch(ch){
        case 1:
            Food[] foodsAll = FoodFactory.listAllFoods();
            for(Food f: foodsAll) {
            System.out.println("Food Code: "+ f.getFoodCode()
                + ", Food Name: " + f.getFoodName() + ", Price: "
                + f.getFoodPrice() + ", Vendor: " + f.getvendorId());
            }
        break;
        case 2:
            Food[] foodsVeg = FoodFactory.listByHasVegNonVeg(false);
            for(Food f:foodsVeg){
                System.out.println("Food Code: "+ f.getFoodCode()
                + ", Food Name: " + f.getFoodName() + ", Price: "
                + f.getFoodPrice() + ", Vendor: " + f.getvendorId());
            }
        break;
        case 3:
            Food[] foodsNonVeg = FoodFactory.listByHasVegNonVeg(true);
            for(Food f:foodsNonVeg){
                System.out.println("Food Code: "+ f.getFoodCode()
                + ", Food Name: " + f.getFoodName() + ", Price: "
                + f.getFoodPrice() + ", Vendor: " + f.getvendorId());
            }
        break;
        case 4:
            Food[] foodsCalorie = FoodFactory.orderByCalorie();
            for(Food f: foodsCalorie){
                System.out.println("Food Code: "+ f.getFoodCode()
                + ", Food Name: " + f.getFoodName() + ", Price: "
                + f.getFoodPrice() + ", Vendor: " + f.getvendorId());
            }
        break;
        case 5:

            Food[] foodsA = FoodFactory.listAllFoods();
            System.out.println("The CUISINES available are: " );
            for(Food f:foodsA){
                System.out.println(f.getCuisine());
            }
            System.out.println("Please Enter Cuisine(Please don't make a spelling mistake): ");
            String cuisine = sc1.next();

            Food[] foodByCuisine = FoodFactory.filterByCuisine(cuisine);
            for( Food f:foodByCuisine){
                System.out.println("Food Code: "+ f.getFoodCode()
                + ", Food Name: " + f.getFoodName() + ", Price: "
                + f.getFoodPrice() + ", Vendor: " + f.getvendorId());
            }
        break;

        case 6:
            customerMenu(c);
        break;

        default:
        break;
    }

}




}
