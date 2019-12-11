/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BramptonBurger;

import SQLConnection.InvoiceDB;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author NITHIN
 */
public class BasicBurger extends Hamburger{
    
    
    public BasicBurger(){
        Price = 5.99;
        burgerTypeName = "Basic Hamburger";
        RollType = "White Roll";
        Meat = "Chicken";
    }
    public void makeBasicBurger(){
        ExtraAdditions extraAdditions = new ExtraAdditions();
        
        makeBurger(4);
        displayFinalOrder(extraAdditions.getLengthOfAdditions());
    }
    
    public void addExtras(int length){
        
        String userChoice;
        Scanner input = new Scanner(System.in);
        ExtraAdditions extraAdditions = new ExtraAdditions();
        
        System.out.println("Do you want to add any extras(Y/N)?");
        userChoice = input.nextLine();
        
        if(userChoice.toLowerCase().equals("y")){
            extraAdditions.clearAdditions();
            extraAdditions.AddAdditions(length);              
        }
        else
        {
            extraAdditions.clearAdditions();
            
        }
    }
    
    public void displayFinalOrder(int length){
        NumberFormat formatter = new DecimalFormat("#0.00"); 
        Scanner input = new Scanner(System.in);
        
        double grandTotal = getPrice();
        ExtraAdditions extraAdditions = new ExtraAdditions();
        String details = burgerTypeName + " on a " + RollType + " with " + Meat + " $" + Price;
        System.out.println("Your final order is as below: ");
        System.out.println(details+" with");
        if(extraAdditions.getAdditions(0) != null){
            for (int i = 0; i < length; i++) {
           System.out.println("\t"+extraAdditions.getAdditions(i)+" + $"+extraAdditions.getAdditionPrice(i)); 
            }
            for (int i = 0; i < length; i++) {
            grandTotal = grandTotal + extraAdditions.getAdditionPrice(i);
            }
        }
        InvoiceDB.createInvoice(details, grandTotal);
        
        
        System.out.println("Total Payable: $"+formatter.format(grandTotal) );
        System.out.println("Press any key to continue....");
        input.nextLine();
        
    }
    
}
