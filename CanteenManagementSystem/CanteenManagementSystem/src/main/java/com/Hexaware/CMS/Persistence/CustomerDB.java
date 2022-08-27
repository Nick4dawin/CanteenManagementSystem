package com.Hexaware.CMS.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Hexaware.CMS.Model.Customer;

/**
DB class for Customer.
@author Sagnik Bhattacharjee
 */

public class CustomerDB{
    protected final static String user = "root";
    protected final static String pass = "Password123";
    protected final static String url = "jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


  /**
   * to get the last customerid.
   * @return int
   */
    private static int getLastCustomerId() {
    String sql = "SELECT custID FROM CUSTOMER ORDER BY custId DESC limit 1";
    int id = 0;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);

      Statement ps = con.createStatement();
      ResultSet rs = ps.executeQuery(sql);
      while (rs.next()) {
        id = rs.getInt("custId");
      }
      con.close();
    } catch(ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return id;
  }

    /**
   * to get customer details based on id
   * @param id customerId int
   * @return Customer object
   */
  public static Customer getCustomerById(int id) {
    String sql = "SELECT * FROM CUSTOMER WHERE custId = ?";
    Customer customer = new Customer();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);

      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        customer.setCustId(rs.getInt("custId"));
        customer.setCustFName(rs.getString("custFName"));
        customer.setCustLName(rs.getString("custLName"));
        customer.setCustEmail(rs.getString("custEmail"));
        customer.setCustWalletBal(rs.getDouble("custWalletBal"));
        customer.setCustAdress(rs.getString("custAdress"));
        customer.setCustPhoneNo(rs.getString("custPhoneNo"));
      }
      con.close();
    } catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return customer;
  }

    /**
   * to get customer details based on email
   * @param email email String
   * @return Customer object
   */

  public static Customer getCustomerByEmail(String email){
      String sql = "SELECT * FROM CUSTOMER WHERE custEmail = ?";
        Customer customer = new Customer();

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);

        ResultSet rs = ps.executeQuery();
         while(rs.next()) {
        customer.setCustId(rs.getInt("custId"));
        customer.setCustFName(rs.getString("custFName"));
        customer.setCustLName(rs.getString("custLName"));
        customer.setCustEmail(rs.getString("custEmail"));
        customer.setCustWalletBal(rs.getDouble("custWalletBal"));
        customer.setCustAdress(rs.getString("custAdress"));
        customer.setCustPhoneNo(rs.getString("custPhoneNo"));
      }
      con.close();
    } catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return customer;
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

    public static int registerCustomer(String fName,String lName,String email,double wallet,String addr,String phoneNo){
        String sql = "INSERT INTO CUSTOMER(custId,custFName,custLName,custEmail,custWalletBal,custAdress,custPhoneNo)"
                    + "VALUES (?,?,?,?,?,?,?)";
        
        int res =0;
        int id = getLastCustomerId();

        if(id==0){
            id=4001;
        }
        else{
            ++id;
        }

         try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);

      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1,id);
      ps.setString(2,fName);
      ps.setString(3,lName);
      ps.setString(4,email);
      ps.setDouble(5,wallet);
      ps.setString(6,addr);
      ps.setString(7,phoneNo); 

      res = ps.executeUpdate();

      con.close();  
    }catch(ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return res;
        
  }
  /**
   * update the coupon for new customer
   * @param argId customerId int 
   * @param coupon coupon String
   * @return int
   */
  public static int updateCoupon(int argId, String coupon) {
    String sql = "UPDATE CUSTOMER SET COUPON = ? WHERE custId = ?";
    int res = 0;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);

      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, coupon);
      ps.setInt(2, argId);

      res = ps.executeUpdate();

      con.close();
    } catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException se) {
      System.out.println(se.getMessage());
    }

    return res;
  }

  /**
   * to update customer's address.
   * @param argId customerId int
   * @param addr String
   * @return int
   */
  public static int updateAddress(int argId, String addr) {
    String sql = "UPDATE CUSTOMER SET custAdress = ? WHERE custId = ?";
    int res = 0;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);

      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, addr);
      ps.setInt(2, argId);

      res = ps.executeUpdate();

      con.close();
    } catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException se) {
      System.out.println(se.getMessage());
    }

    return res;
  }

  /**
   * to increment or decrement the wallet
   * @param id customerId int
   * @param bal walletBalance double
   * @return int
   */
  public static int updateWallet(int id, double bal) {
    String sql = "UPDATE CUSTOMER SET custWalletBal = ? WHERE custId = ?";
    int res = 0;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);

      PreparedStatement ps = con.prepareStatement(sql);
      ps.setDouble(1, bal);
      ps.setInt(2, id);

      res = ps.executeUpdate(); // used for insert, update and delete statements

      con.close();
    } catch(ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return res;
  }

}
