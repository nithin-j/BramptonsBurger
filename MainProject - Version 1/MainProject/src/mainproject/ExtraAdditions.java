/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author NITHIN
 */
public class ExtraAdditions {
    
    //enum that contains all the list of additions that a customer can add to his burger....
    enum Extras{
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
    
    private final double[] ExtraPrice = new double[] {0.8, 0.2, 0.3, 0.3, 0.4, 0.1, 0.5, 0.1, 0.1, 0.1, 0.2, 0.3, 0.3, 0.6,0.8}; //price of all the additions that the customer selected to add
    private static final ArrayList<Extras> Additions = new ArrayList<Extras>();
    private static final ArrayList<Double> AdditionPrice = new ArrayList<Double>();
    
    public int getLengthOfAdditions(){
        return Additions.size();
    }
    public double getExtraPrice(int i){
    
        return ExtraPrice[i];
    }
    public Extras getAdditions(int i){
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
    
    public void setAdditions(Extras selectedExtra){
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
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        try{
            do{
            System.out.println("You can add upto "+numberOfAdditions+ " items");
            System.out.println("Select one item from the list: ");
            int j = 1;
            for (Extras extra : Extras.values()) {
                System.out.println(j++ +") "+extra);
            }
            int ch = input.nextInt();
            setAdditions(Extras.values()[ch-1]);
            setAdditionPrice(getExtraPrice(ch-1));
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
    
    public Drinks AddAdditions(){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please select the drink: ");
        int j = 1;
        try{
          for(Drinks drinks : Drinks.values()){
            System.out.println(j++ +") "+drinks);
        }  
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Input");
        }
        catch(Exception e){
            System.out.println("Unhandled error. Please contact your admin");
        }
        
        int ch = input.nextInt();
        return Drinks.values()[ch-1];
        
    }
    
    public ArrayList<String> ChangeItems(){
        Scanner input = new Scanner(System.in);
        
        ArrayList<String> Items = new ArrayList<String>();        
        System.out.println("Please select the bread type: ");
        int j = 1;
        try{
            for (BreadType roll: BreadType.values()) {
                System.out.println(j++ +") "+roll);
            }
            Items.add((BreadType.values()[input.nextInt()-1]).toString());
        
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Input");
        }
        catch(Exception e){
            System.out.println("Unhandled error. Please contact your admin");
        }
               
        System.out.println("Please Select the meat");
        int i = 1;
        try{
            for (Meat type: Meat.values()) {
            System.out.println(i++ +") "+type);
        }
        Items.add((Meat.values()[input.nextInt()-1]).toString());
        
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Input");
        }
        catch(Exception e){
            System.out.println("Unhandled error. Please contact your admin");
        }
        
        return Items;
    }
    
}