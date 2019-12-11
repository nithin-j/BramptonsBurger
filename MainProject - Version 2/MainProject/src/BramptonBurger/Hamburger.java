/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BramptonBurger;

import java.util.ArrayList;
import java.util.Scanner;

import SQLConnection.InvoiceDB;
/**
 *
 * @author NITHIN
 */
public abstract class Hamburger  {
        
    protected double Price;
    protected String RollType;
    protected String Meat;
    protected String burgerTypeName;
    
    public double getPrice(){
        return Price;
    }
    public void setPrice(double price){
        Price = price;
    }
    
    public String getRollType(){
        return RollType;
    }
    public void setRollType(String rolltype){
        RollType = rolltype;
    }
    
    public String getMeat(){
        return Meat;
    }
    public void setMeat(String meat){
        Meat = meat;
    }
    public String getBurgerType(){
        return burgerTypeName;
    }
    
    public void makeBurger(int numberOfAdditions){
        ExtraAdditions additions = new ExtraAdditions();
        ArrayList<String> items = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        String details = burgerTypeName + " on a " + RollType + " with " + Meat + " $" + Price + " selected";
        System.out.println(details);
        System.out.println("Do you want to change the bread or meat of your Hamburger (Y/N)? ");
        String ch = input.nextLine();
        if(ch.toLowerCase().equals("y")){
            items = additions.ChangeItems();
            RollType = items.get(0);
            Meat = items.get(1);
            
        }
        else if(ch.toLowerCase().equals("n"))
            System.out.println("Default selected");
        else
            System.out.println("Invalid Selection");
        addExtras(numberOfAdditions);
        
    }
    
    public abstract void addExtras(int numberOfExtras);
    public abstract void displayFinalOrder(int length);
    public void createInvoice(Double totalPrice){
        
    }
}

