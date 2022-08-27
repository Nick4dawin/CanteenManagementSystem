package com.Hexaware.CMS.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.Hexaware.CMS.Model.Food;

/**
 * DB class for Food
 * @author Sagnik Bhattacharjee
 */

public class FoodDb{


  /**
   * Return Last Food Id
   * @return int
   */
  private static int getLastFoodId() {
    String sql = "SELECT foodCode FROM food WHERE foodCode = (SELECT MAX(foodCode) FROM food)";
    int id = 0;

    try {
      // register the driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      // create the connection
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");

      // create the statement -> Statement interface and PreparedStatement interface
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(sql); // => fire a select statement
      while (rs.next()) {
        id = rs.getInt("foodCode");
      }
      con.close();
    } catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage() + ", " + e.getErrorCode());
    }
    return id;
  } 

    /**
     * list all Foods
     * @return list of Food
     */

    public static List<Food> listAllFoods(){
        List<Food> foods = new ArrayList<Food>();
        String sql = "SELECT * FROM food";

        try{
            //registering the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Password123");
            //Creating a Statement
            Statement stmt = con.createStatement();
            //Executing a statement
            ResultSet rs = stmt.executeQuery(sql);


            while(rs.next()){
                Food food = new Food();
                food.setFoodCode(rs.getInt("foodCode"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodPrice(rs.getInt("foodPrice"));
                food.setCuisine(rs.getString("cuisine"));
                food.setHasNonVeg(rs.getBoolean("hasNonVeg"));
                food.setCalorie(rs.getDouble("calorie"));
                food.setVendorId(rs.getInt("vendorId"));

                foods.add(food);
            }
            con.close();
        }
         catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage() + ", " + e.getErrorCode());
    }
    return foods;
    }

    /**
     * Get Food Details for a particular FoodCode
     * @param id  int foodCode 
     * @return Food Object
     */

    public static Food getFoodDetails(int id){
        String sql="SELECT * FROM FOOD WHERE FOODCODE=?";
        Food food = new Food();
        try{
           //Registering driver
            Class.forName("com.mysql.cj.jdbc.Driver");

      // create the connection
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");
      PreparedStatement stmt=con.prepareStatement(sql);
      stmt.setInt(1,id);
      ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            food.setFoodCode(rs.getInt("foodCode"));
            food.setFoodName(rs.getString("foodName"));
            food.setFoodPrice(rs.getInt("foodPrice"));
            food.setCuisine(rs.getString("cuisine"));
            food.setHasNonVeg(rs.getBoolean("hasNonVeg"));
            food.setCalorie(rs.getDouble("calorie"));
            food.setVendorId(rs.getInt("vendorId"));
        }
        con.close();
        }
        catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage() + ", " + e.getErrorCode());
    }

    return food;


     }


      /**
       * Filter food by Cuisine
       * @param cuis String cuisine
       * @return List of Food
       */

        public static List<Food> filterByCuisine(String cuis){
            List<Food> foods=new ArrayList<Food>();
            String sql = "SELECT * FROM FOOD WHERE CUISINE = ?";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

      // create the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");

                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, cuis);
                ResultSet rs = stmt.executeQuery();

                 while(rs.next()){
                Food food = new Food();
            food.setFoodCode(rs.getInt("foodCode"));
            food.setFoodName(rs.getString("foodName"));
            food.setFoodPrice(rs.getInt("foodPrice"));
            food.setCuisine(rs.getString("cuisine"));
            food.setHasNonVeg(rs.getBoolean("hasNonVeg"));
            food.setCalorie(rs.getDouble("calorie"));
            food.setVendorId(rs.getInt("vendorId"));
                
                foods.add(food);
            }
            con.close();
        }catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage() + ", " + e.getErrorCode());
    }
    return foods;
}


  /**
   * list food by veg or non veg
   * @param vegNonVeg boolean hasVegNonVeg
   * @return List of Food
   */

    public static List<Food> listByHasVegNonVeg(boolean vegNonVeg){
        List<Food> foods=new ArrayList<Food>();
            String sql = "SELECT * FROM FOOD WHERE hasNonVeg = ?";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

      // create the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");

                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setBoolean(1, vegNonVeg);
                ResultSet rs = stmt.executeQuery();

                 while(rs.next()){
                Food food = new Food();
            food.setFoodCode(rs.getInt("foodCode"));
            food.setFoodName(rs.getString("foodName"));
            food.setFoodPrice(rs.getInt("foodPrice"));
            food.setCuisine(rs.getString("cuisine"));
            food.setHasNonVeg(rs.getBoolean("hasNonVeg"));
            food.setCalorie(rs.getDouble("calorie"));
            food.setVendorId(rs.getInt("vendorId"));
                
                foods.add(food);
            }
            con.close();
        }catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage() + ", " + e.getErrorCode());
    }
    return foods;
    }


    /**
     * Order food by calorie in ascending order
     * @return List of Food 
     */
    public static List<Food> orderByCalorie(){
        List<Food> foods=new ArrayList<Food>();
            String sql = "SELECT * FROM FOOD ORDER BY CALORIE ?";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

                // create the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");

                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                 while(rs.next()){
                Food food = new Food();
            food.setFoodCode(rs.getInt("foodCode"));
            food.setFoodName(rs.getString("foodName"));
            food.setFoodPrice(rs.getInt("foodPrice"));
            food.setCuisine(rs.getString("cuisine"));
            food.setHasNonVeg(rs.getBoolean("hasNonVeg"));
            food.setCalorie(rs.getDouble("calorie"));
            food.setVendorId(rs.getInt("vendorId"));
                
                foods.add(food);
            }
            con.close();
        }catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage() + ", " + e.getErrorCode());
    }
    return foods;
    }

  /**
   * insert new Food details.
   * @param name foodName String
   * @param price foodPrice double
   * @param cuisine Cuisine String
   * @param hasNonVeg hasNonVeg boolean
   * @param calorie calorie double 
   * @param vId vendorId int
   * @return int
   */

   public static int insertNewFoodDetails(String name,double price,String cuisine,boolean hasNonVeg,double calorie,int vId){
     int res = 0;
     String sql = "Insert into food (foodCode,foodName,foodPrice,cuisine,hasNonVeg,calorie,vendorId) values (?,?,?,?,?,?,?)";
     int id = getLastFoodId();
     if(id == 0){
       id = 2001;
     }
     else{
       ++id;
     }

     try{
       // register the driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      // create the connection
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");


      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1,id);
      ps.setString(2,name);
      ps.setDouble(3,price);
      ps.setString(4,cuisine);
      ps.setBoolean(5,hasNonVeg);
      ps.setDouble(6,calorie);
      ps.setDouble(7,vId);

      res = ps.executeUpdate();
      con.close();
     }catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage() + ", " + e.getErrorCode());
    }
    return res;
   }

  /**
   * to update Food price.
   * @param id foodCode int
   * @param rate foodPrice double
   * @return int
   */

    public static int updatePrice(int id, double rate) {
    String sql = "UPDATE food SET foodPrice = ? WHERE foodCode = ?";
    int res = 0;
    try {
      // register the driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      // create the connection
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");

      PreparedStatement ps = con.prepareStatement(sql);
      ps.setDouble(1, rate);
      ps.setInt(2, id);

      res = ps.executeUpdate();

      con.close();
    } catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage() + ", " + e.getErrorCode());
    }

    return res;
  }

  /**
   * get list of Food based on Vendor
   * @param id vendorId int
   * @return List of food
   */
  public static List<Food> listByVendor(int id) {
    List<Food> foods = new ArrayList<Food>();
    String sql = "SELECT * FROM food WHERE vendorId = ?";
    try {
      // register the driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      // create the connection
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagnikb_cms?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Password123");

      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        Food food = new Food();
        food.setFoodCode(rs.getInt("foodCode"));
        food.setFoodName(rs.getString("foodName"));
        food.setFoodPrice(rs.getInt("foodPrice"));
        food.setCuisine(rs.getString("cuisine"));
        food.setHasNonVeg(rs.getBoolean("hasNonVeg"));
        food.setCalorie(rs.getDouble("calorie"));
        food.setVendorId(rs.getInt("vendorId"));
        foods.add(food);
      }
      con.close();
    } catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage() + ", " + e.getErrorCode());
    }

    return foods;
  }
  

}
