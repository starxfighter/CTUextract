/**
 * Course: IT252 - Intermediate Java Programming II
 * Filename:Helper.java
 * Module: Helper class
 * Created: 04/05/2016
 * Modified:04/14/2016
 * 
 * Purpose: This is a class that is full of methods that help the driver application from being too large. Also promotes code re-use
 * 04/05/2016 Creates class and populated with methods
 * 04/14/2016 Added wtiteValidData to write data to a file
 * 
 */
package IT252IP1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
//Writer Component
    public void wtiteValidData(SalesRep sr)throws IOException{
        Path newFile = Paths.get("salesrep.txt");
        //Path newFile = Paths.get("test.txt");
        String delim = ",";
            BufferedWriter writer = Files.newBufferedWriter(newFile, Charset.defaultCharset(), StandardOpenOption.APPEND);
                writer.append("Sales ID" + sr.getSalesRepID());
                writer.append(delim);
                writer.append(sr.getFirstName());
                writer.append(delim);
                writer.append(sr.getLastName());
                writer.append(delim);
                writer.append("SUPPLIES" + sr.getOffSupp());
                writer.append(delim);
                writer.append("BOOKS" + sr.getBooks());
                writer.append(delim);
                writer.append("PAPER" + sr.getPaper());
                String salesD = sr.getSalesDist();
                writer.append(salesD.toUpperCase());
                if (sr.isPhone()){
                    writer.append("Phone");
                }
                if (sr.isEmail()){
                    writer.append("E-mail");
                }
                if (sr.isVisit()){
                    writer.append("Visit");
                }
                writer.newLine();
                writer.flush();
                writer.close();
                      
    }
//End Class    
}
