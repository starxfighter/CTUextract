/**
 * Course:   IT152 - Introduction to Java Programming II
 * Filename: IT152IP2.java
 * Created:  01/16/16 by Duane Osburn
 * Modified: 01/16/16 by Duane Osburn
 * 
 * Purpose:  Enhanced the simple program to make use of Arrays. One array will be used to store
 * the survey questions. The other array will be a two dimensional array that will store question responses
 * dependent on the respondent id and the question number.There are two print methods included. One will print
 * all responses by question and the other will only print the responses for a particular question
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * @author Duane Osburn
 */
class Survey {
//Declare attributes
    private static int CurResID;  /* Static Variable for the Respondent ID*/
    private String SurTitle;      /* Instance Variable for the Survey Title*/
    private int[][] answers;      /* multi-dimension array for the question and response*/
    private String[] questions;   /* array to hold the questions*/
    private final int max = 10;   /* Maximum number of entries*/
//Set Constructor    
    public Survey (){       /* Initialize class and arraies*/
        SurTitle = "Customer Survey";
        answers = new int[max][max];
        questions = new String[max];
    }    
    public Survey (String TitleSurv){  /*Populate the class and arraies*/
        SurTitle = TitleSurv;
        answers = new int[max][max];
        questions = new String[max];
    }
//Mutators -- None at this time
//Accessors and methods
	public int generateRespondentID()
	{
		return CurResID++;
	}
	public String getSurveyTitle()
	{
		return SurTitle;
	}
//Method to allow the user to enter the survey questions
        public void enterQuestions()
        {        
                for (int I = 0; I < max; I++)
                {
                    questions[I] = JOptionPane.showInputDialog("Please enter question #" + (I+1) + "\n");
                }    
        }
//Method to log the responses from the user into the array
        public void logResponse(int userID, int qNumber, int response)
        {
                answers[userID][qNumber] = response;
        }     
//Method to print out the results of the survey. Either print all responses or just one question
        public void displaySurveyResults(int qNumber)
        {
            if (qNumber < 0)
              {  /* print all respondents*/
              System.out.println("The title of the survey is: " + SurTitle);
              System.out.println("------------------------------------------");
              for (int Q = 0; Q < max; Q++)
              {
                  System.out.println("   ");
                  System.out.println("The question is: " + questions[Q]);
                  System.out.println("The responses are as follows");
                  System.out.println("Response ID | Answer to the question");
                  System.out.println("            |  1 |   2 |   3 |   4 |   5 |   6 |   7 |   8 |   9 |  10 |");
                  System.out.println("------------------------------------------------------------------------");
                  for (int U = 0; U < max; U++)
                  {    
                      System.out.println("    ");
                      System.out.print(U + "           |");
                      for (int I = 0; I < max; I++)
                          System.out.print("  " + answers[U][I] + " | ");
                          //System.out.println(U + "           |      " + answers[U][I]);
                      System.out.println("   ");    
                  }        
              }   
           }else
              {/* print only one question*/
                 displayQuestionStats(qNumber);  
              }       
        }
//Method to print out the responses for one particular question
        public void displayQuestionStats(int qNumber)
        {
            System.out.println("------------------------------------------");
            System.out.println("The question is: " + questions[qNumber]);  
            System.out.println("The responses are as follows");
            for(int I = 0; I < max; I++)
                System.out.println("The respondonet id:" + I + " The answer was " + answers[I][qNumber]);
        }
                    
}
//end class Survey
//
public class IT152IP2 {

    /**
     * @param args the command line arguments
     */
    //Methods
    //Main
    public static void main(String[] args) {
        //Declared Variables
        int testid;
        int testid1;
        int AnsConv = 0;
        int ResultConv = 0;
        int maxUser = 10;
        int maxQues = 10;
        String flag = "y";
        String userSurvey, quesMsg, respMsg, ansMsg, convAns, resultMsg, convResult;
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
        //Log user responses to the survey questions
        respMsg="Now we need to enter in some responses";
        JOptionPane.showMessageDialog(null, respMsg);
        //Beginning of nested for loop
        for(int I = 0; I < maxUser; I++)
            for (int X = 0; X < maxQues; X++)
            {    
            ansMsg = ("Enter in the answer for respondent " + I + " to question " + (X+1) + "(type q to end):\n"); 
            convAns = JOptionPane.showInputDialog(ansMsg);
                if (!convAns.equals("q")) {
                    AnsConv = Integer.parseInt(convAns);
                    survey2.logResponse(I, X, AnsConv);
                } else {
                    X = 10;
                    I = 10;
                 }
            
            }
        // End Nested For
        //Ask user what they want to print or quit
        while (flag.equals("y")){
            resultMsg = "Enter question number to see that result or -1 to print all or q to quit";
            convResult = JOptionPane.showInputDialog(resultMsg);
            if (convResult.equals("q")){
                flag = "n";
            }else{
                ResultConv = Integer.parseInt(convResult);
                survey2.displaySurveyResults(ResultConv);
            }  
        }    
   
System.exit(0);
    }
}

