package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Model.Login;
import com.Hexaware.CMS.Persistence.LoginDB;

/**
 * Factory class for Login
 * @author Sagnik Bhattacharjee
 */

public class LoginFactory {
    
    /**
     * retrieve user by username
     * @param name username String
     * @returnLogin object
     */
    public static Login getUserByUserName(String name) {
        Login l = LoginDB.retrieveUserByUserName(name);
        return l;
    }

    /**
   * to register a new user.
   * @param user username String
   * @param pass password String
   * @return int
   */
    public static int registerUser(String user, String pass) {
        int res = LoginDB.registerUser(user, pass);
        return res;
    }

    /**
   * to change the password
   * @param user username String
   * @param pass password String
   * @return int
   */
    public static int updatePassword(String user, String pass) {
        int r = LoginDB.updatePassword(user, pass);
        return r;
    }
}