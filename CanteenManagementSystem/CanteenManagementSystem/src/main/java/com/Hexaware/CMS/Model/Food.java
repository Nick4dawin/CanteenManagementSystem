package com.Hexaware.CMS.Model;

/**
 * Model Class for Customer
 * @author Sagnik Bhattacharjee
 */

public class Food{
    private int foodCode;
    private String foodName;
    private int foodPrice;
    private String cuisine;
    private boolean hasNonVeg;
    private double calorie;
    private int vendorId;

    /**
     * getter method for foodCode
     * @return int
     */
    public int getFoodCode(){
        return foodCode;
    }


    /**
     * getter method for foodName
     * @return String
     */
    public String getFoodName(){
        return foodName;
    }

    /**
     * getter method for foodPrice
     * @return int
     */
    public int getFoodPrice(){
        return foodPrice;
    }
    
    /**
     * getter method for cuisine
     * @return String
     */
    public String getCuisine(){
        return cuisine;
    }

    /**
     * getter method for hasNonVeg
     * @return boolean
     */
    public boolean getHasNonVeg(){
        return hasNonVeg;
    }

    /**
     * getter method for calorie
     * @return double
     */
    public double getCalorie(){
        return calorie;
    }

    /**
     * getter method for vendorId
     * @return int
     */
    public int getvendorId(){
        return vendorId;
    }

    /**
     * Setter Method for foodCode
     * @param argFoodCode FoodCode int
     */
    public void setFoodCode(int argFoodCode){
        this.foodCode = argFoodCode;
    }

    /**
     * Setter Method for foodName
     * @param argFoodName foodName String
     */
    public void setFoodName(String argFoodName){
        this.foodName = argFoodName;
    }

    /**
     * Setter method for foodPrice
     * @param argFoodPrice foodPrice int
     */
    public void setFoodPrice(int argFoodPrice){
        this.foodPrice = argFoodPrice;
    }

    /**
     * Setter Method for cuisine
     * @param argCusine cuisine String
     */
    public void setCuisine(String argCusine){
        this.cuisine = argCusine;
    }

    /**
     * Setter method for hasNonVeg
     * @param argHasNonVeg hasNonVeg boolean
     */
    public void setHasNonVeg(boolean argHasNonVeg){
        this.hasNonVeg = argHasNonVeg;
    }

    /**
     * Setter method for Calorie
     * @param argCalorie calorie double
     */
    public void setCalorie(double argCalorie){
        this.calorie = argCalorie;
    }

    /**
     * Setter method for vendorId
     * @param argVendorId vendorId int 
     */
    public void setVendorId(int argVendorId){
        this.vendorId = argVendorId;
    }

    /**Default Constructor for Food */
    public Food(){

    }

    
    /**
     * Parameterized constructor for food
     * @param argFoodCode foodCode int
     * @param argFoodName foodName String
     * @param argFoodPrice foodPrice int
     * @param argCusine cuisine String
     * @param argHasNonVeg hasNonVeg boolean
     * @param argCalorie calorie double
     * @param argVendorId vendorId int
     */
    public Food(final int argFoodCode,final String argFoodName,final int argFoodPrice,final String argCusine,final boolean argHasNonVeg,final double argCalorie, final int argVendorId ){
        this.foodCode = argFoodCode;
        this.foodName = argFoodName;
        this.foodPrice = argFoodPrice;
        this.cuisine = argCusine;
        this.hasNonVeg = argHasNonVeg;
        this.calorie = argCalorie;
        this.vendorId = argVendorId;
    }

}