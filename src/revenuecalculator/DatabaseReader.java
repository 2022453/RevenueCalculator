/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revenuecalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author diogo
 */
public class DatabaseReader extends Database {
    //Array list to save the users and give the admin acess to see all of them
     public ArrayList<Users> getAllData() throws SQLException {
            ArrayList<Users> usersList = new ArrayList<>();
            
            //making connection to get the users and their attributes
 try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ){
 
ResultSet results = stmt.executeQuery(String.format(
                    "SELECT * FROM %s;",
                    TABLE_NAME1));
 
  while (results.next()) {
           
            
                String first_name = results.getString("first_name");
                String surname_name = results.getString("surname_name");
                String day_of_birthday = results.getString("day_of_birthday");
                String UserName = results.getString("Username");
                int userID = results.getInt("user_id");

               Users user1 = new Users(userID, first_name, surname_name, day_of_birthday, UserName);
               
               
               usersList.add(user1);
  }
        } catch (SQLException e) {
            e.printStackTrace();
      
           
              
        }
     return usersList;
     
    }
//reading a specific user
public Users getUserByUsername(String username) throws SQLException {
        Users user = null;

        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM " + TABLE_NAME1 + " WHERE Username = ?"
            )
        ) {
            stmt.setString(1, username);
            ResultSet results = stmt.executeQuery();

            if (results.next()) {
                int userID = results.getInt("user_id");
                String first_name = results.getString("first_name");
                String surname_name = results.getString("surname_name");
                String day_of_birthday = results.getString("day_of_birthday");
                String password = results.getString("Password"); 

                 user = new Users(userID, first_name, surname_name, day_of_birthday, username, password);
            }
        }

        return user;
    }
//collecting data from the user on the database table using their id
    public UserData getUserDataByUserID(int userID) throws SQLException {
        String query = "SELECT * FROM " + TABLE_NAME2 + " WHERE user_id = ?";
        try (
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double taxCredits = resultSet.getDouble("tax_credits");
                double taxOwned = resultSet.getDouble("tax_owned");
                String firstName = resultSet.getString("first_name");
                String surnameName = resultSet.getString("surname_name");
                double grossIncome = resultSet.getDouble("gross_income");

                // Create and return a new UserData object
                return new UserData(taxCredits, taxOwned, userID, firstName, surnameName, grossIncome);
            }
        }
        throw new SQLException("User data not found in the new table");
    }
//Getting the users income information from the database to use this data to make the calculation
    public static double getIncomeFromDatabase(String username) throws SQLException {
        String query = "SELECT gross_income FROM users WHERE username = ?";
        try (
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("gross_income");
            }
        }
        throw new SQLException("User not found in the database");
    }
}

    
    
