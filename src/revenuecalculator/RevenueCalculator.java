/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package revenuecalculator;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author paulooliveira
 */
public class RevenueCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        

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
        
            // Check if entered credentials match admin credentials
        if (enteredAdminUserName.equals(adminUserName) && enteredAdminPassword.equals(adminPassword)) {
            System.out.println("Admin login successful!");
            adminLoginSuccessful = true;

            // Admin- menu 
            while (true) {
                System.out.println("Admin Menu:");
                System.out.println("1. Modify Admin Information");
                System.out.println("2. see list");
                System.out.println("3. Remove User");
                System.out.println("4. Track User Activity");
                System.out.println("5. Exit Admin Menu");

                int adminChoice = myKB.nextInt();

                switch (adminChoice) {
                    case 1:
                            DatabaseReader dbReader = new DatabaseReader();
    Users adminUser = dbReader.getUserByUsername(adminUserName);

    if (adminUser != null) {
        // Display current admin information
        System.out.println("Current Admin Information:");
        System.out.println("1. First Name: " + adminUser.getFirst_name());
        System.out.println("2. Surname: " + adminUser.getSurname_name());
        System.out.println("3. Day of Birth: " + adminUser.getDay_of_birthday());
        // Add more fields as needed

        // Allow the admin to choose which information to modify
        System.out.print("Enter the number corresponding to the field to modify: ");
        int fieldChoice = myKB.nextInt();

        myKB.nextLine(); 

        // Variable to store the new value
        String newValue;

        switch (fieldChoice) {
            case 1:
                // Modify First Name
                System.out.print("Enter the new First Name: ");
                newValue = myKB.nextLine().trim();
                adminUser.setFirst_name(newValue);
                break;

            case 2:
                // Modify Surname
                System.out.print("Enter the new Surname: ");
                newValue = myKB.nextLine().trim();
                adminUser.setSurname_name(newValue);
                break;

            case 3:
                // Modify Day of Birth
                System.out.print("Enter the new Day of Birth (YYYY-MM-DD): ");
                newValue = myKB.nextLine().trim();
                if (isValidYearMonthDayFormat(newValue)) {
                    adminUser.setDay_of_birthday(newValue);
                } else {
                    System.out.println("Invalid date format. Modification canceled.");
                }
                break;

            // Add more cases for other fields as needed

            default:
                System.out.println("Invalid choice. Modification canceled.");
                break;
        }
        
   
    private static boolean isValidYearMonthDayFormat(String date) {
    // The regular expression for YYYY/MM/DD format
    String regex = "^(\\d{4})[-/](0[1-9]|1[0-2])[-/](0[1-9]|[12][0-9]|3[01])$";
    return date.matches(regex); 
    
    }
}