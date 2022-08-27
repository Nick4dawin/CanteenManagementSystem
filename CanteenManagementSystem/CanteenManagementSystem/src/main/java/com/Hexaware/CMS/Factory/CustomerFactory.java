package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Customer;

import com.Hexaware.CMS.Persistence.CustomerDB;


/**
 * OrderFactory class used to fetch and insert data to database.
 * 
 * @author Sagnik Bhattacharjee
 
 */
public class CustomerFactory {
    
    /**
   * to get customer details based on id
   * @param id customerId int
   * @return Customer object
   */
    public static Customer retrieveById(int id) {
        Customer c = CustomerDB.getCustomerById(id);
        return c;
    }
    
    /**
   * to get customer details based on email
   * @param em email String
   * @return Customer object
   */
    public static Customer retrieveByEmail(String em) {
        Customer c = CustomerDB.getCustomerByEmail(em);
        return c;
    }

    /**
   * to register a new customer into db
   * @param fname customerFName String
   * @param lName customerLName String
   * @param email customerEmail String
   * @param wallet customerWallet Double
   * @param addr customerAddr  String
   * @param phoneNo customerPhoneNo String
   * @return int
   */
    public static int registerCustomer(String fName, String lName, String email, double wallet, String addr, String phoneNo) {
        int res = CustomerDB.registerCustomer(fName,lName, email, wallet, addr, phoneNo);
        return res;
    }

     /**
   * to increment or decrement the wallet
   * @param id customerId int
   * @param bal walletBalance double
   * @return int
   */
    
    public static int updateWallet(int id, double bal) {
        int res = CustomerDB.updateWallet(id, bal);
        return res;
    }

    /**
   * update the coupon for new customer
   * @param argId customerId int 
   * @param coupon coupon String
   * @return int
   */
    public static int updateCoupon(int argId, String coupon) {
        int res = CustomerDB.updateCoupon(argId, coupon);
        return res;
    }

    
    /**
   * to update customer's address.
   * @param argId customerId int
   * @param addr String
   * @return int
   */ 
    public static int updateAddress(int argId, String addr) {
        int res = CustomerDB.updateAddress(argId, addr);
        return res;
    }

}

