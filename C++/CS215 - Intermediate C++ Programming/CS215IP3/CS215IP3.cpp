//CS215-1603A-01
//Author: Duane Osburn
//Created Date: 07/17/2016
//Modified Date: 07/21/2016
//Description: This program will read in a file of questions. Load them into the correct class and then print them out.
//Modifications:
//07/21/2016 Added functionality to allow the user to enter questions and create their own test bank file. Also the addition of a menu where
//           options can be selected until the user quits the application
//
//Include the necessary files
//Class Files
#include "Question.h" //Question parent class file
#include "QuestionIF.h" //Child class file for IF questions
#include "QuestionMC.h" //Child class file for multiple choice questions
//Library files
#include <fstream>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <iomanip>
#include <cstring>
#include <string>
using namespace std;

//Function Signatures
QuestionIF processTF(ifstream& myfile, string pVal);
QuestionMC processMC(ifstream& myfile, string pVal);
void printTF(QuestionIF temp, int cntl);
void printMC(QuestionMC temp, int cntl);
string displayMenu();
string validateMenuSel(string sel);
string loadTestBank();
int validateFileQuest(string num);
string validateQType(string typeIn);
string checkForInput(string input);
string validateTFAns(string TFAns);
int validateAnsOpt(string inAnsOp);
string validateMCAns(string questAns, int validAnsOp);
int validatePVal(string input);
void displayTest(string filename);


//Start of the main section
int main(){
    //Declare working variables
    string validatedSel;
    string filename = "testbank.txt";
    //Main Process
    validatedSel = displayMenu();   //Display the menu and get the users selection
    while (validatedSel != "3"){        //If the selection is 3 quit
        if (validatedSel == "1"){       //If the selection is 1 then create a quiz file
            filename = loadTestBank();      //Load entries into the file and return the files name
        } else {
            displayTest(filename);          //Display the file created in option 1 or display the default file
        }
        validatedSel = displayMenu();       //Display the menu and get the users selection
    }
}//End Main
//The function will process the true/false type questions
QuestionIF processTF(ifstream& myfile, string pVal){
        //Create instance of true/false child class
        QuestionIF temp;
        //Declare working variables
        string fline;
        string value;
        int pointValue;
        int ndx;
        pointValue = atoi(pVal.c_str());    //Convert point value from a string to an integer
        temp.setValue(pointValue);          //Set the point value in the class file
        getline(myfile, fline);             //Get next line from the file
        temp.setQuestion(fline);            //Set the question in the class file
        getline(myfile, fline);             //Get next line from the file
        temp.setAnswer(fline);              //Set the answer in the class file
        ndx = 0;                            //Set the array index
        value = "True";                     //Set the option[0] value
        temp.setOptions(ndx, value);        //Set the question option in the class file
        ndx = 1;                            //Set the array index
        value = "False";                    //Set the option[1] value
        temp.setOptions(ndx, value);        //Set the question option in the class file

        return temp;                        //Return populated QuestionIF class object
}//End processTF
//The function will process the multiple choice questions
QuestionMC processMC(ifstream& myfile, string pVal){
        //Create instance of multiple choice child class
        QuestionMC temp;
        //Declare working variables
        string fline;
        string numOfOpts;
        string value;
        int pointValue;
        int optNumber;
        int x = 0;
        pointValue = atoi(pVal.c_str());    //Convert point value from a string to an integer
        temp.setValue(pointValue);          //Set the point value in the class file
        getline(myfile, fline);             //Get next line from the file
        temp.setQuestion(fline);            //Set the question in the class file
        getline(myfile, fline);             //Get next line from the file
        numOfOpts = fline;                  //Get the number of answer choices
        optNumber = atoi(numOfOpts.c_str()); //Convert the number of answer choices from a string to an integer
        while (x < optNumber){              //Process until the number of answer choices has been reached
           getline(myfile, fline);          //Get the answer choice
           value = fline;
           temp.setOptions(x, value);       //Set the answer choice in the class file
           x++;
        }//End while
        getline(myfile, fline);             //Get next line from the file
        temp.setAnswer(fline);              //Set the answer in the class file

        return temp;                        //Return populated QuestionMC class object
}//End processMC
//Prints out the true/false question
void printTF(QuestionIF temp, int questNumber){
    cout << "Question #" << questNumber << "  " << temp.getQuestion() << endl;
    cout << "Point Value: " << temp.getValue() << endl;
    cout << "Answer Choice:" << endl;
    cout << "A : " << temp.printOptions(0) << endl;
    cout << "B : " << temp.printOptions(1) << endl;
    cout << "The answer is " << temp.getAnswer() << endl;
    cout << "\n";
}//end printTF
//Prints out the multiple choice question
void printMC(QuestionMC temp, int questNumber){
    int x = 0;
    cout << "Question #" << questNumber << "  " << temp.getQuestion() << endl;
    cout << "Point Value: " << temp.getValue() << endl;
    cout << "Answer Choice:" << endl;
    while (x < 6 && !(temp.printOptions(x).empty())){   //While the max choices has not been reached and the option from the class is not empty
            switch (x){                         //Determine and print letter choice for answer
                case 0:
                    cout << "A.";
                    break;
                case 1:
                    cout << "B.";
                    break;
                case 2:
                    cout << "C.";
                    break;
                case 3:
                    cout << "D.";
                    break;
                case 4:
                    cout << "E.";
                    break;
                case 5:
                    cout << "F.";
                    break;
                default:
                    cout << "Invalid answer" << endl;
                    break;
            }//end switch
            cout << temp.printOptions(x) << endl;           //Print out answer choice
            x++;
    }//end while
    cout << "The answer is " << temp.getAnswer() << endl;   //Print out question answer
    cout << "\n";
}//end printMC
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
//This function will create and populate the quiz file
string loadTestBank(){
    //Declare working variables
    string nQuesFile;
    string fileName;
    string fName;
    string validType;
    string questIn;
    string validQuest;
    string questAns;
    string validAns;
    string qAnsOp;
    string ansOption;
    string validOPT;
    string pVal;
    string mcAnsOpts[6];
    int validAnsOp;
    int validPoint;
    int qNumFile;
    int x = 1;
    int y = 1;
    string typeIn;
    //Start of process
    cin.ignore();
    cout << "What do you want the file to be called? " << endl;
    getline(cin, fileName);                                     //Gets name of the new quiz file
    fName = fileName + ".txt";                              //Appends file extension to filename
    ofstream outfile(fName.c_str());                        //Creates an instance of the output file
    if (outfile.is_open()){                                 //As long as the file was opened successfully then populate it
        cout << "How many questions will be in the file? " << endl;
        cin >> nQuesFile;                                   //Determine the number of questions to be placed in the file
        qNumFile = validateFileQuest(nQuesFile);
        outfile << qNumFile << endl;                        //Write to file
        while (x < (qNumFile + 1)){                         //Process until all of the questions have been entered
            cout << "What type of question will question #" << x << " be." << endl;
            cout << "TF = true/false. MC = multiple choice" << endl;
            cin >> typeIn;                                  //Determine type of question TF or MC
            validType = validateQType(typeIn);
            cout << "How many points is the question worth?" << endl;
            cin >> pVal;                                    //Determine how many points the question is worth
            validPoint = validatePVal(pVal);
            outfile << validType << " " << validPoint << endl;  //Write to file
            cin.ignore();
            cout << "What is the question for question #" << x << endl;
            getline(cin,questIn);                           //Determine what the question is
            validQuest = checkForInput(questIn);
            outfile << validQuest << endl;                  //Write to file
            if (validType == "TF"){                         //Split flow dependent on question type
                cout << "What is the answer? (True/False) " << endl;
                cin >> questAns;                            //Get answer
                validAns = validateTFAns(questAns);
                outfile << validAns << endl;                //Write to file
            } else {
                cout << "Number of answer options?" << endl;
                cin >> qAnsOp;                              //Determine the number of answer choices
                validAnsOp = validateAnsOpt(qAnsOp);
                outfile << validAnsOp << endl;              //Write to file
                cin.ignore();
                while (y < (validAnsOp + 1)){               //Process the number of answer choices
                    cout << "what is the #" << y << " option." << endl;
                    getline(cin, ansOption);                //Determine the answer choice
                    validOPT = checkForInput(ansOption);
                    mcAnsOpts[y] = validOPT;
                    outfile << validOPT << endl;            //Write to file
                    y++;
                }//End While
                cout << "What is the answer? (A,B,C,D,E,F) " << endl;
                cin >> questAns;                            //Determine the answer
                validAns = validateMCAns(questAns, validAnsOp);
                outfile << validAns << endl;                //Write to file
            }//End Else

            x++;
        }//End While
        outfile.close();                                    //Close file
    }else {
        cout << "can not open output file" << endl;         //Display error message if file was not opened successfully
    }//End IF Else
    return fName;
}//End loadTestBank
//Function to validate the number of questions in the file
int validateFileQuest(string num){
    //Declare working variables
    int qnum;
    bool valid = false;
    while (valid == false){
        qnum = atoi(num.c_str());               //Convert string to integer
        if (qnum > 0 && qnum < 11){             //Makes sure the quiz file will not have more than 10 questions
            valid = true;
        } else {
            valid = false;
            cout << "The number of questions has to be more than zero and less than 11. Please re-enter" << endl;
            cin >> num;
        }//end else
    }//end while
    return qnum;
}//end validateFileQuest
//This function will make sure that the type of question is valid. The only choices are TF or MC
string validateQType(string typeIn){
    bool valid = false;
    typeIn = checkForInput(typeIn);
    while (valid == false) {
        if ((typeIn == "TF") || (typeIn == "MC")){
            valid = true;
        } else {
            valid = false;
            cout << "The question can only TF or MC. Please re-enter question type." << endl;
            cin >> typeIn;
        }//end else
    }//end while
    return typeIn;
}//end validateQType
//This function will check and make sure that something has been entered by the user
string checkForInput(string input){
    bool valid = false;
    int inputLen;
    while (valid == false){
        inputLen = input.length();
        if (inputLen > 0){
            valid = true;
        } else {
            cout << "Nothing entered. Please re-enter." << endl;
            cin >> input;
        }//end else
    }//end while
    return input;
}//end checkForInput
//This function will validate that the answer for the TF question is valid. Only options are True or False
string validateTFAns(string TFAns){
    bool valid = false;
    string valTFAns;
    valTFAns = checkForInput(TFAns);
    while (valid == false) {
        if ((valTFAns == "True") || (valTFAns == "False")){
            valid = true;
        } else {
            valid = false;
            cout << "The answer can only be True or False." << endl;
            cin >> TFAns;
            valTFAns = checkForInput(TFAns);
        }//end else
    }//end while
    return valTFAns;
}//end validateTFAns
//This function will make sure that a multiple choice question has at least one answer but no more than 6
int validateAnsOpt(string inAnsOp){
    bool valid = false;
    string valAnsOp;
    int validIn;
    valAnsOp = checkForInput(inAnsOp);
    while (valid == false){
        validIn = atoi(valAnsOp.c_str());           //convert string to integer
        if ((validIn > 0) && (validIn < 6)){
            valid = true;
        } else {
            valid = false;
            cout << "There has to be at least one option and less than 6. Please re-enter." << endl;
            cin >> inAnsOp;
        }//end else
     }//end while
     return validIn;
}//end validateAnsOpt
//This function will make sure the answer to the multiple choice question is in the appropriate range
string validateMCAns(string questAns, int validAnsOp){
    bool valid = false;
    string MCAns;
    int ansCheck;
    while (valid == false){
        MCAns = checkForInput(questAns);
        if ((MCAns == "A") || (MCAns == "B") || (MCAns == "C") ||
            (MCAns == "D") || (MCAns == "E") || (MCAns == "F")){
                valid = true;
        } else {
                valid = false;
                cout << "The answer has to be one of the following: A,B,C,D,E,F. Please re-enter." << endl;
                cin >> questAns;
        }//end else
        if (valid == true){
            if (MCAns == "A"){
                ansCheck = 1;
            }else {
                if (MCAns == "B"){
                    ansCheck = 2;
                } else {
                    if (MCAns == "C"){
                        ansCheck = 3;
                    } else {
                        if (MCAns == "D") {
                            ansCheck = 4;
                        }else {
                            if (MCAns == "E"){
                                ansCheck = 5;
                            } else {
                                if (MCAns == "F"){
                                    ansCheck = 6;
                                }//end if
                            }//end else
                        }//end else
                    }//end else
                }//end else
            }//end else
        }//end if
        if (valid == true){
            if ((ansCheck <= validAnsOp)){              //Makes sure that the answer entered is not outside the number of answer options
                valid = true;
            }else {
                valid = false;
                cout << "The answer is invalid because it is out side the answer options. Please re-enter" << endl;
                cin >> questAns;
            }//end else
        }//end if
    }//end while
    return MCAns;
}//end validateMCAns
//This function will validate the point value and make sure it is a positive integer
int validatePVal(string input){
    char stuff[3];          //temp holder
    int validPoint;
    string pointVal;
    bool valid = false;
    pointVal = checkForInput(input);
    while (valid == false){
            strcpy(stuff, pointVal.c_str());        //copy the string to character array
            for (int i = 0; i < (strlen(stuff)); i++){      //got through each digit and make sure that its numeric
                if (isdigit(stuff[i])){
                    valid = true;
                }else {
                    valid = false;
                    //break;
                }//end else
            }//end for
            if (valid == false){
                cout << "The point value must be numeric. Please re-enter." << endl;
                cin >> input;
                pointVal = checkForInput(input);
            }//end if
    }//end while
    validPoint = atoi(input.c_str());
    return validPoint;
}//end validatePVal
//This function will display the quiz file and is option 2 on the menu
void displayTest(string filename){
    //Declare working variables
    string fline;
    string numOFques;
    string quesType;
    string pVal;
    int nQues;
    int cntl = 1;
    int quesTnum = 0;
    //Create instances of the child classes
    QuestionIF tf;
    QuestionMC mc;
    //Create instance of the question file
    ifstream myfile(filename.c_str());
    if (myfile.is_open()){                       //Continue processing as long as the file opened successfully
        getline(myfile, fline);                  //Read first line of the file
        numOFques = fline;
        nQues = atoi(numOFques.c_str());                 //convert numOfques from a string to an integer
        while (cntl < (nQues + 1)){                      //While we have questions to process
            getline(myfile, fline);
            quesType = fline.substr(0,2);       //Extract the type of question from the line
            pVal = fline.substr(3, 2);          //Extract the point value of the question from the line
            if (quesType == "TF"){              //Set values for switch statement dependent on question type
                quesTnum = 1;
            } else {
                if (quesType == "MC") {
                    quesTnum = 2;
                }else {
                    quesTnum = 0;               //IF the question type is invalid then set to zero for switch to handle error
                }//end else
            }//end nested IF
            switch (quesTnum){
                case 1:                         //Process the true/false questions
                    tf = processTF(myfile, pVal);
                    printTF(tf,cntl);
                    break;
                case 2:                         //Process the multiple choice questions
                    mc = processMC(myfile, pVal);
                    printMC(mc,cntl);
                    break;
                default:                        //Notify user of error and exit the program
                    cout << "Invalid type" << endl;
                    cntl = 4;
                    break;
            }//end switch
            cntl++;
        }//end while
        myfile.close();}                        //Close the file
    else {
        cout << "can not open file" << endl;    //Display error message if file can not be opened
    }//end If else
}//end displayTest
