/**
 * Course: IT252 - Intermediate Java Programming II
 * Filename:Helper.java
 * Module: Helper class
 * Created: 04/05/2016
 * Modified:04/09/2016
 * 
 * Purpose: This is a class that is full of methods that help the driver application from being too large. Also promotes code re-use
 * 04/05/2016 Creates class and populated with methods
 * 
 */
package IT252IP1;

import javax.swing.JOptionPane;

/**
 *
 * @author Duane OSburn
 */
public class Helper {

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
//make sure that the sales represenative id number is valid. If not send back a 000 to show that its not valid  
  public int getValidID(String prompt){
      int empid;
      try{
          empid = Integer.parseInt(prompt);
      }catch (Exception e){
          empid = 000;
      }
      return empid;     
  }
//Makes sure that something was entered for the customer name. Boolean value sent back.  
  public boolean getValidName(String prompt){
      boolean validName = true;
      if (prompt.trim().length() == 0){
          validName = false;
      }
      return validName;  
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
//Makes sure the double sales amounts are valid doubles. Boolean value sent back.
    public boolean getValidSale(String prompt){
      boolean sale;
      double saleTest = 0;
      try{
              saleTest = Double.parseDouble(prompt);
              sale = true;
      } catch (Exception e){
              sale = false;
              }
      return sale;
    }
//End Class    
}
