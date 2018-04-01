/**
 * Course: IT351 - Advance Java Programming
 * Filename:Product.java
 * Module: Product Class Definition 
 * Created: 08/19/2016
 * Modified:08/19/2016
 * 
 * Purpose: This class definition holds the structure of the customer information and will be used as the object structure
 * that is passed between the client and the server.
 * Modification:
 * 
 */
package IT351IP3;

import java.io.Serializable;

/**
 *
 * @author Duane Osburn
 */
public class Product implements Serializable 
{
    //Declare and Initalize variables
    private int productId;
    private String productName;
    private String productDesc;
    private double productPrice;
    //Setters and Getters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    //Object Print STring
    @Override
    public String toString() {
        //return "Product{" + "productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc + ", productPrice=" + productPrice + '}';
        return "Product ID: " + productId + "  Product Name: " + productName + "\n" +
                "Product Description: " + productDesc + "\n" +
                "Product Price: $" + productPrice + "\n";
    }
    
    
    
    
}
