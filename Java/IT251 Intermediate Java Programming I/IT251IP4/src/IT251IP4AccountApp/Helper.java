/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:Helper.java
 * Module: Helper class
 * Created: 03/09/2016
 * Modified:03/09/2016
 * 
 * Purpose: This is a class that is full of methods that help the driver application from being too large. Also promotes code re-use
 * 03/09/2016 Creates class and populated with methods
 * 
 */
package IT251IP4AccountApp;

import javax.swing.JOptionPane;

/**
 *
 * @author Duane OSburn
 */
public class Helper {
//Makes sure the user entered a valid response   
  public String getValidResp(String prompt){
	String classFlag = "y";
	while (classFlag.equals("y")){
              if (prompt.equals("1") || prompt.equals("2") || prompt.equals("3") || prompt.equals("4") || prompt.equals("5")){
                	//System.out.println("valid response");
			classFlag = "n";
		}
		else{
			//System.out.println("not a valid response");
			classFlag ="y";
                        prompt = JOptionPane.showInputDialog("Valid values are 1, 2, 3, 4, 5:");
		}
	}
	return prompt;
    }
//Makes sure the employee id entered is an integer  
  public int getValidEmp(String prompt){
      int empID = 0;
      String classFlag = "y";
      while (classFlag.equals("y")){
          try{
              empID = Integer.parseInt(prompt);
              classFlag = "n";
          } catch (Exception e){
              //System.out.println("not a valid emp id");
              classFlag = "y";
              prompt = JOptionPane.showInputDialog("Not a valid empoyee id. Please re-enter");
          }
      }
      return empID;
  }
//When the employee changes print out the employee statistics
  public void processEmpChange(int empID, double total){
      String saleFinal;
      saleFinal = "The employee id: " + empID + "\n" +
                  " sold: $" + total;
      JOptionPane.showMessageDialog(null, saleFinal);
      System.out.println("The employee id: " + empID + "sold: $" + total);
  }
//Prints out the grand total for the company
  public void processGrandTotal(double grandTotal){
      String grandFinal;
      grandFinal = "The company sold a grand total of: $" + grandTotal;
      JOptionPane.showMessageDialog(null, grandFinal);
  }
//Process the Supply class instance
  public Supply processSupply(int empID){
      String custName = getValidCust(JOptionPane.showInputDialog("Please enter the custromer name"));
      String custType = getValidType(JOptionPane.showInputDialog("Enter Customer Type (Business, Personal, Government)"));
      double bookSale = getValidSale(JOptionPane.showInputDialog("Enter the amount of books sold:"));
      double apparelSale = getValidSale(JOptionPane.showInputDialog("Enter the amount of apparel sold:"));
      double officeSupplySale = getValidSale(JOptionPane.showInputDialog("Enter the amount of books sold:"));
      
      Supply su = new Supply(empID, custName, custType);
      su.setapparel(apparelSale);
      su.setbooks(bookSale);
      su.setofficeSupply(officeSupplySale);
      return su;
  }
//Process the Paper class instance
  public Paper processPaper(int empID){
      String custName = getValidCust(JOptionPane.showInputDialog("Please enter the custromer name"));
      String custType = getValidType(JOptionPane.showInputDialog("Enter Customer Type (Business, Personal, Government)"));
      double numPounds = getValidSale(JOptionPane.showInputDialog("Enter the number of pounds sold:"));
      double pricepPound = getValidSale(JOptionPane.showInputDialog("Enter the price per pound:"));
            
      Paper pa = new Paper(empID, custName, custType);
      pa.setnumPounds(numPounds);
      pa.setpricepPound(pricepPound);
      return pa;
  }
//Process the Service class instance
  public Service processService(int empID){
      String custName = getValidCust(JOptionPane.showInputDialog("Please enter the custromer name"));
      String custType = getValidType(JOptionPane.showInputDialog("Enter Customer Type (Business, Personal, Government)"));
      double ratepHour = getValidSale(JOptionPane.showInputDialog("Enter the rate per hour:"));
      double numofHours = getValidSale(JOptionPane.showInputDialog("Enter the number of hours:"));
            
      Service sv = new Service(empID, custName, custType);
      sv.setratepHour(ratepHour);
      sv.setnumofHours(numofHours);
      return sv;
      
  }
//Makes sure that something was entered for the customer name  
  public String getValidCust(String prompt){
      while (true){
          if (prompt.trim().length() > 0){
              break;
          } else{
              prompt = JOptionPane.showInputDialog("Not a valid customer name. Please re-enter");
          }
      }
    return prompt;  
  }  
//Make sure that a valid customer type was entered  
  public String getValidType(String prompt){
     String classFlag = "y";
	while (classFlag.equals("y")){
              if (prompt.equals("Business") || prompt.equals("Personal") || prompt.equals("Government")){
                	//System.out.println("valid response");
			classFlag = "n";
		}
		else{
			//System.out.println("not a valid response");
			classFlag ="y";
                        prompt = JOptionPane.showInputDialog("Valid Types are Business, Personal or Government:");
		}
	}
    return prompt;  
  }
//Makes sure the double sales amounts are valid doubles
    public double getValidSale(String prompt){
      double sale = 0;
      String classFlag = "y";
      while (classFlag.equals("y")){
          try{
              sale = Double.parseDouble(prompt);
              classFlag = "n";
          } catch (Exception e){
              //System.out.println("not a valid sale");
              classFlag = "y";
              prompt = JOptionPane.showInputDialog("Not a valid sale amount. Please re-enter");
          }
      }
      return sale;
    }
//End Class    
}
