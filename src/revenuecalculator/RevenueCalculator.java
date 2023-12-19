/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package revenuecalculator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static revenuecalculator.DatabaseReader.getIncomeFromDatabase;

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
          // Update the modified information in the database
        DatabaseWriter dbWriter = new DatabaseWriter();
        if (dbWriter.updateUserAdmin(adminUser)) {
            System.out.println("Admin information updated successfully!");
        } else {
            System.out.println("Failed to update admin information.");
        }
    } else {
        System.out.println("Admin not found in the database. Cannot modify information.");
    }
    break;
    
                        case 2:
                            System.out.println("see list");
                     try {
          
            DatabaseReader dbReader1 = new DatabaseReader();
            ArrayList<Users> usersList = dbReader1.getAllData();

           // retrieve all the information.
            for (Users user : usersList) {
                System.out.println("User ID: " + user.getUserID());
                System.out.println("First Name: " + user.getFirst_name());
                System.out.println("Surname: " + user.getSurname_name());
                System.out.println("Date of Birth: " + user.getDay_of_birthday());
                System.out.println("Username: " + user.getUserName());
                System.out.println("--------------");
            }

        } catch (SQLException e) {
          // Handle the exception as needed
          
        }
                     break;
                     
                                        case 3:
    // Remove User
    System.out.print("Enter the username of the user to be removed: ");
    String usernameToRemove = myKB.next().trim();

    DatabaseWriter dbWriter = new DatabaseWriter();
    boolean removalSuccessful = dbWriter.removeUser(usernameToRemove);

    if (removalSuccessful) {
        System.out.println("User removed successfully!");
    } else {
        System.out.println("Failed to remove the user. User not found or an error occurred.");
    }
    break;

case 4:
    // Track User Activity
    System.out.print("Enter the username of the user to track activity: ");
    String usernameToTrack = myKB.next().trim();

    // Retrieve and display the user activity log
    ArrayList<String> activityLog = UserActivityLogger.getUserActivityLog(usernameToTrack);

    if (activityLog.isEmpty()) {
        System.out.println("No activity found for user " + usernameToTrack);
    } else {
        System.out.println("User Activity Log for " + usernameToTrack + ":");
        for (String activity : activityLog) {
            System.out.println(activity);
        }
    }
    
                        break;

                    case 5:
                        // Exit Admin Menu
                        System.out.println("Exiting Admin Menu.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }

                if (adminChoice == 4) {
                    break; // Exit the admin menu
                }
            }
        } else {
            System.out.println("Admin login failed. Incorrect username or password. Please try again.");
        }
    }
    break;
    
     } else {
            // If not admin, check regular user credentials
            DatabaseReader dbReader = new DatabaseReader();
            // Retrieve user from the database by username
            Users user = dbReader.getUserByUsername(enteredUserName);

            // Check if the user exists and if the entered password matches
            if (user != null && user.getPassword().equals(enteredPassword)) {
                System.out.println("Regular user login successful!");
                loginSuccessful = true;
                
                UserActivityLogger.logActivity(enteredUserName, "User logged in");
             
                boolean userLoggedIn = true;
            
                while (userLoggedIn) {
    System.out.println("Options for regular user:");
    System.out.println("1 - Modify Your Information");
    System.out.println("2 - Perform Income Calculation and save!");
    System.out.println("3 - Check results");
    System.out.println("4 - Logout");

    int userOption = myKB.nextInt();

    switch (userOption) {
        case 1:
            // Modify Your Information
            System.out.println("Options for modifying information:");
            System.out.println("1 - Modify First Name");
            System.out.println("2 - Modify Surname");
            System.out.println("3 - Modify Day of Birth");
            System.out.println("4 - Modify Address");
            System.out.println("5 - Modify Gross Income");
            System.out.println("6 - Modify Username");
            System.out.println("7 - Modify Password");

            int modificationOption = myKB.nextInt();
            myKB.nextLine(); // Consume the newline character

            switch (modificationOption) {
                case 1:
                    System.out.print("Enter new first name: ");
                    user.setFirst_name(myKB.nextLine().trim());
                    break;
                case 2:
                    System.out.print("Enter new surname: ");
                    user.setSurname_name(myKB.nextLine().trim());
                    break;
                case 3:
                    System.out.print("Enter new day of birth (YYYY-MM-DD): ");
                    user.setDay_of_birthday(myKB.nextLine().trim());
                    break;
                case 4:
                    System.out.print("Enter new address: ");
                    user.setAddress(myKB.nextLine().trim());
                    break;
                case 5:
                    System.out.print("Enter new gross income: ");
                    double newIncome = myKB.nextDouble();
                    user.setGross_income(newIncome);
                    break;
                case 6:
                    System.out.print("Enter new username: ");
                    user.setUserName(myKB.nextLine().trim());
                    break;
                case 7:
                    System.out.print("Enter new password: ");
                    user.setPassword(myKB.nextLine().trim());
                    break;
                default:
                    System.out.println("Invalid modification option.");
                 }

        // Update the modified information in the database
        DatabaseWriter dbWriter1 = new DatabaseWriter();
        if (dbWriter1.updateUser(user)) {
            System.out.println("user information updated successfully!");
          
// Log the activity
UserActivityLogger.logActivity(enteredUserName, "Modified user information");

        } else {
            System.out.println("Failed to update user information.");
        
    }
    break;
    
    case 2:
        
    try {
        
    
        double income = getIncomeFromDatabase(enteredUserName);

        // Example usage of the TaxCalculator interface and IrishTaxCalculator implementation
        TaxCalculator taxCalculator = new IrishTaxCalculator();

        // Calculate income tax considering tax credit
        double tax = taxCalculator.calculateIncomeTax(income);
        
             // Create a new UserData object with the calculated values
        UserData userData = new UserData(3550, tax, user.getUserID(), user.getFirst_name(), user.getSurname_name(), income);
//         Retrieve income from the database (replace "enteredUserName" with the actual username)

            DatabaseWriter dbWriter = new DatabaseWriter();
            if (dbWriter.addResults(userData)) {
                System.out.println("User information updated successfully!");
            } else {
                System.out.println("Failed to update user information.");
            }

        // Display the result
        System.out.println("Your income tax after tax credit is: €" + tax);
    } catch (SQLException e) {
        System.out.println("Error retrieving income from the database: " + e.getMessage());
    }
    break;

 case 3:
    try {
        // Retrieve user information from the database
        Users user2 = dbReader.getUserByUsername(enteredUserName);

        // Retrieve results from the new table
        UserData userData = dbReader.getUserDataByUserID(user.getUserID());

        // Print the user data
        System.out.println("User ID: " + userData.getUserID());
        System.out.println("First Name: " + userData.getFirst_name());
        System.out.println("Surname: " + userData.getSurname_name());
        System.out.println("Gross Income: " + userData.getGross_income());
        System.out.println("Tax Credits: " + userData.getTax_credits());
        System.out.println("Tax Owned: " + userData.getTax_owned());

    } catch (SQLException e) {
        System.out.println("Error retrieving user information or results from the database: " + e.getMessage());
    }
    break;

        case 4:
            // Logout
            userLoggedIn = false;
            System.out.println("User logged out.");
            break;

        default:
            System.out.println("Invalid option. Please try again.");
    }
                }
          } else {
                System.out.println("Login failed. Incorrect username or password. Please try again.");
            }
        }
    }
    break;
 
    case 2:
   
    // instance of Users
    Users newUser = new Users("", "", "", "", 0.0, "", "");

    // Input validation loop for first name
    while (newUser.getFirst_name().isEmpty() || containsDigit(newUser.getFirst_name())) {
        System.out.print("Please enter your first name (without numbers): ");
        newUser.setFirst_name(myKB.nextLine().trim());
        if (containsDigit(newUser.getFirst_name())) {
            System.out.println("Invalid input. Please enter a name without numbers.");
        }
    }

    // Input validation loop for surname
    while (newUser.getSurname_name().isEmpty() || containsDigit(newUser.getSurname_name())) {
        System.out.print("Please enter your surname (without numbers): ");
        newUser.setSurname_name(myKB.nextLine().trim());
        if (containsDigit(newUser.getSurname_name())) {
            System.out.println("Invalid input. Please enter a surname without numbers.");
        }
    }

    // Input validation loop for day of birth
    while (newUser.getDay_of_birthday().isEmpty() || !isValidYearMonthDayFormat(newUser.getDay_of_birthday())) {
        System.out.print("Please enter your day of birth (YYYY-MM-DD): ");
        newUser.setDay_of_birthday(myKB.nextLine().trim());
        if (!isValidYearMonthDayFormat(newUser.getDay_of_birthday())) {
            System.out.println("Invalid date format. Please enter a valid date in YYYY/MM/DD format.");
        }
    }

    // Input validation loop for address
    while (newUser.getAddress().isEmpty()) {
        System.out.print("Please enter your address: ");
        newUser.setAddress(myKB.nextLine().trim());
    }

    // Input validation loop for gross income
    boolean validIncome = false;
    while (!validIncome) {
        System.out.print("Please enter your gross income: ");
        try {
            newUser.setGross_income(Double.parseDouble(myKB.nextLine()));
            validIncome = true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
    
        while (newUser.getUserName().isEmpty()) {
        System.out.print("Please enter your Username: ");
        newUser.setUserName(myKB.nextLine().trim());
    }
        
        
    while (newUser.getPassword().isEmpty()) {
        System.out.print("Please enter your password: ");
        newUser.setPassword(myKB.nextLine().trim());
    }
        
        
    
       DatabaseWriter dbWriter = new DatabaseWriter();
    if (dbWriter.addUser(newUser)) {
        System.out.println("User added to the database successfully!");
        
        
    } else {
        System.out.println("Failed to add user to the database.");
    }
    break;


            default:
                System.out.println("Invalid choice.");
        }

        // Close the scanner
        myKB.close();
    }
    

    private static boolean containsDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidYearMonthDayFormat(String date) {
    // The regular expression for YYYY/MM/DD format
    String regex = "^(\\d{4})[-/](0[1-9]|1[0-2])[-/](0[1-9]|[12][0-9]|3[01])$";
    return date.matches(regex); 
  
     } 
   }