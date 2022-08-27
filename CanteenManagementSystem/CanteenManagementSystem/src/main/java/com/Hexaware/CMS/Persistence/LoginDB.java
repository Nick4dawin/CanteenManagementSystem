package com.Hexaware.CMS.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Hexaware.CMS.Model.Login;

/**
 * DB Class for Login
 * @author Sagnik Bhattacharjee
 */

public class LoginDB {
  /**
   * retrieve user by username
   * @param name username String
   * @return Login object
   */
  public static Login retrieveUserByUserName(String name) {
    String sql = "SELECT * FROM LOGIN WHERE USERNAME = ?";
    Login login = new Login();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");

      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, name);
      ResultSet rs = stmt.executeQuery();
      while(rs.next()) {
        login.setUserName(rs.getString("userName"));
        login.setPassCode(rs.getString("password"));
      }
      con.close();
    } catch(ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } catch(SQLException ex) {
      System.out.println(ex.getErrorCode() + ", " + ex.getMessage());
    }
    return login;
  }

  /**
   * to register a new user.
   * @param user username String
   * @param pass password String
   * @return int
   */
  public static int registerUser(String user, String pass) {
    String sql = "INSERT INTO LOGIN VALUES (?, ?)";
    int res = 0;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");

      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, user);
      stmt.setString(2, pass);
      res = stmt.executeUpdate();
      con.close();
    } catch(ClassNotFoundException e) {
        System.out.println(e.getMessage());
    } catch(SQLException ex) {
        System.out.println(ex.getErrorCode() + ", " + ex.getMessage());
    }
    return res;
  }

  /**
   * to change the password
   * @param user username String
   * @param pass password String
   * @return int
   */
  public static int updatePassword(String user, String pass) {
    String sql = "UPDATE LOGIN SET password = ? WHERE USERNAME = ?";
    int res = 0;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");

      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, pass);
      stmt.setString(2, user);
      res = stmt.executeUpdate();
      con.close();
    } catch(ClassNotFoundException e) {
        System.out.println(e.getMessage());
    } catch(SQLException ex) {
        System.out.println(ex.getErrorCode() + ", " + ex.getMessage());
    }
    return res;
  }
}