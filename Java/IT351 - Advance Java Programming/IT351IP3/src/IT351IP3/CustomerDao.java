/**
 * Course: IT351 - Advance Java Programming
 * Filename:CustomerDao.java
 * Module: Customer Data Access Object Class Definition 
 * Created: 09/01/2016
 * Modified:09/01/2016
 * 
 * Purpose: This class definition holds the methods necessary to access the customer table within the database and perform SQL commands against that database table.
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
public class CustomerDao 
{
    //Declare Class variables
    private Connection con;
    
    //Class Constuctor
    public CustomerDao(Connection c)
    {
        this.con = c;
    }
    
    //Method to insert data into the customer table
    public void insert(Customer c) throws SQLException
    {
        Statement st = con.createStatement();
        st.executeUpdate("insert into Customer values(" + c.getCustID() + ", " +
                "'" + c.getCustFName()+ "', " +
                "'" + c.getCustLName()+ "', " +
                "'" + c.getCustStAddr()+ "', " +
                "'" + c.getCustCity()+ "', " +
                "'" + c.getCustState()+ "', " +
                c.getCustZip()+", " +
                "'" + c.getCustPhone()+ "');");
      
    }
    
    //Method to update data that is in the customer table based upon a passed in customer id
    public void update(Customer c) throws SQLException
    {
        
        System.out.println("Inside Update");
        Statement st = con.createStatement();
        st.executeUpdate("update Customer set address = " +
                "'"+c.getCustStAddr()+ "'" +
                ", city = " + "'" + c.getCustCity()+"'" +
                ", state = " + "'" +c.getCustState()+ "'" + 
                ", [Zip Code] = " +c.getCustZip() +
                " where (((Customer.[Customer ID])=" +c.getCustID()+ "))");

    }
    
    //Method to delete a record from the customer table based upon a passed in customer id
    public void delete(Customer c) throws SQLException
    {
        
        System.out.println("Got connection");
        Statement st = con.createStatement();
        st.executeUpdate("delete from Customer WHERE (((Customer.[Customer ID])=" + c.getCustID()+ "))");
        
    }
    
    //Method to list all of the records that are in the customer table
    public List<Customer> query() throws SQLException
    {
        List<Customer> customers = new ArrayList<Customer>();
        Statement st = con.createStatement();
        ResultSet results = st.executeQuery("select * from Customer");
        while (results.next())
        {
            //Get data out of the result set
            int id = results.getInt("Customer ID");
            String fName = results.getString("First Name");
            String lName = results.getString("Last Name");
            String addr = results.getString("Address");
            String city = results.getString("City" );
            String state = results.getString("State");
            int zip = results.getInt("Zip Code");
            String phone = results.getString("Phone");
            //Build the customer class record
            Customer c = new Customer();
            c.setCustID(id);
            c.setCustFName(fName);
            c.setCustLName(lName);
            c.setCustStAddr(addr);
            c.setCustCity(city);
            c.setCustState(state);
            c.setCustZip(zip);
            c.setCustPhone(phone);
            //Add to list that is passed back
            customers.add(c);
        }
       return customers; 
    }
    
    //Method to return a specific record based upon the passed in customer id
    public Customer inquiry(Customer c) throws SQLException
    {
        Statement st = con.createStatement();
        ResultSet results = st.executeQuery("select * from Customer WHERE (((Customer.[Customer ID])=" + c.getCustID()+ "))");
        Customer x = new Customer();
        while (results.next())
        {
            //Get data out of the result set
            int id = results.getInt("Customer ID");
            String fName = results.getString("First Name");
            String lName = results.getString("Last Name");
            String addr = results.getString("Address");
            String city = results.getString("City" );
            String state = results.getString("State");
            int zip = results.getInt("Zip Code");
            String phone = results.getString("Phone");
            //Build the customer class record
            x.setCustID(id);
            x.setCustFName(fName);
            x.setCustLName(lName);
            x.setCustStAddr(addr);
            x.setCustCity(city);
            x.setCustState(state);
            x.setCustZip(zip);
            x.setCustPhone(phone);
        }
        
        return x;
    //    
    }
    
}//End class
