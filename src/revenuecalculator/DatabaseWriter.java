/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revenuecalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author diogo
 */
public class DatabaseWriter extends Database {
    //write method to add user to the database using insert
     public boolean addUser(Users users) throws SQLException {
        try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ){
            String sql = String.format("INSERT INTO " + TABLE_NAME1 + " VALUES ("
                    + "%d, '%s', '%s','%s', '%s', %f, '%s', '%s');",
                   users.getUserID(), users.getFirst_name(), users.getSurname_name(), users.getDay_of_birthday(), users.getAddress(), users.getGross_income(), 
                   users.getUserName(), users.getPassword());
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    
    }

// public boolean addResults1(UserData userData) throws SQLException {
//     
//        try(
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//            Statement stmt = conn.createStatement();  
//        ){
//            String sql = String.format("INSERT INTO " + TABLE_NAME2 + " VALUES ("
//                    + "%d ,'%s', '%s' , %f, %f, %f);",
//                   userData.getUserID(), userData.getFirst_name(), userData.getSurname_name(), userData.getGross_income(), userData.getTax_credits(), userData.getTax_owned());
//            stmt.execute(sql);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        
//    }
     
     //method to insert the results and user information to the new table
                 public boolean addResults(UserData userData) throws SQLException {
    try (
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + TABLE_NAME2 + " VALUES (?, ?, ?, ?, ?, ?)");
    ) {
        stmt.setInt(1, userData.getUserID());
        stmt.setString(2, userData.getFirst_name());
        stmt.setString(3, userData.getSurname_name());
        stmt.setDouble(4, userData.getGross_income());
        stmt.setDouble(5, userData.getTax_credits());
        stmt.setDouble(6, userData.getTax_owned());

        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
         
                 // method to update the admin information
                   public boolean updateUserAdmin(Users user) {
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE " + TABLE_NAME1 + " SET first_name = ?, surname_name = ?, day_of_birthday = ? WHERE user_id = ?"
            )
        ) {
            stmt.setString(1, user.getFirst_name());
            stmt.setString(2, user.getSurname_name());
            stmt.setString(3, user.getDay_of_birthday());
            stmt.setInt(4, user.getUserID());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0; // If rowsAffected is greater than 0, the update was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Update failed
        }
    }
                   //method to update the user information
                   public boolean updateUser(Users user) {
    try (
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE " + TABLE_NAME1 + " SET first_name = ?, surname_name = ?, day_of_birthday = ?, address = ?, gross_income = ?, username = ?, password = ? WHERE user_id = ?"
        )
    ) {
        stmt.setString(1, user.getFirst_name());
        stmt.setString(2, user.getSurname_name());
        stmt.setString(3, user.getDay_of_birthday());
        stmt.setString(4, user.getAddress());
        stmt.setDouble(5, user.getGross_income());
        stmt.setString(6, user.getUserName());
        stmt.setString(7, user.getPassword());
        stmt.setInt(8, user.getUserID());

        int rowsAffected = stmt.executeUpdate();

        return rowsAffected > 0; // If rowsAffected is greater than 0, the update was successful
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Update failed
    }
}
                   
    
    
   //method to allow the admin manage and remove the users
    public boolean removeUser(String username) {
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM " + TABLE_NAME1 + " WHERE Username = ?"
            )
        ) {
            stmt.setString(1, username);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0; // If rowsAffected is greater than 0, the deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Deletion failed
        }
    }
    
    //array list to add users to a list which can be checked by the admin
    public boolean addAllUser(List<Users> usersList) {
        return true;
    }

                   }

