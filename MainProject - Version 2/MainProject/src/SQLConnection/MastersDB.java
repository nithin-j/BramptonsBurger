/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author NITHIN
 */
public class MastersDB {
            
    //EXTRAS, DRINKS, BREADTYPE, MEAT
    public static ArrayList<String> getExtras(){
        
        ArrayList<String> extras = new ArrayList<String>();
        
        try{
            
            Connection conn = utilityDB.dbConnection();
            Statement statement = conn.createStatement();
            
            
            statement.execute("SELECT NAME FROM EXTRAS");
            ResultSet results = statement.getResultSet();
            while(results.next()) {
                extras.add(results.getString("NAME"));
            }

            results.close();              
          
            statement.close();
            
            
            conn.close();
        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() + "\nPlease contact support.");
        } 
        return extras;
    }
    
    public static ArrayList<Double> getExtrasPrice(){
        
        ArrayList<Double> extrasPrice = new ArrayList<Double>();
        
        try{
            
            Connection conn = utilityDB.dbConnection();
            Statement statement = conn.createStatement();
            
            
            statement.execute("SELECT PRICE FROM EXTRAS");
            ResultSet results = statement.getResultSet();
            while(results.next()) {
                extrasPrice.add(results.getDouble("PRICE"));
            }

            results.close();              
          
            statement.close();
            
            
            conn.close();
        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() + "\nPlease contact support.");
        } 
        return extrasPrice;
    }
    
    public static ArrayList<String> getDrinks(){
        
        ArrayList<String> drinks = new ArrayList<String>();
        
        try{
            
            Connection conn = utilityDB.dbConnection();
            Statement statement = conn.createStatement();
            
            
            statement.execute("SELECT NAME FROM DRINKS");
            ResultSet results = statement.getResultSet();
            while(results.next()) {
                drinks.add(results.getString("NAME"));
            }

            results.close();              
          
            statement.close();
            
            
            conn.close();
        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() + "\nPlease contact support.");
        } 
        return drinks;
    }
    
    public static ArrayList<String> getBreadTypes(){
        
        ArrayList<String> breads = new ArrayList<String>();
        
        try{
            
            Connection conn = utilityDB.dbConnection();
            Statement statement = conn.createStatement();
            
            
            statement.execute("SELECT NAME FROM BREADTYPE");
            ResultSet results = statement.getResultSet();
            while(results.next()) {
                breads.add(results.getString("NAME"));
            }

            results.close();              
          
            statement.close();
            
            
            conn.close();
        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() + "\nPlease contact support.");
        } 
        return breads;
    }
    
    public static ArrayList<String> getMeatTypes(){
        
        ArrayList<String> meats = new ArrayList<String>();
        
        try{
            
            Connection conn = utilityDB.dbConnection();
            Statement statement = conn.createStatement();
            
            
            statement.execute("SELECT NAME FROM MEAT");
            ResultSet results = statement.getResultSet();
            while(results.next()) {
                meats.add(results.getString("NAME"));
            }

            results.close();              
          
            statement.close();
            
            
            conn.close();
        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() + "\nPlease contact support.");
        } 
        return meats;
    }
}
