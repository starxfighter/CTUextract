/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:IT251IP1Driver.java
 * Module: Driver Application 
 * Created: 02/17/2016
 * Modified:03/02/2016
 * 
 * Purpose: This driver application will show how inheritance across classes functions and allows code to be re-used
 * to extend the functionality of the parent class.
 * Modification:
 * 02/26/2016 Added use of parent constructor.Add use of the computeSale method that will be overridden
 * 03/02/2016 Added polymorphic processing of subclasses
 * 
 */
package IT251IP3AccountApp;

/**
 *
 * @author Duane Osburn
 */
public class IT251IP3Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare Variables
        double holdValue;
        holdValue = 0;
        //This create and populates an instance of the supplies subclass
        Supply su = new Supply(15264,"Bills Gift Shop","Personal");
        su.setsupplyPrice(4.50);
        su.setsupplyQty(150);
        su.setofficeSupply(150.25);
        su.setbooks(55.50);
        su.setapparel(75.00);
        //This creates and populates an instance of the services subclass
        Service sv = new Service(98654,"Department of Defense","Government");
        sv.setnumofHours(25.25);
        sv.setratepHour(42.00);
        sv.setserviceType("Consultation");
        //This creates and populates an instance of the paper subclss
        Paper p = new Paper(656845, "Documents are Us", "Business");
        p.setnumPounds(350.25);
        p.setpaperType("Heavy Weight");
        p.setpricepPound(12.35);
        //This will print out the contents of the class through the use of the overriden tostring functionality        
        System.out.println(su);
        System.out.println(sv);
        System.out.println(p);
        //This declares an array to hold each of the subclasses
        Accounts[] account = new Accounts[3];
        account[0] = su;
        account[1] = sv;
        account[2] = p;
        //This enhanced for loop will print out and invoke the computeSales method polymorphically
        System.out.println("Printing class polymorphically");
        for (Accounts a : account){
            
             System.out.println(a.toString());
             System.out.println("The total sold is: " + a.computeSales());
        }     
 //End Main       
    }
//End Class    
}
