/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package revenuecalculator;

import java.util.Scanner;

/**
 *
 * @author paulooliveira
 */
public class RevenueCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

            Scanner myKB = new Scanner(System.in);
            
            System.out.println("Hello! Welcome Revenue Tax Calculator!");
            
            System.out.println("");
            
            System.out.println("Please select an option");
            
            
            System.out.println("");
            
            System.out.println("1 - Login! ");
            System.out.println("2 - Sing up! ");
        
        // Validate user input
        int choice = 0;
        while (true) {
            try {
                choice = Integer.parseInt(myKB.nextLine());
                if (choice == 1 || choice == 2) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.print("Invalid choice. Please enter 1 or 2: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        
 // Process user choice
        switch (choice) {
            case 1:
                // Predefined username and password
                
       String adminUserName = "CCT";
    String adminPassword = "Dublin";

    // Regular user credentials
//    String regularUserName = "regularUser";
//    String regularPassword = "regularPassword";

    boolean loginSuccessful = false;

    while (!loginSuccessful) {
        System.out.print("Enter username: ");
        String enteredUserName = myKB.next().trim();

        System.out.print("Enter password: ");
        String enteredPassword = myKB.next().trim();

        // Check if entered credentials match admin credentials
        if (enteredUserName.equals(adminUserName) && enteredPassword.equals(adminPassword)) {
            System.out.println("Admin login for safety reason you have to confirm your credentials!");
            loginSuccessful = true;
            
boolean adminLoginSuccessful = false;

    while (!adminLoginSuccessful) {
        System.out.print("Enter username: ");
        String enteredAdminUserName = myKB.next().trim();

        System.out.print("Enter password: ");
        String enteredAdminPassword = myKB.next().trim();
        
    