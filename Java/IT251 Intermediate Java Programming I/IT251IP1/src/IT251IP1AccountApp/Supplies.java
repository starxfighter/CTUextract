/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:Supplies.java
 * Module: Supplies child/subclass
 * Created: 02/17/2016
 * Modified:02/18/2016
 * 
 * Purpose: This is the child/subclass to the Accounts class and will be used in the driver.The class will only have those methods and variables that are
 * specific to its own class as well as those that are inherited from the parent class.
 * 
 */
package IT251IP1AccountApp;

/**
 *
 * @author Duane Osburn
 */
public class Supplies extends Accounts {
    //Declare class variables
    private double TotalSold;
    private double SupplyPrice;
    private int SupplyQty;
    private String SupplyType;
    //Declare Accessors
public double getTotalSold(){
    return TotalSold;
}    

public double getSupplyPrice(){
    return SupplyPrice;
}

public int getSupplyQty(){
    return SupplyQty;
}

public String getSupplyType(){
    return SupplyType;
}
    //Declare Mutators
public void setTotalSold(double TotalSold){
    this.TotalSold = TotalSold;
}

public void setSupplyPrice(double SupplyPrice){
    this.SupplyPrice = SupplyPrice;
}

public void setSupplyQty(int SupplyQty){
    this.SupplyQty = SupplyQty;
}

public void setSupplyType(String SupplyType){
    this.SupplyType = SupplyType;
}
//Declare an override to the tostring of the object class so that the contents of the subclass can be printed out.
@Override
public String toString(){
    return "Supplies{" + "TotalSold= " + TotalSold + " SupplyPrice= " + SupplyPrice + " SupplyQty= " + SupplyQty +
            " SupplyType= " + SupplyType + " AccountID= " + getAccountID() + " CustName= " + getCustName() + "}";
}
    
}
