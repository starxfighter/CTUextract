/**
 * Course: IT152 - Introduction to Java Programming II
 * Filename:IT152IP4SurveyApp,java
 * Module: Application 
 * Created: 01/29/2016
 * Modified:01/29/2016
 * 
 * Purpose: This application will make use of delegation and call stacks in order to administer
 * a survey to the user. The application will call a controller class that will control the flow
 * of the processing. All of the methods from the previous individual projects are still included.
 * 
 */
package IT152IP4;

import javax.swing.JOptionPane;

/**
 *
 * @author Duane Osburn
 */
public class IT152IP4SurveyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare Variables
        int testid;
        int testid1;
        String userSurvey, quesMsg;
        //Call the first no argument constructor
        Survey survey1 = new Survey ();
        testid = survey1.generateRespondentID();
        System.out.println("The Survey Title = "+ survey1.getSurveyTitle());
        System.out.println("The Respondent ID = " + testid);
        //Call the second constructor that passes the survey title recieved from the user
        userSurvey = JOptionPane.showInputDialog("Please enter a customer survey title:\n");
        Survey survey2 = new Survey (userSurvey);
        testid1 = survey2.generateRespondentID();
        System.out.println("The Survey Title = "+ survey2.getSurveyTitle());
        System.out.println("The Respondent ID = " + testid1);
        //Have the user enter in the survey questions
        quesMsg = "Now we need to enter in some questions for the survey";
        JOptionPane.showMessageDialog(null, quesMsg);
        survey2.enterQuestions();
        //Create instance of the survey controller
        SurveyController controller = new SurveyController(survey2);
        //Call the controllers conduct method to conduct the survey
        controller.conduct();
        //Call the controllers display results method to display the results of the survey
        controller.DisplayResults();
    }
    
}
