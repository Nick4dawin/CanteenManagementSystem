package com.Hexaware.CMS.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.Hexaware.CMS.Model.OrderList;

/**
 * DB class for OrderList
 * @author Sagnik Bhattacharjee
 */

 public class OrderListDB{
    protected final static String user = "root";
    protected final static String pass = "Password123";
    protected final static String url = "jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=IST";


  
  

private static int getLastOrderId(){        
       String sql = "SELECT * FROM orderlist WHERE orderId = (SELECT MAX(orderId) from orderlist) ";
       int id = 0;

       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);

      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
     
     while (rs.next()) {
        id = rs.getInt("orderId");
      }
      con.close();
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return id;
  
}
     /**
   * orders history for vendor.
   @param id vendorId int
   * @return List of order
   */
     public static List<OrderList> vendorHistory(int id){
       List<OrderList> history =new ArrayList<OrderList>();

       String sql = "SELECT * FROM orderlist where vendorId = ?";
       
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection(url,user,pass);
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1,id);
           ResultSet rs = stmt.executeQuery();

           while (rs.next()){
               OrderList o = new OrderList();
               o.setOrderId(rs.getInt("orderId"));
               o.setCustId(rs.getInt("custId"));
               o.setTotalPrice(rs.getDouble("totalPrice"));
               o.setFoodCode(rs.getInt("foodCode"));
              Date day = rs.getDate("orderDate");
              o.setOrderDate(day.toLocalDate());

              o.setQuantity(rs.getInt("quantity"));
              o.setVendorId(rs.getInt("vendorId"));
              
              String stat = rs.getString("orderStatus");
              o.setOrderStatus(stat);

              history.add(o);
              }
      con.close();
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return history;
    }


     /**
   * orders history for customer.
   @param id customerId int
   * @return List of order
   */
     public static List<OrderList> customerHistory(int id){
       List<OrderList> history =new ArrayList<OrderList>();

       String sql = "SELECT * FROM orderlist where custId = ?";
       
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection(url,user,pass);
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1,id);
           ResultSet rs = stmt.executeQuery();

           while (rs.next()){
               OrderList o = new OrderList();
               o.setOrderId(rs.getInt("orderId"));
               o.setCustId(rs.getInt("custId"));
               o.setTotalPrice(rs.getDouble("totalPrice"));
               o.setFoodCode(rs.getInt("foodCode"));
              Date day = rs.getDate("orderDate");
              o.setOrderDate(day.toLocalDate());

              o.setQuantity(rs.getInt("quantity"));
              o.setVendorId(rs.getInt("vendorId"));
              
              String stat = rs.getString("orderStatus");
              o.setOrderStatus(stat);

              history.add(o);
              }
      con.close();
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return history;
    }

      /**
   * current Pending Orders for Customer.
   * @param id customerId int
   * @return list of purchases
   */

    public static List<OrderList> pendingOrdersC(int id){
        String sql = "SELECT * FROM ORDERLIST where date(orderDate) = current_date() and orderStatus = 'PENDING' "+"AND custId = ?";

        List<OrderList> list= new ArrayList<OrderList>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);
      
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      while (rs.next()){
               OrderList o = new OrderList();
               o.setOrderId(rs.getInt("orderId"));
               o.setCustId(rs.getInt("custId"));
               o.setTotalPrice(rs.getDouble("totalPrice"));
               o.setFoodCode(rs.getInt("foodCode"));
              Date day = rs.getDate("orderDate");
              o.setOrderDate(day.toLocalDate());

              o.setQuantity(rs.getInt("quantity"));
              o.setVendorId(rs.getInt("vendorId"));
              
              String stat = rs.getString("orderStatus");
              o.setOrderStatus(stat);

              list.add(o);
              }
              con.close();
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return list;
    
    }


    /**
   * current Pending Orders for Vendor.
   * @param id VendorId int
   * @return list of Orders
   */

     public static List<OrderList> pendingOrdersV(int id){
        String sql = "SELECT * FROM ORDERLIST where date(orderDate) = current_date() and orderStatus = 'PENDING' "+"AND vendorId = ?";

        List<OrderList> list= new ArrayList<OrderList>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);
      
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      while (rs.next()){
               OrderList o = new OrderList();
               o.setOrderId(rs.getInt("orderId"));
               o.setCustId(rs.getInt("custId"));
               o.setTotalPrice(rs.getDouble("totalPrice"));
               o.setFoodCode(rs.getInt("foodCode"));
              Date day = rs.getDate("orderDate");
              o.setOrderDate(day.toLocalDate());

              o.setQuantity(rs.getInt("quantity"));
              o.setVendorId(rs.getInt("vendorId"));
              
              String stat = rs.getString("orderStatus");
              o.setOrderStatus(stat);

              list.add(o);
              }
              con.close();
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return list;
    
    }

    /**
   * Order details.
   * @param id orderId int
   * @return OrderList object
   */

    public static OrderList orderDetails(int id){
        OrderList order = new OrderList();
        String sql = "SELECT * FROM ORDERLIST WHERE ORDERID = ?";
    try{

       Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);
      
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery(); 
    
      while (rs.next()){
               
               order.setOrderId(rs.getInt("orderId"));
               order.setCustId(rs.getInt("custId"));
               order.setTotalPrice(rs.getDouble("totalPrice"));
               order.setFoodCode(rs.getInt("foodCode"));
              Date day = rs.getDate("orderDate");
              order.setOrderDate(day.toLocalDate());

              order.setQuantity(rs.getInt("quantity"));
              order.setVendorId(rs.getInt("vendorId"));
              
              String stat = rs.getString("orderStatus");
              order.setOrderStatus(stat);
              }
              con.close();
    }

       catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return order;
  }

     /**
   * insert new Order details
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
        int res = 0;
        String sql = "INSERT INTO ORDERLIST(orderId,custId,totalPrice,foodCode,orderDate,orderStatus,vendorId,quantity) VALUES (?,?,?,?,?,?,?,?)";

        int order  = getLastOrderId();
        if(order == 0){
          order = 3001;
        }
        else{
          ++order;
        }


    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);
      
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1,order);
      ps.setInt(2,custId);
      ps.setDouble(3,tot);
      ps.setInt(4,foodCode);
      ps.setDate(5,orderDate);
      ps.setString(6,stat);
      ps.setInt(7,vId);
      ps.setInt(8,qty);

      res=ps.executeUpdate();

      con.close();
    }catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return res;

    }

  /**
   * to update Order status
   * @param orderId orderId int
   * @param stat orderStatus String
   * @return int
   */


   public static int updateOrderStatus(int orderId,String stat){
     String sql = "UPDATE orderList SET orderStatus = ? WHERE orderId = ?";
     int res =0;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);
      
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, stat);
      ps.setInt(2, orderId);

      res = ps.executeUpdate();

      con.close();
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return res;
  }
   

  /**
  List all Pending and Accepted Orders for Current Day for Customer
  *@param custId customerId int
  *@return List of Orders
  */

  public static List<OrderList> listAllOrdersForToday(int custId){
    String sql = "SELECT * FROM orderList where orderDate = CURRENT_DATE() and orderStatus in ('PENDING','ACCEPTED') AND custID = ?";
    List <OrderList> list = new ArrayList<>();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);
      
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, custId);

      ResultSet rs = ps.executeQuery();

      while (rs.next()){
          OrderList o = new OrderList();
          o.setOrderId(rs.getInt("orderId"));
          o.setCustId(rs.getInt("custId"));
          o.setTotalPrice(rs.getDouble("totalPrice"));
          o.setFoodCode(rs.getInt("foodCode"));
        Date day = rs.getDate("orderDate");
        o.setOrderDate(day.toLocalDate());

        o.setQuantity(rs.getInt("quantity"));
        o.setVendorId(rs.getInt("vendorId"));
        
        String stat = rs.getString("orderStatus");
        o.setOrderStatus(stat);

        list.add(o);
        }
        con.close();
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return list;
    
    }

           

}
    
       