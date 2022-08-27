package com.Hexaware.CMS.Model;

/**
LOGIN CLASS
@author Sagnik Bhattacharjee */

public class Login{
    private String userName;
    private String passCode;

/**
 * getter method for userName
 * @return String
 */
public String getUserName(){
    return userName;
}

/**
 * Setter method for userName
 * @param name userName String
 */
public void setUserName(String name){
    this.userName = name;
}

/**
 * getter method for passCode
 * @return String
 */

public String getPassCode(){
    return passCode;
}

/**
 * setter method for passCode
 * @param pass String
 */

public void setPassCode(String pass){
    this.passCode = pass;
}


/**Default Constructor for Login */
public Login(){

}

/**
 * Parameterized Constructor for Login
 * @param name userName String
 * @param pass passCode String
 */
public Login(String name,String pass){
    this.userName = name;
    this.passCode = pass;
}
}