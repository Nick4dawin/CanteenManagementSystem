package com.Hexaware.CMS.Model;
import java.time.LocalDate;


/**
 * Model Class for OrderList
 * @author Sagnik Bhattacharjee
 */


public class OrderList{
    private int orderId;
    private int custId;
    private double totalPrice;
    private int foodCode;
    private LocalDate orderDate ;
    private OrderStatus orderStatus;
    private int vendorId;
    private int quantity;

    /**
     * getter method for orderId
     * @return int
     */
    public int getOrderId(){
        return orderId;
    }

    /**
     * getter method for customerId
     * @return int
     */
    public int getcustId(){
        return custId;
    }

    /**
     * getter method for totalPrice
     * @return double
     */
    public double getTotalPrice(){
        return totalPrice;
    }

    /**
     * getter method for foodCode
     * @return int
     */
    public int getFoodCode(){
        return foodCode;
    }

    /**
     * getter method for OrderDate
     * @return LocalDate object
     */
    public LocalDate getOrderDate(){
        return orderDate;
    }

    /**
     * getter method for orderStatus
     * @return OrderStatus object
     */
    public OrderStatus getOrderStatus(){
        return orderStatus;
    }

    /**
     * getter method for vendorId
     * @return int
     */
    public int getVendorId(){
        return vendorId;
    }

    /**
     * getter method for quantity
     * @return int
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * setter method for orderId
     * @param argOrderId orderId int
     */
    public void setOrderId(int argOrderId){
        this.orderId = argOrderId;
    }

    /**
     * setter method for customerId
     * @param argCustId customerId int
     */
    public void setCustId(int argCustId){
        this.custId = argCustId;
    }

    /**
     * setter method for totalPrice
     * @param argTotalPrice totalPrice double
     */
    public void setTotalPrice(double argTotalPrice){
        this.totalPrice = argTotalPrice;
    }


    /**
     * setter method for foodCode
     * @param argFoodCode foodCode int
     */
    public void setFoodCode(int argFoodCode){
        this.foodCode = argFoodCode;
    }

    /**
     * setter method for orderDate
     * @param argOrderDate orderDate LocalDate
     */
    public void setOrderDate(LocalDate argOrderDate){
        this.orderDate =argOrderDate;
    }

    /**
     * setter method for orderStatus
     * @param argOrderStatus orderStatus OrderStatus
     */
    public void setOrderStatus(final String argOrderStatus){
        this.orderStatus = OrderStatus.valueOf(argOrderStatus);
    }
    
    /**
     * setter method for vendorId
     * @param argVendorId vendorId int
     */
    public void setVendorId(int argVendorId){
        this.vendorId = argVendorId;
    }

    /**
     * setter method for quantity
     * @param argQuantity quantity int
     */
    public void setQuantity(int argQuantity){
        this.quantity = argQuantity;
    }

    /**
     * Default Constructor
     */
    public OrderList(){

    }

    /**
     * Parameterized Constructor
     * @param argOrderId orderId int
     * @param argOrderDate orderDate LocalDate
     * @param argCustId customerId int
     * @param argFoodCode foodCode int
     * @param argVendorId vendorId int
     * @param argQty quantity int
     * @param argTotal totalPrice int
     * @param argStatus orderStatus OrderStatus
     */
    public OrderList(final int argOrderId,final LocalDate argOrderDate,final int argCustId,final int argFoodCode,final int argVendorId, final int argQty, final double argTotal,final OrderStatus argStatus){

        this.orderId = argOrderId;
        this.orderDate = argOrderDate;
        this.custId = argCustId;
        this.foodCode = argFoodCode;
        this.vendorId = argVendorId;
        this.quantity =argQty;
        this.totalPrice = argTotal;
        this.orderStatus = argStatus;

    }
}