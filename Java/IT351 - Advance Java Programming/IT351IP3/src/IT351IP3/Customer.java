/**
 * Course: IT351 - Advance Java Programming
 * Filename:Customer.java
 * Module: Customer Class Definition 
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
public class Customer implements Serializable
{
    //Declare and Initialize variables
    private int custID;
    private String custFName;
    private String CustLName;
    private String custStAddr;
    private String custCity;
    private String custState;
    private int custZip;
    private String custPhone;
    //Setters and Getters
    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustFName() {
        return custFName;
    }

    public void setCustFName(String custFName) {
        this.custFName = custFName;
    }

    public String getCustLName() {
        return CustLName;
    }

    public void setCustLName(String CustLName) {
        this.CustLName = CustLName;
    }

    public String getCustStAddr() {
        return custStAddr;
    }

    public void setCustStAddr(String custStAddr) {
        this.custStAddr = custStAddr;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getCustState() {
        return custState;
    }

    public void setCustState(String custState) {
        this.custState = custState;
    }

    public int getCustZip() {
        return custZip;
    }

    public void setCustZip(int custZip) {
        this.custZip = custZip;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }
//Object Print String
    @Override
    public String toString() {
        //return "Customer{" + "custID=" + custID + ", custFName=" + custFName + ", CustLName=" + CustLName + ", custStAddr=" + custStAddr + ", custCity=" + custCity + ", custState=" + custState + ", custZip=" + custZip + ", custPhone=" + custPhone + '}';
        return "Customer ID: " + custID + "\n" +
                "Name: " + custFName + " " + CustLName + "\n" +
                "Address: " + custStAddr + "\n" +
                "           " + custCity + "," + custState + "    " + custZip + "\n" +
                "Phone: " + custPhone + "\n";
    }

    
    
       
    
}
