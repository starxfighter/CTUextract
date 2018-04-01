/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:IT251IP1Driver.java
 * Module: Driver Application 
 * Created: 02/17/2016
 * Modified:02/26/2016
 * 
 * Purpose: This driver application will show how inheritance across classes functions and allows code to be re-used
 * to extend the functionality of the parent class.
 * Modification:
 * 02/26/2016 Added use of parent constructor.Add use of the computeSale method that will be overridden
 * 
 */
package IT251IP2AccountApp;

/**
 *
 * @author Duane Osburn
 */
public class IT251IP2Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare Variables
        double holdValue;
        holdValue = 0;
        // This cretaes and populates an instance of the parent class
        Accounts a = new Accounts(12345, "Electronic Warehouse", "Business");
        //This create and populates an instance of the supplies subclass
        Supply su = new Supply(15264,"Bills Gift Shop","Personal");
        su.setsupplyPrice(4.50);
        su.setsupplyQty(150);
        su.setofficeSupply(150.25);
        su.setbooks(55.50);
        su.setapparel(75.00);
        holdValue = su.computeSales(su.getofficeSupply(), su.getbooks(), su.getapparel());
        su.settotalSold(holdValue);
        //This creates and populates an instance of the services subclass
        Service sv = new Service(98654,"Department of Defense","Government");
        sv.setnumofHours(25.25);
        sv.setratepHour(42.00);
        sv.setserviceType("Consultation");
        holdValue = sv.computeSales(sv.getnumofHours(), sv.getratepHour());
        sv.settotalSold(holdValue);
        //This creates and populates an instance of the paper subclss
        Paper p = new Paper(656845, "Documents are Us", "Business");
        p.setnumPounds(350.25);
        p.setpaperType("Heavy Weight");
        p.setpricepPound(12.35);
        holdValue = p.computeSales(p.getnumPounds(), p.getpricepPound());
        p.settotalSold(holdValue);
        //This will print out the contents of the class through the use of the overriden tostring functionality        
        System.out.println(a);
        System.out.println(su);
        System.out.println(sv);
        System.out.println(p);
        
    }
    
}
