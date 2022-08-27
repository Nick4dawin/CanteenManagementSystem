package com.Hexaware.CMS.Cli;

import java.util.Scanner;


import com.Hexaware.CMS.Factory.VendorFactory;
import com.Hexaware.CMS.Factory.CustomerFactory;
import com.Hexaware.CMS.Factory.LoginFactory;
import com.Hexaware.CMS.Model.Customer;
import com.Hexaware.CMS.Model.Login;
import com.Hexaware.CMS.Model.Vendor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * CliMain used as Client interface for java coading.
 * @author Sagnik Bhattacharjee
 */
public class CliMain {
    
    static Scanner sc=new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
/**
 * main method  used to display the option we had in the application.
 */  
   
        
        private void mainMenu(){
            System.out.println( "------------------------------" );    
        System.out.println( "  Canteen Management System  " );
        System.out.println( "------------------------------" );      
        System.out.println("1.For User Login");
        System.out.println("2.For Registering new user");
        System.out.println("3.Change Password");
        System.out.println("4.For Vendor Login");
        System.out.println("5.For Logging Out");
        System.out.println("Enter your choice :");
        int ch=sc.nextInt();
        subMenu(ch);
        }
        
        void subMenu(int ch){
            
            switch(ch){
            case 1:
                System.out.println("Please enter your details");
                System.out.println("UserName: ");
                String user = sc.next();
                System.out.println("Password: ");
                String pass = sc.next();
                Login l = LoginFactory.getUserByUserName(user);
                if(!l.equals(null)){
                    if(pass.equals(l.getPassCode())){
                CustomerUtil cu = new CustomerUtil();
                Customer c = CustomerFactory.retrieveByEmail(user);
                cu.customerMenu(c);
                } 
             else {
                System.out.println("Wrong username and password");
                }
            }
                break;
            case 2:
                   registerUser();
                break;
            case 3:
                System.out.println("Please Login to Change your Passwords");
                break;
            
            case 4:
                System.out.println("Please enter your details");
                System.out.print("UserName: ");
                String ven = sc.next();
                System.out.print("Password: ");
                String code = sc.next();

                Login l2 = LoginFactory.getUserByUserName(ven);
                if (!l2.equals(null)) {
                    if(code.equals(l2.getPassCode())) {
                    VendorUtil v = new VendorUtil();
                    Vendor vc = VendorFactory.retrieveByEmail(ven);
                    v.vendorMenu(vc);
                } else {
                    System.out.println("Wrong username and password");
                    }
                } else{
                    System.out.println("Please Contact the Administrator");
                }
                break;

                
            
            case 5:
                sc.close();
                Runtime.getRuntime().exit(0);
                break;
            default:
            System.out.println("Invalid Choice. Please choose a valid option.");
            break;
        }
        mainMenu();
        }

        /**
        This is  a method for registering the user
         */
        void registerUser(){
            String custAdress = "";
            System.out.println("Enter your First Name: ");
                String custFName = sc.next();
            System.out.println("Enter your Last Name: ");
                String custLName = sc.next();
            System.out.println("Enter your Address: ");
                try{
                   custAdress = br.readLine();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            System.out.println("Enter your Phone no: ");
                String custPhoneNo = sc.next();
            System.out.println("Enter your Email: ");
                String custEmail = sc.next();
            System.out.println("Enter your Password: ");
                String custPass = sc.next();
            System.out.println("Confirm your Password: ");
                String confirm = sc.next();
            
            if(custPass.equals(confirm)){
                Customer c = new Customer();
                String str = c.registerCustomer(custFName, custLName, custAdress , custEmail , custPhoneNo, custPass);
                System.out.println(str);
                System.out.println("Please login to Continue");
            } else {
                System.out.println("Password Mismatch. Please Try Again");

            }              
            mainMenu();
            
        }
        public static void main(String[] args) {
    CliMain obj = new CliMain();
    obj.mainMenu();
        }
}

    

      
        
   