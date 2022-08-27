package com.Hexaware.CMS.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VendorTest {
    @Test
    public void testVendor(){
        Vendor v = new Vendor();
        v.setVendorId(1);
        v.setVendorPhoneNo("9999992224");
        v.setVendorFName("Sunil");
        v.setVendorLName("Chetri");
        v.setVendorEmail("emo@example.com");
        v.setRating(4);
        

        assertEquals(1, v.getVendorId());
        assertEquals("9999992224", v.getVendorPhoneNo());
        assertEquals("Sunil", v.getVendorFName());
        assertEquals("Chetri", v.getVendorLName());
        assertEquals("emo@example.com", v.getVendorEmail());
        assertEquals(4, v.getRating());
        

    }

    /**
     * Test for Parameterised Constructor
     */

    @Test
    public void testVendorP() {
        Vendor v = new Vendor(1, "9999992224","Sunil", "Chetri","demo@example.com",4);
        
        assertEquals(1, v.getVendorId());
        assertEquals("9999992224", v.getVendorPhoneNo());
        assertEquals("Sunil", v.getVendorFName());
        assertEquals("Chetri", v.getVendorLName());
        assertEquals("emo@example.com", v.getVendorEmail());
        assertEquals(4, v.getRating());
        
        

    }

    /**
     * Test method for setVendorId
     */

    @Test
    public void testSetVendorId() {

        Vendor v = new Vendor();
        v.setVendorId(1);
        assertEquals(1, v.getVendorId());
    }

    /**
     * Test method for GetVendorId
     */

    @Test
    public void testGetVendorId() {

        Vendor v = new Vendor(1, "9999992224", "Sunil", "Chetri", "demo@example.com", 4);
        assertEquals(1, v.getVendorId());
    }
    
    @Test
    public void testSetVendorPhoneNo() {
        Vendor v = new Vendor();
        v.setVendorPhoneNo("9999992224");
        assertEquals("9999992224", v.getVendorPhoneNo());
    }

    /**
     * Test Method for getEVendorPhoneNo
     */
    @Test
    public void testGetVendorPhoneNo() {
        Vendor v = new Vendor(1, "9999992224", "Sunil", "Chetri", "demo@example.com", 4);
        assertEquals("9999992224", v.getVendorPhoneNo());
    }
    /**
     * Test method for setVendorFName
     */

    @Test
    public void testSetVendorrFName() {

        Vendor v = new Vendor();
        v.setVendorFName("Sunil");
        assertEquals("Sunil", v.getVendorFName());
    }

    /**
     * Test method for getVendorName
     */

    @Test
    public void testGetVendorFName() {
        Vendor v = new Vendor(1, "9999992224", "Sunil", "Chetri", "demo@example.com", 4);
        assertEquals("Sunil", v.getVendorFName());
    }

    /**
     * Test Method for setVendorLName
     */

    @Test
    public void testSetVendorLName() {

        Vendor v = new Vendor();
        v.setVendorLName("Chetri");
        assertEquals("Chetri", v.getVendorLName());
    }

    /**
     * Test Method for getVendorLName
     */

    @Test
    public void testGetVendorLName() {

        Vendor v = new Vendor(1, "9999992224", "Sunil", "Chetri", "demo@example.com", 4);
        assertEquals("Chetri", v.getVendorLName());
    }


    /**
     * Test Method for setVendorEmail
     */

    @Test
    public void testSetVendorEmail() {
        Vendor v = new Vendor();
        v.setVendorEmail("emo@example.com");
        assertEquals("emo@example.com", v.getVendorEmail());

    }

    /**
     * Test Method for getVendorEmail
     */

    @Test
    public void testGetVendorEmail() {
        Vendor v = new Vendor(1, "9999992224", "Sunil", "Chetri", "demo@example.com", 4);
        assertEquals("emo@example.com", v.getVendorEmail());
    }

    /**
     * Test Method for setRating
     */

    @Test
    public void testSetRating() {
        Vendor v = new Vendor();
        v.setRating(4);
        assertEquals(4, v.getRating());
    }

    /**
     * Test Method for getRating
     */

    @Test
    public void testGetRating() {
        Vendor v = new Vendor(1, "9999992224", "Sunil", "Chetri", "demo@example.com", 4);
        assertEquals(4, v.getRating());
    }
    
}
