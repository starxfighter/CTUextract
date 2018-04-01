/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:Paper.java
 * Module: Paper child/subclass
 * Created: 02/17/2016
 * Modified:02/26/2016
 * 
 * Purpose: This is the child/subclass to the Accounts class and will be used in the driver.The class will only have those methods and variables that are
 * specific to its own class as well as those that are inherited from the parent class.
 * Modification:
 * 02/26/2016 Correct style issues. Added override of the parent method for computeSales
 * 
 */
package IT251IP2AccountApp;

/**
 *
 * @author Duane Osburn
 */
public class Paper extends Accounts {
    //Declare class variables
    private double totalSold;
    private double numPounds;
    private double pricepPound;
    private String paperType;
    //Constructor
    public Paper(int accountID, String custName, String custType){
        super(accountID, custName, custType);
    }
    //Declare Accessors
    public double getnumPounds(){
        return numPounds;
    }
    
    public double getpricepPound(){
        return pricepPound;
    }
    
    public String getpaperType(){
        return paperType;
    }
    
    public double gettotalSold(){
        return totalSold;
    }
    //Declare Mutators
    public void setnumPounds(double numPounds){
        this.numPounds = numPounds;
    }
    
    public void settotalSold(double totalSold){
        this.totalSold = totalSold;
    }
    
    public void setpricepPound(double pricepPound){
        this.pricepPound = pricepPound;
    }
    
    public void setpaperType(String paperType){
        this.paperType = paperType;
    }
    //Declare an override to the tostring of the object class so that the contents of the subclass can be printed out.
    @Override
    public String toString(){
    return "Paper{" + "NumPounds= " + numPounds + " PricepPound= " + pricepPound + " PaperType= " + paperType +
            " AccountID= " + getaccountID() + " CustName= " + getcustName() + " Total Sold " + totalSold + "}";
}
    //The computeSales method overrides the one that is in the parent class
    @Override
    public double computeSales(double numPounds, double pricepPound){
        totalSold = numPounds * pricepPound;
        return totalSold;
    }
}
