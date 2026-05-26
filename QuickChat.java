/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.QuickChat ;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author User
 */
public class QuickChat {
    
    static Scanner input = new Scanner(System.in);
    
    // ArrayLists to store messages
    static ArrayList<String> messageIDs = new ArrayList<>();
    static ArrayList<String> messageHashes = new ArrayList<>();
    static ArrayList<String> recipients = new ArrayList<>();
    static ArrayList<String> messages = new ArrayList<>();
    
    // Counter for sent messages
    static int totalMessagesSent = 0;
    
    public static void main(String[] args) throws IOException {
        
    // =========================
    // LOGIN SECTION
    // =========================
        System.out.println("===== LOGIN =====");
        
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        // Simple login validation
        if (!username.isEmpty() && !password.isEmpty()){
             System.out.println("\nWelcome to QuickChat. ");
             
             int choice;
            
        // =========================
        // MENU LOOP
        // =========================
             
             do {
                 System.out.println("\n===== MENU =====");
                 System.out.println("1. Send Messages");
                 System.out.println("2. Show recently sent messages");
                 System.out.println("3. Quit");
                 System.out.println("Choose an option: ");
                 
                 choice = input.nextInt();
                 input.nextLine();
                 
                 switch (choice){
                     case 1: 
                         sendMessages();
                         break;
                     case 2:
                          System.out.println("Coming Soon.");
                          break;
                     case 3:
                          System.out.println("Exiting QuickChat...");
                          break;
                     default:
                          System.out.println("Invalid option.");
                 }
               
             } while (choice != 3);
             
                // Displayntotal messages
             System.out.println("\n===== TOTAL =====");
             System.out.println("Total messages sent: " + totalMessagesSent);
             
             } else {
             System.out.println("Login failed.");
            }
    }
            // =========================
            // SEND MESSAGE METHI=OD
            // =========================
    
    public static void sendMessages() throws IOException{
        
        System.out.print("\nHow many messages would you like to send? ");
        int numberOfMessages = input.nextInt();
        
        // FOR LOOP
        for (int i = 1; i <= numberOfMessages; i++){
            System.out.println("\n===== MESSAGE " + i + "=====");
            
            // Generate Message ID 
            String messageID = generateMessageID();
            // =========================
            // RECIPIENT VALIDATION
            // =========================
            System.out.print("Enter recipient number (with international code)");
            String recipient = input.nextLine();
            
            // WHILE LOOP
            while (recipient.length() > 10 || !recipient.startsWith("+")){
                System.out.println("Cell phone number is incorrectly formatted.");
                System.out.print("Re-enter recipient number: ");
                recipient = input.nextLine();
                
            }
            
            // =========================
            // MESSAGE VALIDATION
            // =========================
            System.out.print("Enter your message: ");
            String message = input.nextLine();
            if (message.length() < 250){
                System.out.println("Please enter a message of less than 250 characters.");
                continue;
            } else {
                System.out.println("Message ready to send.");
            }
            
            // Create Message Hash 
            String messageHash = createMessageHash(messageID, i, message);
            
            // =========================
            // MESSAGE OPTIONS
            // =========================
            
            System.out.println("\nChoose an option: ");
            System.out.println("1. Send Message");
            System.out.println("2. Disregard Message");
            System.out.println("3. Store Message to send later");
            
            System.out.print("Option: ");
            int option = input.nextInt();
            input.nextLine();
            
            switch (option){
                // =========================
                // SEND MESSAGE
                // =========================
                case 1: 
                    System.out.println("Message successfully sent");
                    
                    // Store data in ArrayLists
                    messageIDs.add(messageID);
                    messageHashes.add(messageHash);
                    recipients.add(recipient);
                    messages.add(message);
                    totalMessagesSent++;
                    
                    // Display message details
                    System.out.println("\n===== MESSAGE DETAILS =====");
                    System.out.println("Message ID: " + messageID);
                    System.out.println("Message Hash: " + messageHash);
                    System.out.println("Recipient: " + recipient);
                    System.out.println("Message: " + message);
                    
                    break;
                    
                // =========================
                // DELETE MESSAGE
                // =========================
                case 2:
                    System.out.println("Press 0 to delete the message");
                    int delete = input.nextInt();
                    input.nextLine();
                    if (delete == 0){
                        System.out.println("Message deleted.");
                    }
                    break;
                
                // =========================
                // STORE MESSAGE 
                // =========================
                case 3: 
                    storeMessage(messageID, messageHash, recipient, message);
                    
                    break;
                    
                default:
                    System.out.println("Invalid option.");
                    
            }
            
        }
        
    }
    // =========================
    // GENERATE MESSAGE ID
    // =========================
    
    public static String generateMessageID(){
        
        Random random = new Random();
        Long number =1000000000L + (long)(random.nextDouble()* 9000000000L);
        return String.valueOf(number);
        
    }
    
    // =========================
    // CREATE MESSAGE HASH
    // =========================
    
    public static String createMessageHash(String messageID, int messageNumber, String message){
        
        String[] words = message.split("");
        String firstWord = words[0]. toUpperCase();
        String lastWord = words[words.length - 1]. toUpperCase();
        return messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;
        
    }
    
    // =========================
    // STORE MESSAGE IN JSON FILE
    // =========================
    
    public static void storeMessage(String messageID, String hash, String recipient, String message) {
        
        
            try {
                try (FileWriter writer = new FileWriter("message.json", true)) {
                    writer.write("{\n");
                    writer.write("\"MessageID\": \"" + messageID + "\",\n" );
                    writer.write("\"MessageHash\":\"" + hash + "\",\n" );
                    writer.write("\"Recipient\":\"" + recipient + "\",\n" );
                    writer.write("\"Message\":\"" + message + "\"\n" );
                    writer.write("}\n\n");
                }
                
                System.out.println("Message successfully stored in JSON file.");
                
            }catch (IOException e){
                System.out.println("Error writing to file.");
                
        }
    }
}
    

    

    

