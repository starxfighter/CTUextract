/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:IT251IP1Driver.java
 * Module: Driver Application 
 * Created: 02/17/2016
 * Modified:03/09/2016
 * 
 * Purpose: This driver application will show how inheritance across classes functions and allows code to be re-used
 * to extend the functionality of the parent class.
 * Modification:
 * 02/26/2016 Added use of parent constructor.Add use of the computeSale method that will be overridden
 * 03/02/2016 Added polymorphic processing of subclasses
 * 03/09/2016 Added a helper class for methods as well as making the application fully functional
 * 
 */
package IT251IP4AccountApp;

import javax.swing.JOptionPane;
/**
 *
 * @author Duane Osburn
 */
public class IT251IP4Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // Declare Variables
    double total = 0;
    double grandTotal = 0;
    String input = null;
    String loopFlag = "y";
    String changeEmp = "n";
    String validIn, empID;
    String welcomeMsg, selectMsg, empIDMsg;
    int validEmpID;
    //Main Process
    Accounts a = null;
    Helper h = new Helper();
    welcomeMsg = " Welcome to Everything 'R US";
    JOptionPane.showMessageDialog(null, welcomeMsg); 
    empIDMsg = "Please enter the employee id";
    empID = JOptionPane.showInputDialog(empIDMsg);
    validEmpID = h.getValidEmp(empID);
    //Processing loop
    while (loopFlag.equals("y")){
        if (changeEmp.equals("y")){
           empIDMsg = "Please enter the employee id";
           empID = JOptionPane.showInputDialog(empIDMsg);
           validEmpID = h.getValidEmp(empID); 
           changeEmp = "n";
        }
        selectMsg = "Please select a function you wish to perform \n" +
                    "Enter 1 to enter supply sales \n" +
                    "Enter 2 to enter paper sales \n" +
                    "Enter 3 to enter service sales \n" +
                    "Enter 4 to change employee \n" +
                    "Enter 5 to quit and see grand totals";
        input = JOptionPane.showInputDialog(selectMsg);
        validIn = h.getValidResp(input);
        switch(validIn){
              case "1":
                a = h.processSupply(validEmpID);
                total = total + a.computeSales();
                System.out.println(a);
                System.out.println(total);
                break;
            case "2":
                a = h.processPaper(validEmpID);
                total = total + a.computeSales();
                System.out.println(a);
                System.out.println(total);
                break;
            case "3":
                a = h.processService(validEmpID);
                total = total + a.computeSales();
                System.out.println(a);
                System.out.println(total);
                break;
            case "4":
                grandTotal = grandTotal + total;
                h.processEmpChange(validEmpID, total);
                changeEmp = "y";
                total = 0;
                break;
            case "5":
                grandTotal = grandTotal + total;
                h.processEmpChange(validEmpID, total);
                h.processGrandTotal(grandTotal);
                loopFlag = "n";
                break;
            default:
                loopFlag = "n";
                break;
        } //End Switch
      //
  } //End While
} //End Main
//Method Declarations
private void oldstuff( )
    {
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
        }
//End Class    
}
