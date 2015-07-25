/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinesimulation;

/**
 *
 * @author KCISCisco
 */

// This class seems self-explanatory...
public class Product {
    private String description;
    private double price;
    private int quantity;

    public Product(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
 
    @Override
    public String toString() {
        return description + " @ $" + price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void removeQuantity() {
        quantity -= 1;
    }
    
}
