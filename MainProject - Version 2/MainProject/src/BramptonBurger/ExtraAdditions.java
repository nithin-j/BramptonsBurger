/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BramptonBurger;

import SQLConnection.MastersDB;
import java.util.Scanner;
import java.util.ArrayList;

import SQLConnection.utilityDB;

/**
 *
 * @author NITHIN
 */
public class ExtraAdditions {
    
    //enum that contains all the list of additions that a customer can add to his burger....
    /*enum Extras{
        Egg,
        Onions,
        Bread_Crumbs,
        Garlic,
        Grated_Cheese,
        Barbecue_Sauce,
        Chopped_Peppers,
        Hot_sauce,
        Soy_Sauce,
        Peanut_butter,
        Carrots,
        Sun_Dried_Tomatoes,
        Jalapeno,
        Pepperoni,
        Mushrooms
    }
    
    enum Drinks{
        Crush_Peach,
        Crush_Pinaple,
        Pepsi,
        Diet_Pepsi,
        Coca_Cola,
        Coca_Cola_Diet,
        Sprite,
        Fanta,
        Canada_Dry,
        Mountain_dew,
        Canadian_Sparkling_Water
                
    }
    
    
    protected enum BreadType{
        Ciabatta_Roll,
        English_Muffin,
        Kaiser_Roll,
        Onion_Roll,
        Potato_Roll,
        Pretzel_Roll,
        Sesame_Seed_Bun,
        Brown_Rye_Bread_Roll
    }
    
    protected enum Meat{
        Sausage,
        Bacon,
        Chicken
    }
    */
    
    public ExtraAdditions(){
        ExtraPrice = MastersDB.getExtrasPrice();
    }
    
    private ArrayList<Double> ExtraPrice = new ArrayList<Double>(); 
    private static final ArrayList<String> Additions = new ArrayList<String>();
    private static final ArrayList<Double> AdditionPrice = new ArrayList<Double>();
    
    public int getLengthOfAdditions(){
        return Additions.size();
    }
    public double getExtraPrice(int i){
    
        return ExtraPrice.get(i);
    }
    
    public String getAdditions(int i){
        if(Additions.isEmpty()){
            return null;
        }
        else{
            return Additions.get(i);
        }
    }
    public double getAdditionPrice(int i){
        if(AdditionPrice.isEmpty()){
            return 0;
        }
        else{
           return AdditionPrice.get(i); 
        }  
    }
    
    public void setAdditions(String selectedExtra){
        Additions.add(selectedExtra);
    }
    public void setAdditionPrice(double price){
        AdditionPrice.add(price);
    }
    
    public void clearAdditions(){
        Additions.clear();
        AdditionPrice.clear();
    }
    public void AddAdditions(int numberOfAdditions){
        ArrayList<String> extras = new ArrayList<String>();
        extras = MastersDB.getExtras();
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        try{
            do{
            System.out.println("You can add upto "+numberOfAdditions+ " items");
            System.out.println("Select one item from the list: ");
            int j = 1;
            for (String extra : extras) {
                System.out.println(j++ +") "+extra);
            }
            int ch = input.nextInt();
            setAdditions(extras.get(ch-1));
            setAdditionPrice(ExtraPrice.get(ch-1));
            numberOfAdditions--;
            if(numberOfAdditions == 0)
                continue;
            System.out.println("Do you want to add more items(Y/N)");
            input.nextLine();
            String addmore = input.nextLine();
            if(addmore.toLowerCase().equals("n"))
                flag = false;
                
        }while(numberOfAdditions > 0 && flag);
            
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Input");
        }
        catch(Exception e){
            System.out.println("Unhandled error. Please contact your admin");
        }
        
        
    }
    
    public String AddAdditions(){
        
        ArrayList<String> drinks = new ArrayList<String>();
        drinks = MastersDB.getDrinks();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please select the drink: ");
        int j = 1;
        try{
          for(String drink : drinks){
            System.out.println(j++ +") "+drink);
        }  
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Input");
        }
        catch(Exception e){
            System.out.println("Unhandled error. Please contact your admin");
        }
        
        int ch = input.nextInt();
        return drinks.get(ch-1);
        
    }
    
    public ArrayList<String> ChangeItems(){
        Scanner input = new Scanner(System.in);
        ArrayList<String> breadType = new ArrayList<String>(); 
        ArrayList<String> meatType = new ArrayList<String>(); 
        breadType = MastersDB.getBreadTypes();
        meatType = MastersDB.getMeatTypes();
        
        
        ArrayList<String> Items = new ArrayList<String>();        
        System.out.println("Please select the bread type: ");
        int j = 1;
        try{
            for (String roll: breadType) {
                System.out.println(j++ +") "+roll);
            }
            Items.add(breadType.get(input.nextInt()-1));
        
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Input");
        }
        catch(Exception e){
            System.out.println("Unhandled error. Please contact your admin");
        }
               
        System.out.println("Please Select the meat");
        int i = 1;
        try{
            for (String meat : meatType) {
            System.out.println(i++ +") "+meat);
        }
        Items.add(meatType.get(input.nextInt()-1));
        
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Input");
        }
        catch(Exception e){
            System.out.println("Unhandled error. Please contact your admin");
        }
        
        return Items;
    }
    
}