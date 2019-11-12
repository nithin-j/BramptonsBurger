/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author NITHIN
 */
public class BurgerType {
 
    public static void selectBurgerType(){
        boolean flag = false;
        while (flag == false) {            
            BasicBurger basicBurger = new BasicBurger();
            HealthyBurger healthyBurger = new HealthyBurger();
            DeluxeBurger deluxeBurger = new DeluxeBurger();
        
            Scanner input = new Scanner(System.in);
            int burgerType;
            
            try{
               System.out.println("Please select the type of burger from the list below.");
            System.out.println("1: " + basicBurger.getBurgerType() + " $"+basicBurger.getPrice());
            System.out.println("2: " + healthyBurger.getBurgerType() + " $"+healthyBurger.getPrice());
            System.out.println("3: " + deluxeBurger.getBurgerType() + " $"+deluxeBurger.getPrice());
            System.out.println("4: Exit");
            burgerType = input.nextInt();
            switch(burgerType){
                case 1:
                    basicBurger.makeBasicBurger();
                    break;
                case 2:
                    healthyBurger.makeHealthyBurger();
                    break;
                case 3:
                    deluxeBurger.makeDeluxeBurger();
                    break;
                case 4:
                    flag = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice");
                    break;
                
            } 
            }catch(InputMismatchException e){
                System.out.println("Invalid Input");
            }
            catch(Exception e){
                System.out.println("Unhandled Error. Contact your admin");
            }
            
        }        
    }
}
