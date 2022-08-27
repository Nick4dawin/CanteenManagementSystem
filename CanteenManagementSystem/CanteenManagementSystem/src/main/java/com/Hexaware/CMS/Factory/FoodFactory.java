package com.Hexaware.CMS.Factory;


import java.util.List;
import com.Hexaware.CMS.Model.Food;
import com.Hexaware.CMS.Persistence.FoodDb;

/**Factory Class for Food
 * @author Sagnik Bhattacharjee
*/
public class FoodFactory {
    
    /**
     * list all Foods
     * @return Food Array
     */
    public static Food[] listAllFoods() {
        List<Food> list = FoodDb.listAllFoods();
        Food[] foods = list.toArray(new Food[list.size()]);
        return foods;
    }   

    /**
     * get food Details for a particular food
     * @param id foodCode int
     * @return Food object
     */
    public static Food getFoodDetails(int id) {
        Food foods = FoodDb.getFoodDetails(id);
        return foods;
    }

    /**
     * flter food by cusine
     * @param br cuisine String
     * @return Food Array
     */
    public static Food[] filterByCuisine(String br) {
        List<Food> list = FoodDb.filterByCuisine(br);
        Food[] foods = list.toArray(new Food[list.size()]);
        return foods;
    }
    
    /**
     * filter food by Vendor
     * @param id vendorId int
     * @return Food Array
     */

    public static Food[] filterByVendor(int id) {
        List<Food> list = FoodDb.listByVendor(id);
        Food[] foods = list.toArray(new Food[list.size()]);
        return foods;
    }

    /**
     * filter food by veg/non-veg
     * @param vegNonVeg hasNonVeg boolean
     * @return Food Array
     */
    public static Food[] listByHasVegNonVeg(boolean vegNonVeg) {
        List<Food> list = FoodDb.listByHasVegNonVeg(vegNonVeg);
        Food[] foods = list.toArray(new Food[list.size()]);
        return foods;
    }

    /**
     * order food by Calorie
     * @return Food Array
     */
    public static Food[] orderByCalorie() {
        List<Food> list = FoodDb.orderByCalorie();
        Food[] foods = list.toArray(new Food[list.size()]);
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

   public static int registerFoodDetails(String name,double price,String cuisine,boolean hasNonVeg,double calorie,int vId){
       
       int res = FoodDb.insertNewFoodDetails(name,price,cuisine,hasNonVeg,calorie,vId);
       return res;
   }

   /**
   * to update Food price.
   * @param id foodCode int
   * @param rate foodPrice double
   * @return int
   */

    public static int updateFoodPrice(int id, double rate) {

    int res = FoodDb.updatePrice(id,rate);
    return res;
    
    }


}
