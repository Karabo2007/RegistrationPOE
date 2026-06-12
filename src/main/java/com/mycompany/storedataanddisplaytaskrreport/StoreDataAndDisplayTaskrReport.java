/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.storedataanddisplaytaskrreport;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class StoreDataAndDisplayTaskrReport {

    private static Object message;
    private static Iterable<Message> messages;

    public static void main(String[] args) {
        ArrayList<Message> storedMessages = new ArrayList<>();
        ArrayList<Message> sentMessages = new ArrayList<>();
        ArrayList<Message> disregardedMessages = new ArrayList<>();
        
        // Test Data Message 1
        sentMessages.add(new Message("1001","+27834557896","Did you get the cake?","ABC123","Sent"));
        
        // Test Data Message 2
        storedMessages.add(new Message("1002","+27838884567","Where are you? You are late! I have asked you to be on time","DEF456","Stored"));
        
        // Test Data Message 3 
        disregardedMessages.add(new Message("1003","+27834484567","Yohoooo, I am at your gate.","GHI789","Disregarded"));
        
        // Test Data Message 4
        sentMessages.add(new Message("1004","0676033047","It is dinner time!","JKL111","Sent"));
        
        displayStoredMessages(storedMessages);
        
        displayLongestStoredMessage(storedMessages);
        
        searchMessageByID(storedMessages,"1002");
        
        searchByRecipient(storedMessages,"+27838884567");
        
        deleteMessageByHash(storedMessages,"DEF456");
        
        displayStoredMessages(storedMessages);
        
        // Display all stored message
        
            System.out.println("\nSTORED MESSAGES");
        
            
            for (Message msg : messages){
                System.out.println("ID: " + msg.messageID );
                System.out.println("Recipient: " + msg.recipient);
                System.out.println("Message: " + msg.message);
                System.out.println("Hash: " + msg.hash);
                System.out.println("-------------------");
        }
    }
        // Longest stored message
        public static void displayStoredMessage(ArrayList<Message> messages){
            
            if (messages.isEmpty()){
                System.out.println("No stored messages. ");
                return;
                
            }
            
            Message longest = messages.get(0);
            
            for (Message msg : messages){
                if (msg.message.length() > longest.message.length()){
                    longest = msg;
                }
            }
            System.out.println("\nLONGEST STORED MESSAGE:");
            System.out.println(longest.message);
        }
        // Search by ID
        public static void searchMessagesByID(ArrayList<Message> messages, String id){
            
            for (Message msg : messages){
                if (msg.MessageID.equals(id)){
                    System.out.println("\nMESSAGE FOUND");
                    System.out.println("Recipient: " + msg.recipient);
                    System.out.println("Message: " + msg.message);
                    return;
                }
            }
            System.out.println("Message ID not found.");
        }
        // Search by recipient
        public static void searchByRecipient(ArrayList<Message> messages, String recipient){
            
            System.out.println("\nMESSAGES FOR: " + recipient);
            
            for (Message msg: messages){
                if (msg.recipient.equals(recipient)){
                    System.out.println(msg.messages);
                }
            }
        }
        // Delete by hash 
        public static void deleteMessageByHah(ArrayList<Message> messages, String hash){
            
            messages.removeIf(msg -> msg.hash.equals(hash));
            
            System.out.println("\nMessage deleted successfully.");
        }

    private static void displayLongestStoredMessage(ArrayList<Message> storedMessages) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void searchMessageByID(ArrayList<Message> storedMessages, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void deleteMessageByHash(ArrayList<Message> storedMessages, String deF456) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void displayStoredMessages(ArrayList<Message> storedMessages) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    

        }
    


