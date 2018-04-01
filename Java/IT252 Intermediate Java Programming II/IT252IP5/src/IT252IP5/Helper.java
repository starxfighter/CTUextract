/**
 * Course: IT252 - Intermediate Java Programming II
 * Filename:Helper.java
 * Module: Helper class
 * Created: 04/05/2016
 * Modified:05/06/2016
 * 
 * Purpose: This is a class that is full of methods that help the driver application from being too large. Also promotes code re-use
 * 04/05/2016 Creates class and populated with methods
 * 04/14/2016 Added wtiteValidData to write data to a file
 * 04/20/2016 Added writeValidData2 to correct write data issue
 * 04/22/2016 Added readSaleFile to read in the SalesRep file
 *            Added parseData to parse the data read in from the SalesRep file
 *            Added computeTotal to compute the total sold on the data line
 * 05/06/2016 Added data validation to parseData method
 * 
 */
package IT252IP5;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//Writer Component (Not used -- has issues)
    public void wtiteValidData(SalesRep sr)throws IOException{
        //Path newFile = Paths.get("salesrep.txt");
        Path newFile = Paths.get("test.txt");
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
                writer.append(delim);
                writer.append(salesD.toUpperCase());
                if (sr.isPhone()){
                    writer.append("Phone");
                    writer.append(delim);
                }
                if (sr.isEmail()){
                    writer.append("E-mail");
                    writer.append(delim);
                }
                if (sr.isVisit()){
                    writer.append("Visit");
                    writer.append(delim);
                }
                writer.newLine();
                writer.flush();
                writer.close();
                      
    }
//Writer Component
    public void wtiteValidData2(SalesRep sr, String file, boolean writeOpt)throws IOException{
        //Set delimiter variable
        String delim = ",";
        //Create necessary instances to write to the file
        File fwriter = new File(file);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fwriter, writeOpt));
        //write the data elemnets with the delimiter separating the values
                writer.write("Sales ID" + sr.getSalesRepID());
                writer.write(delim);
                writer.write(sr.getFirstName());
                writer.write(delim);
                writer.write(sr.getLastName());
                writer.write(delim);
                writer.write("SUPPLIES" + sr.getOffSupp());
                writer.write(delim);
                writer.write("BOOKS" + sr.getBooks());
                writer.write(delim);
                writer.write("PAPER" + sr.getPaper());
                String salesD = sr.getSalesDist();
                writer.write(delim);
                writer.write(salesD.toUpperCase());
                writer.write(delim);
                if (sr.isPhone()){
                    writer.write("Phone");
                    writer.write(delim);
                }else {
                    writer.write(" ");
                    writer.write(delim);
                }
                if (sr.isEmail()){
                    writer.write("E-mail");
                    writer.write(delim);
                }else {
                     writer.write(" ");
                    writer.write(delim);
                }
                if (sr.isVisit()){
                    writer.write("Visit");
                }else {
                     writer.write(" ");
                }
                writer.newLine();
                writer.flush();
                writer.close();
                      
    }    
//Read in the SalesRep file
    public List<SalesRep> readSaleFile(String filein) throws IOException{
        //create necessary instances to read in the file
        File file = new File(filein);
        FileReader freader = new FileReader(file);
        BufferedReader reader = new BufferedReader(freader);
        //Create array list to hold the data lines read in
        List<SalesRep> sr = new ArrayList<SalesRep>();
        //Do the first read of the file
        String data = reader.readLine();
        //Continue processing until the end of the file is reached
        while (data != null){
            SalesRep s = null;
            try{
                s = parseData(data);
            }catch(Exception e){
                System.out.println("Problem doing the parsing");
            }
            //if the record did not parse then set error messagage otherwise add the record to the array list
            if (s == null){
                System.out.println("The data line is bad " + data);
            }else{
                sr.add(s);
            }
            //read next data line in the file
            data = reader.readLine();
    }//end while
        reader.close();
        return sr;
    }
    //Parse the data read in into its separate components
    private SalesRep parseData(String dline){
        //Declare and Initialize variables
        int salesRepID;
        String firstName;
        String lastName;
        double offSupp;
        double books;
        double paper;
        String salesDist;
        boolean phone = false;
        boolean email = false;
        boolean visit = false;
        //Separate data line into individual tokens
        StringTokenizer st = new StringTokenizer(dline, ",");
        //Assign tokens to data elements
        String tSID = st.nextToken().substring(8);
        salesRepID = Integer.parseInt(tSID);
        firstName = st.nextToken().trim();
        lastName = st.nextToken().trim();
        String tOffSup = st.nextToken().substring(8);
        offSupp = Double.parseDouble(tOffSup);
        String tBook = st.nextToken().substring(5);
        books = Double.parseDouble(tBook);
        String tPaper = st.nextToken().substring(5);
        paper = Double.parseDouble(tPaper);
        salesDist = st.nextToken().trim();
        String tPhone = st.nextToken();
        if ("Phone".equals(tPhone)){
            phone = true;
        }
        String tEmail = st.nextToken();
        if ("E-mail".equals(tEmail)){
            email = true;
        }
        String tVisit = st.nextToken();
        if ("Visit".equals(tVisit)){
            visit = true;
        }
        //Data validation
        if (firstName.length() == 0){
            return null;
        }
        if (lastName.length() == 0){
            return null;
        }
        if (salesRepID < 1){
            return null;
        }
        if (offSupp < 0){
            return null;
        }
        if (books < 0){
            return null;
        }
        if (paper < 0){
            return null;
        }
        if (salesDist.equals("NORTH") || salesDist.equals("SOUTH") || salesDist.equals("WEST") || salesDist.equals("EAST")){
            System.out.println("Valid Sales District");
        }else{
            return null;
        }
        //Initialize instance of SalesRep class
        SalesRep sr = new SalesRep();
        //Build SaleRep Class instance
        sr.setSalesRepID(salesRepID);
        sr.setFirstName(firstName);
        sr.setLastName(lastName);
        sr.setOffSupp(offSupp);
        sr.setBooks(books);
        sr.setPaper(paper);
        sr.setPhone(phone);
        sr.setEmail(email);
        sr.setVisit(visit);
        sr.setSalesDist(salesDist);
        return sr;
        
    }
    //Retieve and Compue the total for items sold -- (Not Used)
    public SalesRep computeTotal(List<SalesRep> sr){
        //Declare variables
        SalesRep starRep = null;
        //Check eack instance, calculate the total sold, if over 8000 mark the data line to be written
        for (SalesRep cs : sr){
            double checkTotal = cs.computeTotal();
            System.out.println("in compute" + cs);
            System.out.println("total" + checkTotal);
            if (checkTotal >= 8000){
                starRep = cs;
            }
        }
        return starRep;
    }
    //Retieve and Compue the total for items sold
    public void computeTotal2(List<SalesRep> sr){
        //Declare variables
        SalesRep starRep = null;
        String starFile = "star.txt";
        boolean writeOpt = true;
        //Check to see if the file is already there. If so then delete it and start fresh
        File f = new File(starFile);
        boolean starsFileExists = f.exists();
        if (starsFileExists){
            f.delete();
            System.out.println("star.txt file deleted");
        }
        //Check eack instance, calculate the total sold, if over 8000 mark the data line to be written
        for (SalesRep cs : sr){
            double checkTotal = cs.computeTotal();
            if (checkTotal >= 8000){
                try {
                    wtiteValidData2(cs, starFile, writeOpt);
                } catch (IOException ex) {
                    System.out.println("error writing star file");
                    Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}
//End Class    
}
