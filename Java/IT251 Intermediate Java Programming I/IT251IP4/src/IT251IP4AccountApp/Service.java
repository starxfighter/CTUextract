/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:Service.java
 * Module: Service child/subclass
 * Created: 02/17/2016
 * Modified:03/09/2016
 * 
 * Purpose: This is the child/subclass to the Accounts class and will be used in the driver.The class will only have those methods and variables that are
 * specific to its own class as well as those that are inherited from the parent class.
 * Modification:
 * 02/26/2016 correct style issues. Added override of the parent method for computeSales
 * 03/02/2016 Corrected compueSales so that it will use the abstract method from parent class
 * 03/09/2016 Changed accountID to emploeeID. Changed getaccountID to getemployeeID.
 * 
 */
package IT251IP4AccountApp;

/**
 *
 * @author Duane Osburn
 */
public class Service extends Accounts{
    //Declare class variables
    private double numofHours;
    private double ratepHour;
    private String serviceType;
    private double totalSold;
    //Constructor
    public Service(int employeeID, String custName, String custType){
        super(employeeID, custName, custType);
    }
    //Declare Accessors
    public double getnumofHours(){
        return numofHours;
    }
    
    public double gettotalSold(){
        return totalSold;
    }
    
    public double getratepHour(){
        return ratepHour;
    }
    
    public String getserviceType(){
        return serviceType;
    }
    //Declare Mutators
    public void settotalSold(double totalSold){
        this.totalSold = totalSold;
    }
    
    public void setnumofHours(double numofHours){
        this.numofHours = numofHours;
    }
    
    public void setratepHour(double ratepHour){
        this.ratepHour = ratepHour;
    }
    
    public void setserviceType(String serviceType){
        this.serviceType = serviceType;
    }
    //Declare an override to the tostring of the object class so that the contents of the subclass can be printed out.
    @Override
    public String toString(){
    return "Services{" + "NumofHours= " + numofHours + " RatepHour= " + ratepHour + " ServiceType= " + serviceType +
            " AccountID= " + getemployeeID() + " CustName= " + getcustName() + "}";
            //" Total Sold " + computeSales() +  "}";
}
    //The computeSales method here overrides the one that is in the parent class
    @Override
    public double computeSales(){
        return getnumofHours() * getratepHour();
    }
    //End Method
//End Class    
}
