/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:Paper.java
 * Module: Paper child/subclass
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
public class Paper extends Accounts {
    //Declare class variables
    private double NumPounds;
    private double PricepPound;
    private String PaperType;
    //Declare Accessors
    public double getNumPounds(){
        return NumPounds;
    }
    
    public double getPricepPound(){
        return PricepPound;
    }
    
    public String getPaperType(){
        return PaperType;
    }
    //Declare Mutators
    public void setNumPounds(double NumPounds){
        this.NumPounds = NumPounds;
    }
    
    public void setPricepPound(double PricepPound){
        this.PricepPound = PricepPound;
    }
    
    public void setPaperType(String PaperType){
        this.PaperType = PaperType;
    }
    //Declare an override to the tostring of the object class so that the contents of the subclass can be printed out.
    @Override
    public String toString(){
    return "Paper{" + "NumPounds= " + NumPounds + " PricepPound= " + PricepPound + " PaperType= " + PaperType +
            " AccountID= " + getAccountID() + " CustName= " + getCustName() + "}";
}
}
