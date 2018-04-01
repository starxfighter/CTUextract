/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:Supply.java
 * Module: Supply child/subclass
 * Created: 02/17/2016
 * Modified:03/02/2016
 * 
 * Purpose: This is the child/subclass to the Accounts class and will be used in the driver.The class will only have those methods and variables that are
 * specific to its own class as well as those that are inherited from the parent class.
 * Modification:
 * 02/26/2016 Correct style issues. Add compueSales method to overload the parent method
 * 03/02/2016 Corrected compueSales so that it will use the abstract method from parent class
 * 
 */
package IT251IP3AccountApp;

/**
 *
 * @author Duane Osburn
 */
public class Supply extends Accounts {
    //Declare class variables
    private double totalSold;
    private double officeSupply;
    private double books;
    private double apparel;
    private double supplyPrice;
    private int supplyQty;
    private String supplyType;
    //Constructor
    public Supply(int accountID, String custName, String custType){
        super(accountID, custName, custType);
    }
    //Declare Accessors
public double gettotalSold(){
    return totalSold;
}    

public double getsupplyPrice(){
    return supplyPrice;
}

public int getsupplyQty(){
    return supplyQty;
}

public double getofficeSupply(){
    return officeSupply;
}

public double getbooks(){
    return books;
}

public double getapparel(){
    return apparel;
}

public String getsupplyType(){
    return supplyType;
}
    //Declare Mutators
public void setofficeSupply(double officeSupply){
    this.officeSupply = officeSupply;
}

public void setbooks(double books){
    this.books = books;
}

public void setapparel(double apparel){
    this.apparel = apparel;
}

public void settotalSold(double totalSold){
    this.totalSold = totalSold;
}

public void setsupplyPrice(double supplyPrice){
    this.supplyPrice = supplyPrice;
}

public void setsupplyQty(int supplyQty){
    this.supplyQty = supplyQty;
}

public void setsupplyType(String supplyType){
    this.supplyType = supplyType;
}
//Declare an override to the tostring of the object class so that the contents of the subclass can be printed out.
@Override
public String toString(){
    return "Supplies{" + " SupplyPrice= " + supplyPrice + " SupplyQty= " + supplyQty +
            " SupplyType= " + supplyType + " AccountID= " + getaccountID() + " CustName= " + getcustName() +
            " Office Supply " + officeSupply + " Books " + books + " Apparel " + apparel +
            "}";
            //" Total Sold " + computeSales() + "}";
}
//The computeSales method here is not an override but an overload of the method that is in the parent class because it 
//has a different signature.
    @Override
    public double computeSales() {
        return getofficeSupply() + getbooks() + getapparel();
    }
    //End Method
//End Class    
}
