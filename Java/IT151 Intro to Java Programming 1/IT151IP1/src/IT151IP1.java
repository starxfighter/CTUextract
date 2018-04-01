/**
 * Course:   IT151 - Introduction to Java Programming
 * Filename: IT151IP1.java
 * Created:  10/08/15 by Duane Osburn
 * Modified: 10/08/15 by Duane Osburn
 * 
 * Purpose:  Created a simple program that will ask the user to input information
 * and then will have their inputted information displayed back to them.
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * @author Duane Osburn
 */

public class IT151IP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //Declare Variables for Input and Output Messages  
      String openingMsg, prodIDMsg, prodNameMsg, prodPriceMsg, outputMsg;
      String thankyouMsg, prodIDout, prodNameout, prodPriceout, endingmsg;
      //Declare Variables for data 
      String prodNamein, convprice, prodIDin;
      Double prodPricein;
      //Display opening interaction message
      openingMsg = "Welcome to the On-Line Ordering System\n";
      JOptionPane.showMessageDialog(null, openingMsg);
      //Get Product ID from the user
      prodIDMsg = "Please enter the 5 digit Product ID:\n";
      prodIDin = JOptionPane.showInputDialog(prodIDMsg);
      //Get Product Name from the user
      prodNameMsg = "Please enter the Product Name:\n";
      prodNamein = JOptionPane.showInputDialog(prodNameMsg);
      //Get Product Price from the user and convert it to a numeric value
      prodPriceMsg = "Please enter the Product price:\n";
      convprice = JOptionPane.showInputDialog(prodPriceMsg);
      prodPricein = Double.parseDouble(convprice);
      //
      //
      // build output strings
      thankyouMsg     = "Thank You for you order.\n\n";
      prodIDout    = "You entered a product ID of: " + prodIDin + ".\n";
      prodNameout  = "You entered a product name of: " + prodNamein + ".\n";
      prodPriceout  = "You entered a product price of: " + prodPricein + ".\n";
      endingmsg = "Thank you for visiting!" + "\n\n"
		  + "Your order will be shipped in 5 days.\n";
      //Print to the console what the user entered
      System.out.print("Product ID:");
      System.out.println(prodIDin);
      System.out.print("Product Name:");
      System.out.println(prodNamein);
      System.out.print("Product Price: $");
      System.out.printf("%,.2f" , prodPricein);
      System.out.println(" ");

      // create and display output string
      outputMsg = thankyouMsg + prodIDout + prodNameout + prodPriceout + endingmsg;
		JOptionPane.showMessageDialog(null, outputMsg);

System.exit(0);
      
      
    }
    
}
