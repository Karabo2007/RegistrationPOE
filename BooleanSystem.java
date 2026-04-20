/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.booleansystem;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class BooleanSystem {
    
    static String regUsername;
    static String regPassword;
    static String regPhonenumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== USER REGISTRATION SYSTEM ===");
        
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter your South African cell phone number: ");
        String phoneNumber = scanner.nextLine();
        
        boolean validUsername = username.contains("_") && username.length()<=5;
        
        boolean validPassword = password.length()>=8;
        
        boolean validPhonenumber = phoneNumber.matches("\\+27\\d{9}");
        
        boolean registered = validUsername && validPassword && validPhonenumber;
        
        if (registered){
            regUsername = username;
            regPassword = password;
            regPhonenumber = phoneNumber;
            
            System.out.println("\n User successfully registered! ");
            
        }else{
           System.out.println("\n Registration failed. ");
           return;
        }
        
        // ================= LOGIN ATTEMPTS =================
        
        System.out.println("\n=== LOGIN SYSTEM ===");
        
        boolean loggedIn = false;
        
        for (int i = 1; i <= 3; i++){
            
            System.out.println("\nAttempt" + i + " of 3");
            
            System.out.print("Enter your username: ");
            String loginUsername = scanner.nextLine();
            
            System.out.print("Enter your password: ");
            String loginPassword = scanner.nextLine();
            
            if (loginUsername.equals(regUsername) && loginPassword.equals(regPassword)){
                loggedIn = true; break;
                
            } else {
                System.out.println("Incorrect details");
            }
        }
        if (loggedIn) {
            System.out.println("\n Login successful. Welcome " + regUsername + "!");
        } else {
            System.out.println("\n Too many failed attempts. Access blocked.");
            
        }
        
        scanner.close();
        
    }
}
