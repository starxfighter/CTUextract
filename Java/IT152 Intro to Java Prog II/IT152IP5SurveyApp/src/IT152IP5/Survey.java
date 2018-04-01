/**
 * Course: IT152 - Introduction to Java Programming II
 * Filename:Survey.java
 * Module: Survey Class 
 * Created: 02/03/2016
 * Modified:02/03/2016
 * 
 * Purpose: This class is used to create an instance of the survey. It also contain the particular
 * methods that are particular to the survey such as the highest and lowest rated questions.
 * 
 */
package IT152IP5;

import javax.swing.JOptionPane;

/**
 *
 * @author Duane Osburn
 */
public class Survey {
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
    

