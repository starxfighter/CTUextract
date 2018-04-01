/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:Accounts.java
 * Module: Accounts Parent/Superclass
 * Created: 02/17/2016
 * Modified:02/18/2016
 * 
 * Purpose: This is the parent/superclass for the subclasses used in the driver.The class will only have those methods and variables that are
 * common across all of the subclasses.
 * 
 */
package IT251IP1AccountApp;

/**
 *
 * @author Duane Osburn
 */
public class Accounts {
    //Declare class variables
    private int AccountID;
    private String CustName;
    private String CustType;
    //Declare Accessors
    public int getAccountID(){
        return AccountID;
    }
    
    public String getCustName(){
        return CustName;
    }
    
    public String getCustType(){
        return CustType;
    }
    //Declare Mutators
    public void setAccountId(int AccountID){
        this.AccountID = AccountID;
    }
    
    public void setCustName(String CustName){
        this.CustName = CustName;
    }
    
    public void setCustType(String CustType){
        this.CustType = CustType;
    }
    //Declare an override to the tostring of the object class so that the contents of the subclass can be printed out.
    @Override
    public String toString(){
        return "Accounts{" + "AccountID= " + AccountID + " CustName= " + CustName + " Custtype= " + CustType + "}";
    }
}
