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
public class DeluxeBurger extends Hamburger{
    
    public DeluxeBurger(){
        Price = 11.99;
        burgerTypeName = "Deluxe Hamburger";
        RollType = "Sesame_Seed_Bun";
        Meat = "Sausage & Chicken";
        chipsPrice = 3.25;
        drinksPrice = 2.50;
        chips = "Pottato Chips";
    }
    
    private double chipsPrice;
    private double drinksPrice; 
    private String Drink;
    private String chips;
    
    public void makeDeluxeBurger(){
        makeBurger(2);
        displayFinalOrder(2);
    }
    
    public void addExtras(int length){
        ExtraAdditions additions = new ExtraAdditions();
        
        Drink =  additions.AddAdditions();
        
    }
    
    public void displayFinalOrder(int length){
        NumberFormat formatter = new DecimalFormat("#0.00"); 
        Scanner input = new Scanner(System.in);

        double grandTotal = getPrice() + drinksPrice + chipsPrice;
        String details = burgerTypeName + " on a " + RollType + " with " + Meat + " $" + Price;
        System.out.println("Your final order is as below: ");
        System.out.println(details);
        System.out.println("Added " + chips + " $"+chipsPrice);
        System.out.println("Added " + Drink + " $"+drinksPrice);
        System.out.println("Total Payable: $"+formatter.format(grandTotal) );
        InvoiceDB.createInvoice(details, grandTotal);
        System.out.println("Press any key to continue....");
        input.nextLine();
        
    }
}
