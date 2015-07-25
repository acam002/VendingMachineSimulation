/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinesimulation;
import java.util.ArrayList;
/**
 *
 * @author KCISCisco
 */
public class VendingMachine {

    // Holds all the products in the vending machine
    private ArrayList<Product> prod = new ArrayList<>();  // The list of products in a vending machine
    private double moneyAmount;                           // The current amount of money inside the vending machine tray
     
    
    // Default constructor
    public VendingMachine() {
    }
    
    
    // This method will add a product to the prod ArrayList
    public void addProduct(String s, double p, int q) {
        prod.add(new Product(s, p, q));   
        }
   
    // Return the ArrayList in the vendingmachine object for use in the main method
    public ArrayList<Product> getProducts() {
        return prod;
        }   
    
    // This method returns the current size of the prod ArrayList which holds the information 
    // of all the available products being vended
    public int prodSize() {
        return prod.size();
    }
    
    // Adds and removes coin from the moneyAmount field
    public void addOrRemoveCoin(double coin) {
        
        moneyAmount += coin;
    }

    // Returns the amount of money in the vending machine
    public double getMoneyAmount() {
        return moneyAmount;
    }
   
}

 