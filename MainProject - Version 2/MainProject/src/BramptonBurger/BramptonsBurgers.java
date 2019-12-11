/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BramptonBurger;


import java.util.Scanner;

import SQLConnection.InvoiceDB;

/**
 *
 * @author NITHIN
 */
public class BramptonsBurgers {
    
    public static void main(String args[]){
       Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Brampton's Burgers...\nPress Any key to continue or E to exit");
        String userChoice = input.nextLine();
        if ( userChoice.toLowerCase().equals("e")) {
            System.exit(0);
        }
        else{
           BurgerType.selectBurgerType(); 
        }
        
        //InvoiceDB.createInvoice();
        
        
        
    }
}

