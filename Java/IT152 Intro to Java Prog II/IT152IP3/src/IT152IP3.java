/**
 * Course:   IT152 - Introduction to Java Programming II
 * Filename: IT152IP3.java
 * Created:  01/23/16 by Duane Osburn
 * Modified: 01/23/16 by Duane Osburn
 * 
 * Purpose:  Enhanced the simple program to make use of Arrays. One array will be used to store
 * the survey questions. The other array will be a two dimensional array that will store question responses
 * dependent on the respondent id and the question number.There are two print methods included. One will print
 * all responses by question and the other will only print the responses for a particular question.
 * The program will now also identify the top and lowest rated questions. It will also allow the changing of a 
 * response to a particular question for a particular respondent (overloaded methods)
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * @author Duane Osburn
 */
class Survey {
//Declare attributes
    private static int CurResID;  /* Static Variable for the Respondent ID*/
    private int highQ;            /* Temp value for higest rated question*/
    private int lowQ;             /* Temp value for lowest rated question*/ 
    private int holdQnum = 0;     /* Working variable to determine high/low question*/
    private int holdQvalue = 0;   /* Working variable to determine high/low question*/
    private String pqMsg, pq2Msg, convResult; /* presentQuestion method temp varibles*/
    private int newanswer = 0;    /* new answer from presentQuestion method */
    private String SurTitle;      /* Instance Variable for the Survey Title*/
    private int[][] answers;      /* multi-dimension array for the question and response*/
    private String[] questions;   /* array to hold the questions*/
    private int[] totQuest;       /* array to hold the total value of each question*/
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
                  System.out.println("   ");
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
//Load tally array
        public void loadTally()
        {
         totQuest = new int [max];
            for (int I = 0; I < 10; I++)   /*question loop*/
            {
                for (int J = 0; J < 10; J++)   /*response loop*/
                {
                    totQuest[I]+= answers[J][I];
                }
            }    
        }
//Method to find highest rated question
        public int topRatedQuestion()
        {
            for (int I = 0; I < 10; I++) /*Loop through added question values*/
            {
                if (holdQvalue < totQuest[I])
                {
                    holdQnum = I;
                    holdQvalue = totQuest[I];
                }
            }
            highQ = holdQnum + 1;
            return highQ;
        }
//Method to find the lowest rated question
        public int lowRatedQuestion()
        {
          for (int I = 0; I < 10; I++) /*Loop through added question values*/
            {
                if (holdQvalue > totQuest[I])
                {
                    holdQnum = I;
                    holdQvalue = totQuest[I];
                }
            }
            lowQ = holdQnum + 1;
            return lowQ;  
        }
//Method to present a question for review - one variable
        public void presentQuestion(int qNumber)
        {
           System.out.println("------------------------------------------");
           System.out.println("The question is: " + questions[qNumber]);  
           System.out.println("The responses are as follows");
           for(int I = 0; I < max; I++)
               System.out.println("The respondonet id:" + I + " The answer was " + answers[I][qNumber]); 
        }        
//Method to present a question based on the respondent id
        public int presentQuestion(int qNumber, int respId)
        {
            pqMsg = ("Respondent " + respId + " The question was:" + questions[qNumber - 1] + "\n");
            pq2Msg = ("The answer was " + answers[respId][qNumber - 1] + ". The new answer is?");
            convResult = JOptionPane.showInputDialog(pqMsg + pq2Msg);
            newanswer = Integer.parseInt(convResult);
            System.out.println("------------------------------------------");
            return newanswer;
        }
}
//end class Survey
//
public class IT152IP3 {

    /**
     * @param args the command line arguments
     */
    //Methods
    //getValidCResp: Makes sure the user enters one of the three valid respomses
    private static String getValidResp(String prompt){
		String classFlag = "y";
		while (classFlag.equals("y")){
                        if (prompt.equals("c") || prompt.equals("r") || prompt.equals("q")){
				System.out.println("valid response");
				classFlag = "n";
			}
			else{
				System.out.println("not a valid response");
				classFlag ="y";
                                prompt = JOptionPane.showInputDialog("Valid Formats are c or r:");
			}
		}
		return prompt;
    }
    //Main
    public static void main(String[] args) {
        //Declared Variables
        int testid;
        int testid1;
        int AnsConv = 0;
        int ResultConv = 0;
        int maxUser = 10;
        int maxQues = 10;
        int highestQues, anschange;
        int lowestQues, changeQues, changeResp;
        String flag = "y";
        String userSurvey, quesMsg, respMsg, ansMsg, convAns, resultMsg, convResult, highMsg, lowMsg;
        String chORrevMsg, chORrevIN, reviewMsg, qchangeMsg, rchangeMsg;
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
        //Determine the higest and lowest rated questions
        survey2.loadTally();
        highestQues = survey2.topRatedQuestion();
        highMsg = ("The highest rated question is: " + highestQues + ".\n");
        JOptionPane.showMessageDialog(null, highMsg);
        lowestQues = survey2.lowRatedQuestion();
        lowMsg = ("The lowest rated question is: " + lowestQues + ".\n");
        JOptionPane.showMessageDialog(null, lowMsg);
        //Present the question for review or change
        flag = "y";
        while (flag.equals("y")){
        chORrevMsg = JOptionPane.showInputDialog("Would you like to review or change a question (q to quit)? (enter r or c)");
        chORrevIN = getValidResp(chORrevMsg);
        if (chORrevIN.equals("r"))
        {
            reviewMsg = "What question would you like to review?";
            convResult = JOptionPane.showInputDialog(reviewMsg);
            ResultConv = Integer.parseInt(convResult);
            survey2.presentQuestion(ResultConv - 1);
        }else{
            if (chORrevIN.equals("c"))
            {
                qchangeMsg = "What question would you like to change?";
                convResult = JOptionPane.showInputDialog(qchangeMsg);
                changeQues = Integer.parseInt(convResult);
                rchangeMsg = "For what respondent are we changing the answer for";
                convResult = JOptionPane.showInputDialog(rchangeMsg);
                changeResp = Integer.parseInt(convResult);
                anschange = survey2.presentQuestion(changeQues -1 , changeResp + 1);
                survey2.logResponse(changeResp + 1, changeQues - 1, anschange);
                survey2.displaySurveyResults(changeQues -1);
            }else{
                flag = "n";
            }   
        } 
        }

//Exit Program   
System.exit(0);
    }
}

