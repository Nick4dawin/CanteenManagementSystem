package com.Hexaware.CMS.Factory;

import java.sql.Date;
import java.util.List;

import com.Hexaware.CMS.Model.OrderList;
import com.Hexaware.CMS.Persistence.OrderListDB;

/**
Factory Class for OrderList 
@author Sagnik Bhattacharjee*/

public class OrderListFactory{

    
/**
Retrieve Customer Order History
@param custId customerId int
@return OrderList array
 */

public static OrderList[] getCustomerHistory(int custId){
    List<OrderList> list =  OrderListDB.customerHistory(custId);
    OrderList[] orderList = list.toArray(new OrderList[list.size()]);
    return orderList;
}


/**
Retrieve Vendor Order History
@param vendorId vendorId int
@return OrderList array
 */

public static OrderList[] getVendorHistory(int vendorId){
    List<OrderList> list =  OrderListDB.vendorHistory(vendorId);
    OrderList[] orderList = list.toArray(new OrderList[list.size()]);
    return orderList;
}

/**
Retrieve Current Pending  Order for Customer
@param custId customerId int
@return OrderList array
 */

public static OrderList[] getPendingOrdersC(int custId){
    List<OrderList> list =  OrderListDB.pendingOrdersC(custId);
    OrderList[] orderList = list.toArray(new OrderList[list.size()]);
    return orderList;
}

/**
Retrieve Current Pending Orders for Vendor
@param vendorId vendorId int
@return OrderList array
 */

public static OrderList[] getPendingOrdersV(int vendorId){
    List<OrderList> list =  OrderListDB.pendingOrdersV(vendorId);
    OrderList[] orderList = list.toArray(new OrderList[list.size()]);
    return orderList;
}

/**
Retrieve Order Details
*@param id orderId int
*@return OrderList object  */

public static OrderList getOrderDetails(int id){
    OrderList order = OrderListDB.orderDetails(id);
    return order;
}


 /**
   * to add new Order Details
   * @param custId customerId int
   * @param tot totalPrice double
   * @param foodCode foodCode int
   * @param date orderDate Date
   * @param qty quantity int
   * @param vId vendorId int
   * @param stat status String
   * @return int
   */

    
    public static int completeFoodOrder(int custId,double tot,int foodCode,Date orderDate,String stat,int vId,int qty){
        int r = OrderListDB.completeFoodOrder(custId,tot,foodCode,orderDate,stat,vId,qty);
        return r;
    }



/**
   * to update Order status
   * @param orderId orderId int
   * @param stat orderStatus String
   * @return int
   */


   public static int updateOrderStatus(int orderId,String stat){
   int r=OrderListDB.updateOrderStatus(orderId,stat);
   return r;
   }

   /**
  List all Pending and Complete Orders for Current Day for Customer
  *@param custId customerId int
  *@return OrderList array
  */

  public static OrderList[] listAllOrdersForToday(int custId){
      List <OrderList> list  =OrderListDB.listAllOrdersForToday(custId);
    OrderList[] orderList = list.toArray(new OrderList[list.size()]);
    return orderList; 
  }



}