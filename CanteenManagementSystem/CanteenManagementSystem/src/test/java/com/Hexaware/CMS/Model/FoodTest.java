package com.Hexaware.CMS.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FoodTest{

    /**
    Test for default constructor
     */

    @Test

    public void testFood(){
        Food f = new Food();
        f.setFoodCode(100);
        f.setFoodName("Chicken Pizza");
        f.setFoodPrice(300);
        f.setCuisine("Italian");
        f.setHasNonVeg(true);
        f.setCalorie(440.00);
        f.setVendorId(201);
        
        assertEquals(100,f.getFoodCode());
        assertEquals("Chicken Pizza",f.getFoodName());
        assertEquals(300,f.getFoodPrice());
        assertEquals("Italian",f.getCuisine());
        assertEquals(true,f.getHasNonVeg());
        assertEquals(440.00,f.getCalorie(),0);
        assertEquals(201,f.getvendorId());

    }

    /**
    Test for Parameterised Constructor */

    @Test

    public void testFoodP(){
        Food f = new Food (100,"Chicken Pizza",300,"Italian",true,440.00,201);
        assertEquals(100,f.getFoodCode());
        assertEquals("Chicken Pizza",f.getFoodName());
        assertEquals(300,f.getFoodPrice());
        assertEquals("Italian",f.getCuisine());
        assertEquals(true,f.getHasNonVeg());
        assertEquals(440.00,f.getCalorie(),0);
        assertEquals(201,f.getvendorId());    
    }

    @Test
    public void testGetFoodCode(){
        Food f = new Food(100,"Chicken Pizza",300,"Italian",true,440.00,201);
        assertEquals(100,f.getFoodCode());
    }

    @Test
    public void testGetFoodName(){
        Food f = new Food(100,"Chicken Pizza",300,"Italian",true,440.00,201);
        assertEquals("Chicken Pizza",f.getFoodName());
    }

    @Test
    public void testGetFoodPrice(){
        Food f = new Food(100,"Chicken Pizza",300,"Italian",true,440.00,201);
        assertEquals(300,f.getFoodPrice());
    }

    @Test
    public void testGetCuisine(){
        Food f = new Food(100,"Chicken Pizza",300,"Italian",true,440.00,201);
        assertEquals("Italian",f.getCuisine());
    }

    @Test
    public void testGetHasNonVeg(){
        Food f = new Food(100,"Chicken Pizza",300,"Italian",true,440.00,201);
        assertEquals(true,f.getHasNonVeg());
    }

    @Test
    public void testGetCalorie(){
        Food f = new Food(100,"Chicken Pizza",300,"Italian",true,440.00,201);
        assertEquals(440.00,f.getCalorie(),0);
    }

    @Test
    public void testGetVendorId(){
        Food f = new Food(100,"Chicken Pizza",300,"Italian",true,440.00,201);
        assertEquals(201,f.getvendorId());
    }


    @Test
    public void testSetFoodCode(){
        Food f = new Food();
        f.setFoodCode(100);
        assertEquals(100,f.getFoodCode());
    }

     @Test
    public void testSetFoodName(){
        Food f = new Food();
        f.setFoodName("Chicken");
        assertEquals("Chicken",f.getFoodName());
    }

     @Test
    public void testSetFoodPrice(){
        Food f = new Food();
        f.setFoodPrice(400);
        assertEquals(400,f.getFoodPrice());
    }


     @Test
    public void testSetCuisine(){
        Food f = new Food();
        f.setCuisine("Indian");
        assertEquals("Indian",f.getCuisine());
    }

     @Test
    public void testSetHasNonVeg(){
        Food f = new Food();
        f.setHasNonVeg(true);
        assertEquals(true,f.getHasNonVeg());
    }

     @Test
    public void testSetCalorie(){
        Food f = new Food();
        f.setCalorie(150.00);
        assertEquals(150.00,f.getCalorie(),0);
    }

    @Test
    public void testVendorId(){
        Food f = new Food();
        f.setVendorId(250);
        assertEquals(250,f.getvendorId());
    }
}