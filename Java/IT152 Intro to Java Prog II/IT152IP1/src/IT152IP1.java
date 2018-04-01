/**
 * Course:   IT152 - Introduction to Java Programming II
 * Filename: IT152IP1.java
 * Created:  01/08/16 by Duane Osburn
 * Modified: 01/08/16 by Duane Osburn
 * 
 * Purpose:  Created a simple program that will make use of a class called Survey that will have
 * two overloaded constructors as well as accept a survey title as input and also generate a
 * id number for each entry
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * @author Duane Osburn
 */
class Survey {
//Declare attributes
    private static int CurResID;  /* Static Variable for the Respondent ID*/
    private String SurTitle;     /* Instance Variable for the Survey Title*/
//Set Constructor    
    public Survey (){
        SurTitle = "Customer Survey";
    }    
    public Survey (String TitleSurv){
        SurTitle = TitleSurv;
    }
//Mutators -- None at this time
//Accessors
	public int generateRespondentID()
	{
		return CurResID++;
	}
	public String getSurveyTitle()
	{
		return SurTitle;
	}
	
}//end class Survey
//
public class IT152IP1 {

    /**
     * @param args the command line arguments
     */
    //Methods
    //Main
    public static void main(String[] args) {
        //Declared Variables
        int testid;
        int testid1;
        String userSurvey;
        //Call the first no argument constructor
        Survey survey1 = new Survey ();
        testid = survey1.generateRespondentID();
        System.out.println("The Survey Title = "+ survey1.getSurveyTitle());
        System.out.println("The Respondent ID = " + testid);
        //Call the second constructor that passes the survey title
        userSurvey = JOptionPane.showInputDialog("Please enter a customer survey title:\n");
        Survey survey2 = new Survey (userSurvey);
        testid1 = survey2.generateRespondentID();
        System.out.println("The Survey Title = "+ survey2.getSurveyTitle());
        System.out.println("The Respondent ID = " + testid1);
    
System.exit(0);
    }
}

