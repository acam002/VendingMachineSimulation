/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinesimulation;
import java.util.Scanner;

/**
 *
 * @author Alberto Camacho
 */
public class VendingMachineSimulation {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VendingMachine v = new VendingMachine();    // Creating a VendingMachine object
        Scanner in = new Scanner(System.in);        // Scanner to read user input
        String choice;                              // Holds what the user would like to do with the vending machine
        String coinChoice;                          // Holds the choice of coin that the user wants to input
        char letter = 65;                           // Initialize the character variable to begin at 'a'
        char productChoice;                         // Holds the product choice when the user wants to buy something
        
        // Do this loop until the user presses Q or q to leave the vending machine
        do {
            
        // Prompt the user to see what they would like to do first
        System.out.println("S)how products  I)nsert coin  B)uy  A)dd product  R)emove coins  Q)uit");
        choice = in.nextLine();
        choice = choice.toUpperCase();
        
        // If the user presses s or S then the products added will be displayed to the user
        if (choice.equals("S")) {
            
            for (int i = 0; i < v.prodSize(); i++)
                System.out.println(v.getProducts().get(i));
        }
        
        // If the user enter i or I then the user can add coins to the machine (moneyAmount field in the 
        // VendingMachine class)
        if (choice.equals("I")) {
            
            // Prompt the user for which coins they want to add
            System.out.println("A) nickel @ 0.05\nB) dime @ 0.1\nC) quarter @ 0.25\nD) dollar @ 1.0");
            coinChoice = in.nextLine();
            coinChoice = coinChoice.toUpperCase();
            
            switch (coinChoice) {
                case "A":
                    v.addOrRemoveCoin(0.05);
                    break;
                case "B":
                    v.addOrRemoveCoin(0.10);
                    break;
                case "C":
                    v.addOrRemoveCoin(0.25);
                    break;
                case "D":
                    v.addOrRemoveCoin(1.00);
                    break;
                default:
                    System.out.println("Error! Invalid value; Returning to main menu...");
                    break;
            }
            
        }
        // Once the user had added their products and inserted their coins
        if (choice.equals("B")) {
            
            // This loop will display the products the user can buy
            for (int i = 0; i < v.getProducts().size(); i++) {
                System.out.println(letter + ")" +v.getProducts().get(i));
                letter++;
            }
            
            // Storing character choice into productChoice
            productChoice = in.next().charAt(0);
            
            // If the user enters a lowercase character choice then remove 32 from its
            // ASCII value in order to get an uppercase letter
            if (productChoice > 90) {
                productChoice -= 32;
            }
            
            // Clear the keyboard buffer
            in.nextLine();
            
            // Reset the char variable for the next loop which determines the user choice
            letter = 65;
            
            // This loop will iterate through all the possible choices 
            // and when it finds the user's choice it will test whether there are any of the product
            // in stock or if they have enough money to buy the product
            for (int i = 0; i < v.getProducts().size(); i++) {
                
                // Looking for user choice
                if (productChoice == (letter + i)) {
                    
                    // Checking to see if the user doesn's have enough money
                    if(v.getMoneyAmount() < v.getProducts().get(i).getPrice()) {
                        System.out.println("You need to enter more coins to buy " +
                                v.getProducts().get(i).getDescription());
                    }
                    
                    // Checking if there aren't any of the product in stock
                    else if (v.getProducts().get(i).getQuantity() == 0) {
                        System.out.println("This machine is sold out of " +
                                v.getProducts().get(i).getDescription());
                    }
                    
                    // If there is product in stock and the user has enough money then 
                    // Remove one from the stock, subtract the amount of money they have by the cost
                    // and print a message saying they have successfully bought the item
                    else {
                        v.getProducts().get(i).removeQuantity();
                        v.addOrRemoveCoin(-v.getProducts().get(i).getPrice());
                        System.out.println("Purchased: " + v.getProducts().get(i));
                    }        
                }
            }
        }
        
        // If a is selected then the user is allowed to add a product
        if (choice.equals("A")) {
            System.out.println("Description:");
            String d = in.nextLine();
            System.out.println("Price:");
            double c = in.nextDouble();
            System.out.println("Quantity:");
            int q = in.nextInt();         
            in.nextLine();
            v.addProduct(d, c, q);
        }
       
        // If r or R is selected then 
        if (choice.equals("R")) {           
            System.out.println("$" + v.getMoneyAmount() + " has been removed");
            v.addOrRemoveCoin(-v.getMoneyAmount());
        }
        
        // Keep looping until the user enters q or Q
        }while (!choice.equals("Q")); 
               
        // Thank the user for using the vending machine
        System.out.println("Thank you for using Gilly vending!");    
     
    }
}
