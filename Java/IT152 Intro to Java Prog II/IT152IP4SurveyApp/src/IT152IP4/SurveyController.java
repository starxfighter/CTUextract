/**
 * Course: IT152 - Introduction to Java Programming II
 * Filename:SurveyController.java
 * Module: Controller Class
 * Created: 01/29/2016
 * Modified:01/29/2016
 * 
 * Purpose: This class will do the actual controlling of the survey. The controller class will call
 * the survey class to create the instance of the survey that is being conducted.
 * 
 */
package IT152IP4;

import javax.swing.JOptionPane;

/**
 *
 * @author Duane Osburn
 */
public class SurveyController {
    //Declare survey variable
    Survey newsurvey;
    //Declare Variables
    String respMsg, ansMsg, convAns, resultMsg, convResult, highMsg, lowMsg;
    String chORrevMsg, chORrevIN, reviewMsg, qchangeMsg, rchangeMsg;
    int AnsConv = 0;
    int ResultConv = 0;
    int maxUser = 10;
    int maxQues = 10;
    int temp = 0;
    int highestQues, anschange;
    int lowestQues, changeQues, changeResp;
    String flag = "y";
    //Create instance of the survey 
    public SurveyController(Survey survey){
        newsurvey = survey;
    }
    //This method conducts the survey
    public void conduct()
    {
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
                    temp = getValidNum(AnsConv);
                    newsurvey.logResponse(I, X, temp);
                } else {
                    X = 10;
                    I = 10;
                 }
            }
        // End Nested For
    }
    //This method will dispay the results of the survey once it has been completed
    public void DisplayResults()
    {
        //Ask user what they want to print or quit
        while (flag.equals("y")){
            resultMsg = "Enter question number to see that result or -1 to print all or q to quit";
            convResult = JOptionPane.showInputDialog(resultMsg);
            if (convResult.equals("q")){
                flag = "n";
            }else{
                ResultConv = Integer.parseInt(convResult);
                newsurvey.displaySurveyResults(ResultConv);
            }  
        }    
        //Determine the higest and lowest rated questions
        newsurvey.loadTally();
        highestQues = newsurvey.topRatedQuestion();
        highMsg = ("The highest rated question is: " + highestQues + ".\n");
        JOptionPane.showMessageDialog(null, highMsg);
        lowestQues = newsurvey.lowRatedQuestion();
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
            newsurvey.presentQuestion(ResultConv - 1);
        }else{
            if (chORrevIN.equals("c"))
            {
                qchangeMsg = "What question would you like to change?";
                convResult = JOptionPane.showInputDialog(qchangeMsg);
                changeQues = Integer.parseInt(convResult);
                rchangeMsg = "For what respondent are we changing the answer for";
                convResult = JOptionPane.showInputDialog(rchangeMsg);
                changeResp = Integer.parseInt(convResult);
                anschange = newsurvey.presentQuestion(changeQues -1 , changeResp + 1);
                newsurvey.logResponse(changeResp + 1, changeQues - 1, anschange);
                newsurvey.displaySurveyResults(changeQues -1);
            }else{
                flag = "n";
            }   
        } 
        }
    }
    //
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
    //
    private static int getValidNum(int prompt){
	String classFlag = "y";
        String errmsg;
	while (classFlag.equals("y")){
              if (prompt > 0 && prompt < 6){
                	System.out.println("valid response");
			classFlag = "n";
		}
		else{
			System.out.println("not a valid response");
			classFlag ="y";
                        errmsg = JOptionPane.showInputDialog("Valid response needs to be between 1 and 5:");
                        prompt = Integer.parseInt(errmsg);
		}
	}
	return prompt;
    }
}
