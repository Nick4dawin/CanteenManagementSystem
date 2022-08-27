package com.Hexaware.CMS.Cli;

import java.util.Scanner;

import com.Hexaware.CMS.Factory.FoodFactory;
import com.Hexaware.CMS.Factory.CustomerFactory;
import com.Hexaware.CMS.Factory.LoginFactory;
import com.Hexaware.CMS.Factory.OrderListFactory;
import com.Hexaware.CMS.Model.Customer;
import com.Hexaware.CMS.Model.Food;
import com.Hexaware.CMS.Model.OrderList;
import com.Hexaware.CMS.Model.Vendor;

public class VendorUtil{

    private Scanner sc = new Scanner(System.in);

    public void vendorMenu(Vendor v){
        System.out.println("----------------------------");
        System.out.println("Welcome "+v.getVendorFName()+" "+v.getVendorLName());
        System.out.println("----------------------------");
        System.out.println("1. Show Menu");
        System.out.println("2. Accept or Reject Order Requests");
        System.out.println("3. Add Food to Menu ");
        System.out.println("4. Edit Menus ");
        System.out.println("5. Order History");
        System.out.println("6.Profile");
        System.out.println("7.Change Password");
        System.out.println("8.Log out");
        System.out.println("----------------------------");
        System.out.print("Please enter your choice: ");
        int ch= sc.nextInt();

        subMenu(ch,v);
    }

    void subMenu(int ch,Vendor v){
        switch(ch){
            case 1:
            Food[] foods = FoodFactory.filterByVendor(v.getVendorId());
            if(foods.length > 0){
                for(Food f:foods){
                    System.out.println("Food Code : "+f.getFoodCode()+" ,Food Name: "+ f.getFoodName() +" ,Price: "+f.getFoodPrice()+ " ,Vendor id: "+ f.getvendorId() + " ,VedorName: "+ v.getVendorFName()+ " "+v.getVendorLName());
                }
            }
            break;
            case 2:
                String stat = "";
                OrderList[] ordersToday = OrderListFactory.getPendingOrdersV(v.getVendorId());
                if (ordersToday.length> 0){
                  for(OrderList l:ordersToday){
                    Food food = FoodFactory.getFoodDetails(l.getFoodCode());
                    Customer c= CustomerFactory.retrieveById(l.getcustId());
                    System.out.println("Id:"+l.getOrderId() + " Date: "+
                    l.getOrderDate() + " Food Name: "+ food.getFoodName()+" Customer: "+c.getCustFName() +" "+c.getCustLName() +" Quantity: "+l.getQuantity() +" Total: "+l.getTotalPrice()+ " Order Status: "+ l.getOrderStatus().name());
                
                    System.out.println("Confirm Order? (1 for Yes, 2 for No)");
                    int y = sc.nextInt();
                    if(y==1){
                        stat = "ACCEPTED";
                    }
                    else{
                        stat = "REJECTED";
                    }

                    String msg = v.acceptDenyOrder(v,l.getOrderId(),stat);
                    System.out.println(msg);
                }                
                }
                else{
                    System.out.println("No Sales Today. ");
                }
            break;
            case 3:
                System.out.print("Enter Food Name: ");
                String name = sc.next();
                System.out.print("Enter Price: ");
                int price = sc.nextInt();
                System.out.print("Enter Cuisine: ");
                String cusine = sc.next();
                System.out.print("Enter Calorie: ");
                double rate = sc.nextDouble();
                System.out.println("Does it have Non Veg?");
                Boolean hasNonVeg = sc.nextBoolean();

                String msg = v.uploadNewFoodDetails(name,price,cusine,hasNonVeg,rate,v.getVendorId());
                System.out.println(msg);
                break;

            
            case 4:
            Food[] foodsList = FoodFactory.filterByVendor(v.getVendorId());
            if(foodsList.length > 0){
                for(Food f:foodsList){
                    System.out.println("Food Code : "+f.getFoodCode()+" ,Food Name: "+ f.getFoodName() +" ,Price: "+f.getFoodPrice()+ " ,Vendor id: "+ f.getvendorId() + "VedorName: "+ v.getVendorFName()+ " "+v.getVendorLName());
                }
            }
            System.out.print("Please Enter the Food Code: ");
            int id = sc.nextInt();
            System.out.print("Please Enter the New Price");
            double cost = sc.nextDouble();
            int res = FoodFactory.updateFoodPrice(id, cost);

            if(res>0){
                System.out.println("Price Updated Successfully");
            }
            else{
                System.out.println("Update Unsuccessful. Please Try Again.");
            }
            break;
            case 5:
            OrderList[] history = OrderListFactory.getVendorHistory(v.getVendorId());
            if(history.length>0){
                for(OrderList l:history){
                    Food food = FoodFactory.getFoodDetails(l.getFoodCode());
                    Customer c= CustomerFactory.retrieveById(l.getcustId());
                    System.out.println("Id:"+l.getOrderId() + " Date: "+
                    l.getOrderDate() + " Food Name: "+ food.getFoodName()+" Customer: "+c.getCustFName() +" "+c.getCustLName() +" Quantity: "+l.getQuantity() +" Total: "+l.getTotalPrice()+ " Order Status: "+ l.getOrderStatus().name());
                }
            }else{
                System.out.println("You seem to have joined recently. PLease make complete an order to View Order History.");
            }
            break;
            case 6:
            System.out.println("----Profile Details----");
            System.out.println("Id: "+ v.getVendorId());
            System.out.println("Vendor Name: "+v.getVendorFName()+" "+v.getVendorLName());
            System.out.println("Email: "+v.getVendorEmail());
            System.out.println("Phone: "+v.getVendorPhoneNo());
            System.out.println("Rating: "+v.getRating());
            break;
            case 7:
            System.out.print("Current Password: ");
            String current = sc.next();
            System.out.print("New Password: ");
            String nPass = sc.next();
            System.out.print("Confirm New Password: ");
            String pass = sc.next();
            if(nPass.equals(pass) && !nPass.equals(current)) {
              int r = LoginFactory.updatePassword(v.getVendorEmail(), pass);
              if(r > 0) {
                System.out.println("Password Updated Successfully");
              } else {
                System.out.println("Unable to update. Please try later");
              }
            } else {
              System.out.println("Password Mismatch. Please try again");
            }
            break;
            case 8:
            sc.close();
            Runtime.getRuntime().exit(0);
            break;
            default:
            break;
        }
        vendorMenu(v);
    }
}