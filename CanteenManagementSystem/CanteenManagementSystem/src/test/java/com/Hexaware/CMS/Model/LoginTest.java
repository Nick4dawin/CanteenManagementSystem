package com.Hexaware.CMS.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LoginTest{



    @Test
    public void testLogin(){
        Login l = new Login();
        l.setUserName("Sagnik@example.com");
        l.setPassCode("pass123");

        assertEquals("Sagnik@example.com",l.getUserName());
        assertEquals("pass123",l.getPassCode());
    }

    @Test
    public void testLoginP(){
        Login l = new Login("demo@example.com","pass123");
        assertEquals("demo@example.com",l.getUserName());
        assertEquals("pass123",l.getPassCode());
    }

    @Test
    public void testGetUserName(){
        Login l = new Login("demo@example.com","pass123");
        assertEquals("demo@example.com",l.getUserName());
    }

     @Test
    public void testGetPasscode(){
        Login l = new Login("demo@example.com","pass123");
        assertEquals("pass123",l.getPassCode());
    }

    @Test
    public void testSetUserName(){
        Login l = new Login();
        l.setUserName("demo@example.com");
        assertEquals("demo@example.com",l.getUserName());
    }

    @Test
    public void testSetPassCode(){
        Login l = new Login();
        l.setPassCode("passcode");
        assertEquals("passcode",l.getPassCode());
    }

}