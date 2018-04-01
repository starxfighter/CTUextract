/**
 * Course:   IT151 - Introduction to Java Programming
 * Filename: IT151IP4.java
 * Created:  10/28/15 by Duane Osburn
 * Modified: 10/28/15 by Duane Osburn
 * 
 * Purpose:  Created a simple program that will ask the user to input information, verify the input and then
 * use it to build a class and then will have their inputed information displayed back to them. The sales average
 * and the shipping charge will be done in a looping method that will use a sentinel control
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * @author Duane Osburn
 */
class HardDrive {
//Declare attributes
    private int HDId;
    private String HDType;
    private String HDClass;
    private String HDSize;
    private String HDAccSp;
    private double HDPrice;
    private String HDVendor;
//Set Constructor    
    public HardDrive (int iProdId, String iType, String iClass, String iSize, String iAccessSp, double iPrice, String iVendor){
		
		HDId = iProdId;
		HDType = iType;
		HDClass = iClass;
		HDSize = iSize;
		HDAccSp = iAccessSp;
		HDPrice = iPrice;
		HDVendor = iVendor;
		}
//Mutators
	public void setProdId(int setProdId)
	{
		HDId = setProdId;
	}
	public void setType(String setType)
	{
		HDType = setType;
	}
	public void setClass(String setClass)
	{
		HDClass = setClass;
	}
	public void setSize(String setSize)
	{
		HDSize = setSize;
	}
	public void setAccess(String setAccess)
	{
		HDAccSp = setAccess;
	}
	public void setPrice(double setPrice)
	{
		HDPrice = setPrice;
	}
	public void setVendor(String setVendor)
	{
		HDVendor = setVendor;
	}
//Accessors
	public int getProdId()
	{
		return HDId;
	}
	public String getType()
	{
		return HDType;
	}
	public String getHClass()
	{
		return HDClass;
	}
	public String getSize()
	{
		return HDSize;
	}
	public String getAccess()
	{
		return HDAccSp;
	}
	public double getPrice()
	{
		return HDPrice;
	}
	public String getVendor()
	{
		return HDVendor;
	}
}//end class HardDrive
//
public class IT151IP4 {

    /**
     * @param args the command line arguments
     */
    //Methods
    //getValidClass: Makes sure the user enters one of the three valid classifications
    private static String getValidClass(String prompt){
		String classFlag = "y";
		while (classFlag.equals("y")){
                        if (prompt.equals("internal") || prompt.equals("external") || prompt.equalsIgnoreCase("NAS")){
				System.out.println("valid class type");
				classFlag = "n";
			}
			else{
				System.out.println("not valid class type");
				classFlag ="y";
                                prompt = JOptionPane.showInputDialog("Valid Formats are internal or external or NAS:");
			}
		}
		return prompt;
    }
   //isNumeric: called by getNumericInput. Makes sure the user enters a 1 to 5 digit numeric
   //id number 
    private static boolean isNumeric(String s){
		try {
			int v = Integer.parseInt(s);
			System.out.println(v);
			return true;
		}
		catch (Exception e)
		{
			System.out.println("error");
			return false;
		}
	}
    //getNumericInput: Makes sure the user has enterd a numeric id value
    private static int getNumericInput(String prompt){
		int nPrompt = 0;
		String numericFlag = "n";
		while (numericFlag.equals("n"))
		{
			if (isNumeric(prompt))
			{
				nPrompt = Integer.parseInt(prompt);
				if (nPrompt >= 1 && nPrompt <= 99999)
				{
					numericFlag = "y";
				}
				else 
				{
					numericFlag = "n";
                                        prompt = JOptionPane.showInputDialog("Re-enter a valid id number between 1 and 99999");
				}
			}
                        else{
                            numericFlag = "n";
                            prompt = JOptionPane.showInputDialog("Re-enter a valid id number between 1 and 99999");
			}
                }
                return nPrompt;
    }            
    //Compute Sales Average
    private static double computeAverageSales(String SalesIn){
     double totalsales = 0, saleswork, avgSales;
     int loopcounter = 0;
     while (!"quit".equals(SalesIn)){
         saleswork = Double.parseDouble(SalesIn);
         System.out.print("Sales:" + saleswork + "\n");
         totalsales = totalsales + saleswork;
         loopcounter ++;
         SalesIn = JOptionPane.showInputDialog("Please enter the next sales total(enter quit to stop):\n");
     } 
     avgSales = totalsales / loopcounter;
     return avgSales;
    }
    //Compute Shipping Charges
    private static double computeShippingCharges(String ShipIn){
     double totalship, shipwork;
     int loopcounter = 0;
     totalship = 0;
     while (!"quit".equals(ShipIn)){
         shipwork = Double.parseDouble(ShipIn);
         System.out.println("Shipping Charge:" + shipwork);
         totalship += shipwork;
         loopcounter ++;
         ShipIn = JOptionPane.showInputDialog("Please enter the next shipping charge(enter quit to stop):\n");
     }
     return totalship;
    }
    //Main
    public static void main(String[] args) {
      //Declare Variables for Input and Output Messages  
      String openingMsg, prodIDMsg, prodClassMsg, prodPriceMsg, outputMsg,prodSalesAvgMsg, prodShipMsg;
      String thankyouMsg, prodIDout, prodNameout, prodPriceout, endingmsg, prodAvgSalesout, prodShipChrgout;
      //Declare Variables for data 
      String prodClassin, convprice, clType, clSize, clAccsp, clVendor;
      int prodIDin;
      Double prodPricein,prodSalesAvgIn,prodShipIn;
      //Declare Variables for Class retrieval
      String cClassOut;
      int cIDOut;
      Double cPriceOut;
      //Display opening interaction message
      openingMsg = "Welcome to the Hard Drive On-Line Ordering System\n";
      JOptionPane.showMessageDialog(null, openingMsg);
      //Get Product ID from the user
      prodIDMsg = JOptionPane.showInputDialog("Please enter the 5 digit numeric Product ID:\n");
      //prodIDin = Integer.parseInt(JOptionPane.showInputDialog(prodIDMsg));
      prodIDin = getNumericInput(prodIDMsg);
      //Get Product Classification from the user
      prodClassMsg  = JOptionPane.showInputDialog("What type of classification (internal or external or NAS)?");
      prodClassin = getValidClass(prodClassMsg);
      //Get Product Price from the user and convert it to a numeric value
      prodPriceMsg = "Please enter the Product price:\n";
      convprice = JOptionPane.showInputDialog(prodPriceMsg);
      prodPricein = Double.parseDouble(convprice);
      //Compute Sales Average
      prodSalesAvgMsg = JOptionPane.showInputDialog("Please enter the first sales total:\n");
      prodSalesAvgIn = computeAverageSales(prodSalesAvgMsg);
      //Compute Shipping Charges
      prodShipMsg = JOptionPane.showInputDialog("Please enter the first shipping charge:\n");
      prodShipIn = computeShippingCharges(prodShipMsg);
      //Build Class
      HardDrive cUser = new HardDrive(prodIDin,null,prodClassin,null,null,prodPricein,null);
      //
      clType = "plate";
      clSize = "1TB"; 
      clAccsp = "7500//16ms"; 
      clVendor = "Kingston";
      cUser.setType(clType);
      cUser.setSize(clSize);
      cUser.setAccess(clAccsp);
      cUser.setVendor(clVendor);
      //
      // build output strings
      //
      //Get Class Information
      cIDOut = cUser.getProdId();
      cClassOut = cUser.getHClass();
      cPriceOut = cUser.getPrice();
      //Set Output Messages
      thankyouMsg     = "Thank You for you order.\n\n";
      prodIDout    = "You entered a product ID of: " + cIDOut + ".\n";
      prodNameout  = "You entered a product classification of: " + cClassOut + ".\n";
      prodPriceout  = "You entered a product price of: " + cPriceOut + ".\n";
      prodAvgSalesout = "The Average Sales for this product is: " + prodSalesAvgIn + ".\n";
      prodShipChrgout = "The total shipping charges for this product is: " + prodShipIn + ".\n";
      endingmsg = "Thank you for visiting!" + "\n\n"
		  + "Your order will be shipped in 5 days.\n";
      //Print to the console what the user entered
      System.out.print("Product ID:");
      System.out.println(cIDOut);
      System.out.print("Product Classification:");
      System.out.println(cClassOut);
      System.out.print("Product Price: $");
      System.out.printf("%,.2f" , cPriceOut);
      System.out.println(" ");
      System.out.print("Product Type:");
      System.out.println(cUser.getType());
      System.out.print("Product Size:");
      System.out.println(cUser.getSize());
      System.out.print("Product Access Speed:");
      System.out.println(cUser.getAccess());
      System.out.print("Product Vendor:");
      System.out.println(cUser.getVendor());
      System.out.print("Product Average Sales:");
      System.out.println(prodSalesAvgIn);
      if (prodSalesAvgIn > 200.00){
          System.out.println("    This produc has produce a large amount of sales");
      }
      System.out.print("Product Shipping Charges:");
      System.out.println(prodShipIn);
      System.out.println(" ");

      // create and display output string
      outputMsg = thankyouMsg + prodIDout + prodNameout + prodPriceout + prodAvgSalesout + prodShipChrgout + endingmsg;
		JOptionPane.showMessageDialog(null, outputMsg);

System.exit(0);
      
      
    }
    
}