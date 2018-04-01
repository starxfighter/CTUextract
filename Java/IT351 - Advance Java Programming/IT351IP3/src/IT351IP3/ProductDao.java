/**
 * Course: IT351 - Advance Java Programming
 * Filename:ProductDao.java
 * Module: Product Data Access Object Class Definition 
 * Created: 09/01/2016
 * Modified:09/01/2016
 * 
 * Purpose: This class definition holds the methods necessary to access the product table within the database and perform SQL commands against that database table.
 * Modification:
 * 
 * Note: Connection definition to access encrypted access database
 * Connection con2 = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\User\\Documents\\IT351Store.accdb;jackcessOpener=CryptCodecOpener","Duane", "student");
 */
package IT351IP3;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Duane Osburn
 */
public class ProductDao 
{
    //Declare class variables
    private Connection con;
    
    //Declare constructor
    public ProductDao(Connection c)
    {
        this.con = c;
    }
    
    //Method for inserting data into theproduct table
    public void insert(Product p) throws SQLException
    {
        Statement st = con.createStatement();
        st.executeUpdate("insert into Product values(" + p.getProductId() + ", " +
                "'" + p.getProductName() + "'," +
                "'" + p.getProductDesc()+ "'," + 
                p.getProductPrice()+ ");");
    }
    
    //Method for updating a row in the product table based upon a passed in product id
    public void update(Product p) throws SQLException
    {
        //update Product set price = 125.25 where [Product ID]= 100
        System.out.println("Inside Update");
        Statement st = con.createStatement();
        st.executeUpdate("update Product set price =" + p.getProductPrice() + " WHERE (((Product.[Product ID])=" + p.getProductId()+ "))");
    }
    
    //Method for deleting a row in the product table based upon a passed in product id
    public void delete(Product p) throws SQLException
    {
        Statement st = con.createStatement();
        st.executeUpdate("delete from Product WHERE (((Product.[Product ID])=" + p.getProductId()+ "))");
    }
    
    //Method for listing all of the rows in the product table
    public List<Product> query() throws SQLException
    {
        List<Product> products = new ArrayList<Product>();
        Statement st = con.createStatement();
        ResultSet results = st.executeQuery("select * from Product");
        while (results.next())
        {
            //Get data from the result set
            int id = results.getInt("Product ID");
            String name = results.getString("Product Name");
            String description = results.getString("Description");
            double price = results.getDouble("Price");
            //Build the product class
            Product p = new Product();
            p.setProductId(id);
            p.setProductName(name);
            p.setProductDesc(description);
            p.setProductPrice(price);
            //Add it to the list that is to be passed back
            products.add(p);
        }
       return products; 
    }
    
    //Method to return a specific row from the table based upon a passed in product id
    public Product inquiry(Product p) throws SQLException
    {
        Statement st = con.createStatement();
        ResultSet results = st.executeQuery("select * from Product WHERE (((Product.[Product ID])=" + p.getProductId()+ "))");
        Product x = new Product();
        while (results.next())
        {
            //Get data from the result set
            int id = results.getInt("Product ID");
            String name = results.getString("Product Name");
            String description = results.getString("Description");
            double price = results.getDouble("Price");
            //Build the product class
            x.setProductId(id);
            x.setProductName(name);
            x.setProductDesc(description);
            x.setProductPrice(price);
        }
        return x;
    }
}//End Class
