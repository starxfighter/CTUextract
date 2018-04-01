//CS215-1603A-01
//Author: Duane Osburn
//Created Date: 07/17/2016
//Modified Date: 07/21/2016
//Description: This program will read in a file of questions. Load them into the correct class and then print them out.
//Modifications:
//07/21/2016 Added functionality to allow the user to enter questions and create their own test bank file. Also the addition of a menu where
//           options can be selected until the user quits the application
//07/29/2016 Added an Exam class and a helper class. All of the processing of the exam and its questions have been moved to class files. The main
//           application just calls the exam class to either load the exam file or display the exam file.
//08/03/2016 Added new functionality to the program. Option 2 will now allow the user to take a test that has been loaded. The new option 3 will
//           show the users results from taking the test.
//Include the necessary files
//Class Files
#include "Exam.h"
//Library files
#include <cstdlib>
#include <cstring>
#include <string>
using namespace std;

//Function Signatures
int displayMenu();
int validateMenuSel(string sel);


//Start of the main section
int main(){
    //Declare working variables
    int validatedSel;
    int z = 0;
    string drQuest;
    int drPoints;
    int drPF;
    double examTotPoints = 0.0;
    double pointsRvcd = 0.0;
    float avg = 0.0;
    string filename = "testbank.txt";   //Sets a default in case the user tries to display an exam before one is created
    Exam ex;
    //Main Process
    validatedSel = displayMenu();   //Display the menu and get the users selection
    while (validatedSel != 4){        //If the selection is 4 quit
        switch (validatedSel){
                case 1:                         //Process the true/false questions
                    filename = ex.loadTestBank();
                    break;
                case 2:                         //Process the multiple choice questions
                    cout << "\n" << endl;           //Sets some space between the menu and the displayed exam
                    ex.displayTest(filename);
                    break;
                case 3:                         //Display the results from taking the test
                    cout <<" The questions that you got wrong are as follows: " << endl;
                    while (z < (ex.getNumQuest())){                 //While there are questions to process
                        drQuest = ex.getQuestions(z);               //Get the question
                        drPoints = ex.getQuestionPoints(z);         //Get the points the question is worth
                        drPF = ex.getPassFail(z);                   //Get the value that shows if they got the question right or wrong. 1=Right 0=Wrong
                        examTotPoints = examTotPoints + drPoints;   //Add up the total number of points in the exam
                        if (drPF == 1){
                            pointsRvcd = pointsRvcd + drPoints;     //Add up the points where they got the question right
                        } else {
                            cout << drQuest << endl;                //Display the question they got wrong
                        }
                        z++;
                    }
                     cout << "\nThe total number of possible exam points is: " << examTotPoints << endl;
                     cout << "The total number of points that you received is: " << pointsRvcd << endl;
                     avg = ((pointsRvcd / examTotPoints) * 100);        //Calculate the average
                     cout << "Your average is " << avg << "%" << endl;
                    break;
                default:                        //Notify user of error and exit the program
                    cout << "Invalid menu selection" << endl;
                    break;
            }//end switch
        validatedSel = displayMenu();       //Display the menu and get the users selection
    }//end while
    cout << "\n Thank you for using the Quiz-O-Matic" << endl;
}//End Main
//The function displays the menu and validates the selection the user made
int displayMenu(){
    string menuSel;
    int validSel;
    cout << "\nwelcome to the Quiz-O-Matic\n" << endl;
    cout << "1. Load an exam " << endl;
    cout << "2. Take an exam " << endl;
    cout << "3. Show exam results" << endl;
    cout << "4. Quit " << endl;
    cout << "please enter your selection " << endl;
    cin >> menuSel;
    validSel = validateMenuSel(menuSel);        //Validate the users selection
    return validSel;
}//End displayMenu
//The function makes sure that the user entered a valid selection from the menu
int validateMenuSel(string sel){
    bool valid = false;
    int vSel;
    while (valid == false){                             //This will continue to process until valid data is entered
        if (sel == "1" || sel == "2" || sel == "3" || sel == "4"){
            valid = true;
            vSel = atoi(sel.c_str());
        }else {
            valid = false;
            cout << "Selection is invalid. Please re-enter" << endl;
            cin >> sel;
        }//end else
    }//end while
    return vSel;
}//End validateMenuSel
//
