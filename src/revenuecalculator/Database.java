/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revenuecalculator;

/**
 *
 * @author diogo
 */
public abstract class Database {
    //creating the right attributes to conecting the database and tables
    
    protected final static String DB_BASE_URL = "jdbc:mysql://localhost";
    protected final static String USER = "ooc2023";
    protected final static String PASSWORD = "ooc2023";
    protected final static String DB_NAME = "revenueCalculator";
    protected final static String TABLE_NAME1 = "users";
    protected final static String TABLE_NAME2 = "taxResults";
     protected final static String DB_URL = DB_BASE_URL + "/" + DB_NAME;
}
