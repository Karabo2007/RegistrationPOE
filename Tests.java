/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tests;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Tests {

    public static void main(String[] args ) {
        
            
        System.out.println("===RUNNING TESTS ===\n");
        
        //Username Tests
        testUsername("Kea"); //too short
        testUsername("Kea_3"); //valid
        
        //Password Tests
        testPassword("codekarabo99"); //weak
        testPassword("Code@karabo99"); //strong
        
        
        //Phonenumber Tests
        testPhonenumber("676033047"); //invalid
        testPhonenumber("0676033047"); //valid
        testPhonenumber("+27676033047"); //valid
        
        
        //Login Tests
        System.out.println("\n=== LOGIN TESTS ===");
        testLogin("Kea_3", "Code@karabo99", "Kea_3", "Code@karabo99"); //correct
        testLogin("Kea_3", "Code@karabo99", "Kea_3", "codekarabo99"); //incoorect password
        
       
    }
    
    // ===== TESTS METHODS =====
    
    public static void testUsername(String username) {
        System.out.println("Testing usrname:" +username);
        if(username.length()<=5){
           System.out.println("Result: VALID \n");
        }else{
            System.out.println("Result: Invalid");
        }      
    }
    public static void testPassword(String password) {
        System.out.println("Testing password:" +password);
        if(isValidPassword(password)){
            System.out.println("Result: Valid \n");
        }else{
            System.out.println("Result: Invalid \n");
        }
    }
    public static void testPhonenumber(String phonenumber) {
        System.out.println("Testing phonenumber:" +phonenumber);
        if(phonenumber.matches("0\\D{9}")||phonenumber.matches("\\+27\\d{9}")){
            System.out.println("Result: Valid \n");
        }else{
            System.out.println("Result: Invalid \n");
        }
    }
    public static void testLogin(String storedUser, String storedPass, String inputUser, String inputPass) {
        System.out.println("Testing login with:" +inputUser+ "/" +inputPass);
        if(storedUser.equals(inputUser) && storedPass.equals(inputPass)){
           System.out.println("Login Success \n");
      
        }else{
            System.out.println("Login Failed \n");    
        }
    
    }
    
    // Password validation
    public static boolean isValidPassword(String password) {
        return password.length()>=8 &&
            password.matches(".[A-Z].")&&
            password.matches(".\\d.")&&
            password.matches(".[^a-zA-Z0-9]");
    }
            
}   

