/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.safelogin;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class SafeLogin {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
    //=====Registration=====
    System.out.println("===Registration===");
    
    System.out.print("Enter your username: ");
    String username = scanner.nextLine();
    
    System.out.print("Enter your password: ");
    String password = scanner.nextLine();
    
    //=====Login=====
    System.out.println("\n===Login===");
    
    System.out.print("Enter your username: ");
    String loginUsername = scanner.nextLine();
    
    System.out.print("Enter your password: ");
    String loginPassword = scanner.nextLine();
    
    //=====Validation=====
    if(loginUsername.equals(username)&&loginPassword.equals(password)){
        System.out.println("Login successful. Welcome");
  
    }
    else{
        System.out.println("Login failed. Incorrect username or password ");
    }
  }
}
