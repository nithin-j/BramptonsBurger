/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLConnection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author NITHIN
 */
public class utilityDB{
    
    public static Connection dbConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:./db/BramptonBurger.db");
            conn.setAutoCommit(true);
            
        }catch(SQLException e){
                System.out.println("Something went wrong: " +e.getMessage() + "\nPlease contact support.");
        }
        return conn;
    } 
}
