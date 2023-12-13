/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revenuecalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author paulooliveira
 */
public class UserActivityLogger {
    
    //file
    private static final String LOG_FILE = "user_activity_log.txt";

    //records users activities to a file 
    public static void logActivity(String username, String activity) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String logEntry = String.format("[%s] User '%s': %s", timestamp, username, activity);
            writer.println(logEntry);
            System.out.println("User activity logged successfully.");
        } catch (IOException e) {
            System.out.println("Failed to log user activity. Error: " + e.getMessage());
        }
    }

    
    
    // reads the users activities
     public static ArrayList<String> getUserActivityLog(String username) {
        ArrayList<String> userActivityLog = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("User '" + username + "':")) {
                    userActivityLog.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user activity log. " + e.getMessage());
        }

        return userActivityLog;
    }
}
   
