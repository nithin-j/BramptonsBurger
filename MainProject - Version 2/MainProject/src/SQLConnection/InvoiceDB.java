/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLConnection;

import com.sun.javafx.scene.layout.region.Margins;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class InvoiceDB {
    
    public static void createInvoice(String Details, double price){
        
        try{
            
            Connection conn = utilityDB.dbConnection();
            Statement statement = conn.createStatement();
            int maxInvoice = getMaxInvoicNumber();
            statement.execute("CREATE TABLE IF NOT EXISTS INVOICES" + 
                                "(INVOICENUMBER INTEGER PRIMARY KEY NOT NULL," +
                                "INVOICEDETAILS TEXT NOT NULL," +
                                "INVOICEDATE TEXT NOT NULL," +
                                "TOTALPRICE REAL)");
            
            statement.execute("INSERT INTO INVOICES (INVOICENUMBER, INVOICEDETAILS, INVOICEDATE, TOTALPRICE) " +
                                "VALUES("+(maxInvoice+1)+", '"+Details+"', date('now'),"+price+" )");
            
            statement.close();
            
            conn.close();
        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() + "\nPlease contact support.1");
        }
    }
    
    public static int getMaxInvoicNumber(){
        int maxInvoie = 1000;
        try{
            
            Connection conn = utilityDB.dbConnection();
            Statement statement = conn.createStatement();
            statement.execute("SELECT MAX(INVOICENUMBER) AS MAXINVOICE FROM INVOICES");
            ResultSet results = statement.getResultSet();
            while(results.next()) {
                
                if(results.getString("MAXINVOICE") != null){
                    maxInvoie = Integer.parseInt(results.getString("MAXINVOICE"));
                }
            }

            results.close();

            statement.close();
            
            conn.close();
        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() + "\nPlease contact support.");
        }
        return maxInvoie;
    }
    
    public static void viewSalesReportByMonth(){
        
        
        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the year and month for which you want to view the report (YYYYMM): ");
            String datePart = input.nextLine();
        
            
            Connection conn = utilityDB.dbConnection();
            Statement statement = conn.createStatement();
            //select * from invoices where strftime('%Y%m',INVOICEDATE) = '201911';
            statement.execute("SELECT * FROM INVOICES WHERE strftime('%Y%m',INVOICEDATE) = '"+datePart+"';");
            ResultSet results = statement.getResultSet();
            System.out.println("Invoice Number\t\tInvoice Details\t\t\t\t\t\t\t\tInvoice Date\t\tTotal Price");
            while(results.next()) {
                
                if(results.getString("INVOICENUMBER") != null){
                    System.out.println(results.getString("INVOICENUMBER") + "\t\t\t" +
                                   results.getString("INVOICEDETAILS") + "\t\t\t" +
                                   results.getString("INVOICEDATE") + "\t\t" +
                                   results.getString("TOTALPRICE"));
                }
                else{
                    System.out.println("Could not find any records in the for the period");
                }
            }
            input.nextLine();
            results.close();

            statement.close();
            
            conn.close();
        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() + "\nPlease contact support.");
        }
        
    }
}
