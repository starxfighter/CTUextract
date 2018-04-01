/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:Services.java
 * Module: Services child/subclass
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
public class Services extends Accounts{
    //Declare class variables
    private double NumofHours;
    private double RatepHour;
    private String ServiceType;
    //Declare Accessors
    public double getNumofHours(){
        return NumofHours;
    }
    
    public double getRatepHour(){
        return RatepHour;
    }
    
    public String getServiceType(){
        return ServiceType;
    }
    //Declare Mutators
    public void setNumofHours(double NumofHours){
        this.NumofHours = NumofHours;
    }
    
    public void setRatepHour(double RatepHour){
        this.RatepHour = RatepHour;
    }
    
    public void setServiceType(String ServiceType){
        this.ServiceType = ServiceType;
    }
    //Declare an override to the tostring of the object class so that the contents of the subclass can be printed out.
    @Override
    public String toString(){
    return "Services{" + "NumofHours= " + NumofHours + " RatepHour= " + RatepHour + " ServiceType= " + ServiceType +
            " AccountID= " + getAccountID() + " CustName= " + getCustName() + "}";
}
}
