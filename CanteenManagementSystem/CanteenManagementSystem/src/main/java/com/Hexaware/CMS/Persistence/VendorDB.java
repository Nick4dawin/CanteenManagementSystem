package com.Hexaware.CMS.Persistence;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import com.Hexaware.CMS.Model.Vendor;

/**
 * DB class for Vendor
 * @author Sagnik Bhattacharjee
 */

public class VendorDB{
     protected final static String user = "root";
    protected final static String pass = "Password123";
    protected final static String url = "jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    /**
     * to retrieve Vendor details by id.
     * @param id vendor id int
     * @return Vendor object
     */

    public static Vendor getVendorById(int id){
        String sql = "SELECT * FROM VENDOR WHERE vendorId = ?";
        Vendor v = new Vendor();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                v.setVendorId(rs.getInt("vendorId"));
                v.setVendorFName(rs.getString("vendorFName"));
                v.setVendorLName(rs.getString("vendorLName"));
                v.setVendorEmail(rs.getString("vendorEmail"));
                v.setVendorPhoneNo(rs.getString("vendorPhoneNo"));
                v.setRating(rs.getInt("rating"));

            }
        con.close();
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return v;
        
        }
    
     /**
     * retrieve vendor by email
     * @param email email String
     * @return Vendor object
     */
     public static Vendor getVendorByEmail(String email){
         String sql = "SELECT * FROM VENDOR WHERE vendorEmail = ?";
         Vendor v = new Vendor();

         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                v.setVendorId(rs.getInt("vendorId"));
                v.setVendorFName(rs.getString("vendorFName"));
                v.setVendorLName(rs.getString("vendorLName"));
                v.setVendorEmail(rs.getString("vendorEmail"));
                v.setVendorPhoneNo(rs.getString("vendorPhoneNo"));
                v.setRating(rs.getInt("rating"));
         }
            con.close();
         }
         catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return v;
     }

    
    /**
    *update Ratings 
    *@param id vendorId int
    *@param rating rating int
    *@return int
    */ 
    public static int updateRating(int id, int rating) {
    int res = 0;
    String sql = "UPDATE vendor SET rating = ? WHERE vendorId = ?";

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, user, pass);

      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setInt(1, rating);
      stmt.setInt(2, id);

      res = stmt.executeUpdate();

      con.close();
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return res;
  }
     
    }



