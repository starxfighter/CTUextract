/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:IT251IP1Driver.java
 * Module: Driver Application 
 * Created: 02/17/2016
 * Modified:02/18/2016
 * 
 * Purpose: This driver application will show how inheritance across classes functions and allows code to be re-used
 * to extend the functionality of the parent class.
 * 
 */
package IT251IP1AccountApp;

/**
 *
 * @author Duane Osburn
 */
public class IT251IP1Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // This cretaes and populates an instance of the parent class
        Accounts a = new Accounts();
        a.setAccountId(12345);
        a.setCustName("Electronic Warehouse");
        a.setCustType("Business");
        //This create and populates an instance of the supplies subclass
        Supplies su = new Supplies();
        su.setTotalSold(150.25);
        su.setSupplyPrice(4.50);
        su.setSupplyQty(150);
        su.setAccountId(15264);
        su.setCustName("Bills Gift Shop");
        su.setCustType("Personal");
        //This creates and populates an instance of the services subclass
        Services sv = new Services();
        sv.setNumofHours(25.25);
        sv.setRatepHour(42.00);
        sv.setServiceType("Consultation");
        sv.setAccountId(98654);
        sv.setCustName("Department of Defense");
        sv.setCustType("Government");
        //This creates and populates an instance of the paper subclss
        Paper p = new Paper();
        p.setNumPounds(350.25);
        p.setPaperType("Heavy Weight");
        p.setPricepPound(12.35);
        p.setAccountId(656845);
        p.setCustName("Documents are Us");
        p.setCustType("Business");
        //This will print out the contents of the class through the use of the overriden tostring functionality        
        System.out.println(a);
        System.out.println(su);
        System.out.println(sv);
        System.out.println(p);
        
    }
    
}
