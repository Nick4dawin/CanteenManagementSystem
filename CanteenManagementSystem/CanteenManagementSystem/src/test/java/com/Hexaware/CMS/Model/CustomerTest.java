package com.Hexaware.CMS.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest{

    // @Before
    // public void beforeTest(){
    //     System.out.println("This is run before test");
    // }

    /**
    Test for Default Constructor
     */

    @Test
    public void testCustomer(){
        Customer customer = new Customer();
        customer.setCustId(1);
        customer.setCustFName("Sagnik");
        customer.setCustLName("Bhattacharjee");
        customer.setCustAdress("10th_Street_Asansol");
        customer.setCustPhoneNo("7515651");
        customer.setCustWalletBal(41000.00);
        customer.setCustEmail("demo@example.com");

        assertEquals(1,customer.getCustId());
        assertEquals("Sagnik",customer.getCustFName());
        assertEquals("Bhattacharjee",customer.getCustLName());
        assertEquals("10th_Street_Asansol",customer.getCustAdress());
        assertEquals("7515651",customer.getCustPhoneNo());
        assertEquals(41000.00,customer.getCustWalletBal(),0);
        assertEquals("demo@example.com",customer.getCustEmail());

    }

    /**
    Test for Parameterised Constructor */

    @Test
    public void testCustomerP(){
        Customer customer = new Customer(1,"Sagnik","Bhattacharjee","10th_Street_Asansol","7515651",41000.00,"demo@example.com");
        
        assertEquals(1,customer.getCustId());
        assertEquals("Sagnik",customer.getCustFName());
        assertEquals("Bhattacharjee",customer.getCustLName());
        assertEquals("10th_Street_Asansol",customer.getCustAdress());
        assertEquals("7515651",customer.getCustPhoneNo());
        assertEquals(41000.00,customer.getCustWalletBal(),0);
        assertEquals("demo@example.com",customer.getCustEmail());

    }

    /**
    Test method for setCustomerId */

    @Test
    public void testSetCustomerId(){

        Customer c = new Customer();
        c.setCustId(1);
        assertEquals(1,c.getCustId());
    }

    /**
    Test method for GetCustomerId */

    @Test
    public void testGetCustomerId(){

        Customer customer = new Customer(1,"Sagnik","Bhattacharjee","10th_Street_Asansol","7515651",41000.00,"demo@example.com");
        assertEquals(1,customer.getCustId());
    }

    /**
    Test method for setCustomerFName */

    @Test
    public void testSetCustomerFName(){

        Customer c = new Customer();
        c.setCustFName("Sagnik");
        assertEquals("Sagnik",c.getCustFName());
    }


    /**
    Test method for getCustomerName */

    @Test
    public void testGetCustomerFName(){
        Customer customer = new Customer(1,"Sagnik","Bhattacharjee","10th_Street_Asansol","7515651",41000.00,"demo@example.com");
        assertEquals("Sagnik",customer.getCustFName());
    }

    /**
    Test Method for setCustomerLName */

    @Test
    public void testSetCustomerLName(){

        Customer c = new Customer();
        c.setCustLName("Bhattacharjee");
        assertEquals("Bhattacharjee",c.getCustLName());
    }

    /**
    Test Method for getCustomerLName */

    @Test
    public void testGetCustomerLName(){
        
        Customer customer = new Customer(1,"Sagnik","Bhattacharjee","10th_Street_Asansol","7515651",41000.00,"demo@example.com");
        assertEquals("Bhattacharjee",customer.getCustLName());
    }

    /**
    Test Method for setCustomerAdress */

    @Test
    public void testSetCustomerAdress(){
         Customer c = new Customer();
        c.setCustAdress("Kolkata");
        assertEquals("Kolkata",c.getCustAdress());
    }

    /**
    Test Method for getCustomerAdress */

    @Test
    public void testGetCustomerAdress(){
        
        Customer customer = new Customer(1,"Sagnik","Bhattacharjee","10th_Street_Asansol","7515651",41000.00,"demo@example.com");
        assertEquals("10th_Street_Asansol",customer.getCustAdress());
    }

    /**
    Test Method for setCustomerPhoneNo */

    @Test
    public void testSetCustomerPhoneNo(){
        Customer c = new Customer();
        c.setCustPhoneNo("123456");
        assertEquals("123456",c.getCustPhoneNo());
    }

    /**
    Test Method for getCustomerPhoneNo */
    @Test
    public void testGetCustomerPhoneNo(){
       Customer customer = new Customer(1,"Sagnik","Bhattacharjee","10th_Street_Asansol","7515651",41000.00,"demo@example.com");
       assertEquals("7515651",customer.getCustPhoneNo()); 
    }

    /**
    Test Method for setCustomerWalletBal */

    @Test
    public void testSetCustomerWalletBal(){
        Customer c = new Customer();
        c.setCustWalletBal(41000.00);
        assertEquals(41000.00,c.getCustWalletBal(),0);
    }

    /**
    Test Method for getCustomerWalletBal */

    @Test
    public void testGetCustomerWalletBal(){
        Customer c = new Customer(1,"Sagnik","Bhattacharjee","10th_Street_Asansol","7515651",41000.00,"demo@example.com");
       assertEquals(41000.00,c.getCustWalletBal(),0); 
    }

    /**
    Test Method for setCustomerEmail */

    @Test
    public void testSetCustomerEmail(){
        Customer c = new Customer();
        c.setCustEmail("demo@example.com");
        assertEquals("demo@example.com",c.getCustEmail());

    }

    /**
    Test Method for getCustomerEmail */

    @Test
    public void testGetCustomerEmail(){
        Customer c = new Customer(1,"Sagnik","Bhattacharjee","10th_Street_Asansol","7515651",41000.00,"demo@example.com");
        assertEquals("demo@example.com",c.getCustEmail());
   }
}   

