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
//Include the necessary files
//Class Files
#include "Exam.h"
//Library files
#include <cstdlib>
#include <cstring>
#include <string>
using namespace std;

//Function Signatures
string displayMenu();
string validateMenuSel(string sel);


//Start of the main section
int main(){
    //Declare working variables
    string validatedSel;
    string filename = "testbank.txt";   //Sets a default in case the user tries to display an exam before one is created
    Exam ex;
    //Main Process
    validatedSel = displayMenu();   //Display the menu and get the users selection
    while (validatedSel != "3"){        //If the selection is 3 quit
        if (validatedSel == "1"){       //If the selection is 1 then create a quiz file
            filename = ex.loadTestBank();       //Create a test bank file and load it with questions
        } else {
            cout << "\n" << endl;           //Sets some space between the menu and the displayed exam
            ex.displayTest(filename);          //Display the file created in option 1 or display the default file
        }
        validatedSel = displayMenu();       //Display the menu and get the users selection
    }
}//End Main
//The function displays the menu and validates the selection the user made
string displayMenu(){
    string menuSel;
    string validSel;
    cout << "\nwelcome to the Quiz-O-Matic\n" << endl;
    cout << "1. Load an exam " << endl;
    cout << "2. Display an exam " << endl;
    cout << "3. Quit " << endl;
    cout << "please enter your selection " << endl;
    cin >> menuSel;
    validSel = validateMenuSel(menuSel);        //Validate the users selection
    return validSel;
}//End displayMenu
//The function makes sure that the user entered a valid selection from the menu
string validateMenuSel(string sel){
    bool valid = false;
    while (valid == false){                             //This will continue to process until valid data is entered
        if (sel == "1" || sel == "2" || sel == "3"){
            valid = true;
        }else {
            valid = false;
            cout << "Selection is invalid. Please re-enter" << endl;
            cin >> sel;
        }//end else
    }//end while
    return sel;
}//End validateMenuSel
//
