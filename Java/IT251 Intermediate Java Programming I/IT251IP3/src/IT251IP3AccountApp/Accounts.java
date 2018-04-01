/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:Accounts.java
 * Module: Accounts Parent/Superclass
 * Created: 02/23/2016
 * Modified:03/02/2016
 * 
 * Purpose: This is the parent/superclass for the subclasses used in the driver.The class will only have those methods and variables that are
 * common across all of the subclasses. 
 * Modification:
 * 02/26/2016 Added a method called computeSales which can be overriden by subclasses
 * 03/02/2016 Made the class abstract. Also made the computeSales method abstract
 * 
 */
package IT251IP3AccountApp;

/**
 *
 * @author Duane Osburn
 */
public abstract class Accounts {
    //Declare class variables
    private int accountID;
    private String custName;
    private String custType;
    private double totalSold;
    //Constructor
    public Accounts(int accountID, String custName, String custType){
        this.accountID = accountID;
        this.custName = custName;
        this.custType = custType;
    }
    //Declare Accessors
    public int getaccountID(){
        return accountID;
    }
    
    public String getcustName(){
        return custName;
    }
    
    public String getcustType(){
        return custType;
    }
    //Declare Mutators
    public void setaccountId(int accountID){
        this.accountID = accountID;
    }
    
    public void setcustName(String custName){
        this.custName = custName;
    }
    
    public void setcustType(String custType){
        this.custType = custType;
    }
    //Declare an override to the tostring of the object class so that the contents of the subclass can be printed out.
    @Override
    public abstract String toString();
    
    //The computeSales method is here so that the subclasses can override it.
    public abstract double computeSales( );
    //End Abstract Method
//End Class        
}
