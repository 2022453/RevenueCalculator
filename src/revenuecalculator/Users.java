/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revenuecalculator;

/**
 *
 * @author paulooliveira
 */
public class Users {
    
    
    // created the atributes necessary for our users. 
    
    private static int user_id = 1;
    private int userID;
    private String first_name;
    private String surname_name;
    private String day_of_birthday;
    private String address;
    private String UserName;
    private String Password;
    private double gross_income;
    
    
    
    //constructor
    public Users(String first_name, String surname_name, String day_of_birthday, String address, double gross_income, String UserName, String Password) {
        this.first_name = first_name;
        this.surname_name = surname_name;
        this.day_of_birthday = day_of_birthday;
        this.address = address;
        this.gross_income = gross_income;
        this.UserName = UserName;
        this.Password = (Password != null) ? Password : "";
         userID = userID;
       if (user_id <= userID) {
            user_id = userID + 1;
        }
      
    }

    //constructor
    public Users(int userID, String first_name, String surname_name, String day_of_birthday, String UserName) {
        this.userID = userID;
        this.first_name = first_name;
        this.surname_name = surname_name;
        this.day_of_birthday = day_of_birthday;
        this.UserName = UserName;
    }

    //constructor
    public Users(int userID, String first_name, String surname_name, double gross_income) {
        this.userID = userID;
        this.first_name = first_name;
        this.surname_name = surname_name;
        this.gross_income = gross_income;
    }
    
    
    
    //constructor
     public Users(int userID, String first_name, String surname_name, String day_of_birthday, String UserName, String Password) {
        this.userID = userID;
        this.first_name = first_name;
        this.surname_name = surname_name;
        this.day_of_birthday = day_of_birthday;
        this.UserName = UserName;
        this.Password = (Password != null) ? Password : "";
    }


    
    
    public static int getUser_id() {
        return user_id;
    }

    public static void setUser_id(int user_id) {
        Users.user_id = user_id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname_name() {
        return surname_name;
    }

    public void setSurname_name(String surname_name) {
        this.surname_name = surname_name;
    }

    public String getDay_of_birthday() {
        return day_of_birthday;
    }

    public void setDay_of_birthday(String day_of_birthday) {
        this.day_of_birthday = day_of_birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGross_income() {
        return gross_income;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

   public String getPassword() {
    return (Password != null) ? Password : "";
}


    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    

    public void setGross_income(double gross_income) {
        this.gross_income = gross_income;
    }
}
    
   
