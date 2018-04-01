//CS215-1603A-01
//Author: Duane Osburn
//Created Date: 07/17/2016
//Modified Date: 07/21/2016
//Description: This program will read in a file of questions. Load them into the correct class and then print them out.
//Modifications:
//07/21/2016 Added functionality to allow the user to enter questions and create their own test bank file
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
    //string fline;
    //string numOFques;
    //string quesType;
    //string pVal;
    string validatedSel;
    string filename = "testbank.txt";
    //Create instances of the child classes
    //QuestionIF tf;
    //QuestionMC mc;
    //Declare control variables
    //int nQues;
    //int cntl = 1;
    //int quesTnum = 0;
    validatedSel = displayMenu();
    while (validatedSel != "3"){
        if (validatedSel == "1"){
            filename = loadTestBank();
        } else {
            displayTest(filename);
        }
        validatedSel = displayMenu();
    }
    //Create instance of the question file
    //ifstream myfile("testbank.txt");
    //ifstream myfile(filename.c_str());
    //if (myfile.is_open()){                       //Continue processing as long as the file opened successfully
    //    getline(myfile, fline);                  //Read first line of the file
    //    numOFques = fline;
    //    nQues = atoi(numOFques.c_str());                 //convert numOfques from a string to an integer
    //    while (cntl < (nQues + 1)){                      //While we have questions to process
    //        getline(myfile, fline);
    //        quesType = fline.substr(0,2);       //Extract the type of question from the line
    //        pVal = fline.substr(3, 2);          //Extract the point value of the question from the line
    //        if (quesType == "TF"){              //Set values for switch statement dependent on question type
    //            quesTnum = 1;
    //        } else {
    //            if (quesType == "MC") {
    //                quesTnum = 2;
    //            }else {
    //                quesTnum = 0;               //IF the question type is invalid then set to zero for switch to handle error
     //           }
     //       }//end nested IF
    //        switch (quesTnum){
    //            case 1:                         //Process the true/false questions
    //                tf = processTF(myfile, pVal);
    //                printTF(tf,cntl);
    //                break;
    //            case 2:                         //Process the multiple choice questions
    //                mc = processMC(myfile, pVal);
    //                printMC(mc,cntl);
    //                break;
    //            default:                        //Notify user of error and exit the program
    //                cout << "Invalid type" << endl;
    //                cntl = 4;
    //                break;
    //        }//end switch
    //        cntl++;
    //    }//end while
    //    myfile.close();}                        //Close the file
    //else {
    //    cout << "can not open file" << endl;    //Display error message if file can not be opened
    //}//end If else
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
}
//
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
        }
        getline(myfile, fline);             //Get next line from the file
        temp.setAnswer(fline);              //Set the answer in the class file

        return temp;                        //Return populated QuestionMC class object
}
//Prints out the true/false question
void printTF(QuestionIF temp, int questNumber){
    cout << "Question #" << questNumber << "  " << temp.getQuestion() << endl;
    cout << "Point Value: " << temp.getValue() << endl;
    cout << "Answer Choice:" << endl;
    cout << "A : " << temp.printOptions(0) << endl;
    cout << "B : " << temp.printOptions(1) << endl;
    cout << "The answer is " << temp.getAnswer() << endl;
    cout << "\n";
}
//Prints out the multiple choice question
void printMC(QuestionMC temp, int questNumber){
    int x = 0;
    cout << "Question #" << questNumber << "  " << temp.getQuestion() << endl;
    cout << "Point Value: " << temp.getValue() << endl;
    cout << "Answer Choice:" << endl;
    while (x < 6 && (temp.printOptions(x) != " ")){ //While the max choices has not been reached and the option from the class is not spaces
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
//
string displayMenu(){
    string menuSel;
    string validSel;
    cout << "welcome to the Quiz-O-Matic\n" << endl;
    cout << "1. Load an exam " << endl;
    cout << "2. Display an exam " << endl;
    cout << "3. Quit " << endl;
    cout << "please enter your selection " << endl;
    cin >> menuSel;
    validSel = validateMenuSel(menuSel);
    return validSel;
}
//
string validateMenuSel(string sel){
    bool valid = false;
    while (valid == false){
        if (sel == "1" || sel == "2" || sel == "3"){
            valid = true;
        }else {
            valid = false;
            cout << "Selection is invalid. Please re-enter" << endl;
            cin >> sel;
        }
    }
    return sel;
}
//
string loadTestBank(){
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
    cin.ignore();
    cout << "What do you want the file to be called? " << endl;
    getline(cin, fileName);
    fName = fileName + ".txt";
    ofstream outfile(fName.c_str());
    if (outfile.is_open()){
        cout << "How many questions will be in the file? " << endl;
        cin >> nQuesFile;
        qNumFile = validateFileQuest(nQuesFile);
        outfile << qNumFile << endl;
        while (x < (qNumFile + 1)){
            cout << "What type of question will question #" << x << " be." << endl;
            cout << "TF = true/false. MC = multiple choice" << endl;
            cin >> typeIn;
            validType = validateQType(typeIn);
            cout << "How many points is the question worth?" << endl;
            cin >> pVal;
            validPoint = validatePVal(pVal);
            outfile << validType << " " << validPoint << endl;
            cin.ignore();
            cout << "What is the question for question #" << x << endl;
            getline(cin,questIn);
            validQuest = checkForInput(questIn);
            outfile << validQuest << endl;
            if (validType == "TF"){
                cout << "What is the answer? (True/False) " << endl;
                cin >> questAns;
                validAns = validateTFAns(questAns);
                outfile << validAns << endl;
            } else {
                cout << "Number of answer options?" << endl;
                cin >> qAnsOp;
                validAnsOp = validateAnsOpt(qAnsOp);
                outfile << validAnsOp << endl;
                cin.ignore();
                while (y < (validAnsOp + 1)){
                    cout << "what is the #" << y << " option." << endl;
                    getline(cin, ansOption);
                    validOPT = checkForInput(ansOption);
                    mcAnsOpts[y] = validOPT;
                    outfile << validOPT << endl;
                    y++;
                }
                cout << "What is the answer? (A,B,C,D,E,F) " << endl;
                cin >> questAns;
                validAns = validateMCAns(questAns, validAnsOp);
                outfile << validAns << endl;
            }

            x++;
        }
        outfile.close();
    }else {
        cout << "can not open output file" << endl;
    }
    return fName;
}
//
int validateFileQuest(string num){
    int qnum;
    bool valid = false;
    while (valid == false){
        qnum = atoi(num.c_str());
        if (qnum > 0 && qnum < 11){
            valid = true;
        } else {
            valid = false;
            cout << "The number of questions has to be more than zero and less than 11. Please re-enter" << endl;
            cin >> num;
        }
    }
    return qnum;
}
//
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
        }
    }
    return typeIn;
}
//
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
        }
    }
    return input;
}
//
string validateTFAns(string TFAns){
    bool valid = false;
    string valTFAns;
    cout << "in validateTF. TFAns" << TFAns << endl;
    valTFAns = checkForInput(TFAns);
    cout << "valid TF" << valTFAns << endl;
    while (valid == false) {
        if ((valTFAns == "True") || (valTFAns == "False")){
            valid = true;
        } else {
            valid = false;
            cout << "The answer can only be True or False." << endl;
            cin >> TFAns;
        }
    }
    return valTFAns;
}
//
int validateAnsOpt(string inAnsOp){
    bool valid = false;
    string valAnsOp;
    int validIn;
    valAnsOp = checkForInput(inAnsOp);
    while (valid == false){
        validIn = atoi(valAnsOp.c_str());
        if ((validIn > 0) && (validIn < 6)){
            valid = true;
        } else {
            valid = false;
            cout << "There has to be at least one option and less than 6. Please re-enter." << endl;
            cin >> inAnsOp;
        }
     }
     return validIn;
}
//
string validateMCAns(string questAns, int validAnsOp){
    bool valid = false;
    string MCAns;
    int ansCheck;
    cout << "in validate MC Ans. MCAns " << MCAns << endl;
    cout << "validAnsOP " << validAnsOp << endl;
    while (valid == false){
        MCAns = checkForInput(questAns);
        if ((MCAns == "A") || (MCAns == "B") || (MCAns == "C") ||
            (MCAns == "D") || (MCAns == "E") || (MCAns == "F")){
                valid = true;
        } else {
                valid = false;
                cout << "The answer has to be one of the following: A,B,C,D,E,F. Please re-enter." << endl;
                cin >> questAns;
        }
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
                                }
                            }
                        }
                    }
                }
            }
        }
        cout << "ansCheck " << ansCheck << endl;
        cout << "valid" << valid << endl;
        if (valid == true){
            if ((ansCheck <= validAnsOp)){
                valid = true;
            }else {
                valid = false;
                cout << "The answer is invalid because it is out side the answer options. Please re-enter" << endl;
                cin >> questAns;
            }

        }
    }
    return MCAns;
}
//
int validatePVal(string input){
    char stuff[3];
    int validPoint;
    string pointVal;
    bool valid = false;
    pointVal = checkForInput(input);
    strcpy(stuff, pointVal.c_str());
    while (valid == false){
            for (int i = 0; i < (strlen(stuff)); i++){
                if (isdigit(stuff[i])){
                    valid = true;
                }else {
                    valid = false;
                    break;
                }
            }
            if (valid == false){
                cout << "The point value must be numeric. Please re-enter." << endl;
                cin >> input;
            }
    }//end while
    validPoint = atoi(input.c_str());
    return validPoint;
}
//
void displayTest(string filename){
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
    //ifstream myfile("testbank.txt");
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
                }
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
}
