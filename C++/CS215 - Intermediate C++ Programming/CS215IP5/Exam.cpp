//CS215-1603A-01
//Author: Duane Osburn
//Program: Exam class definition
//Created Date: 07/29/2016
//Modified Date: 07/29/2016
//Description: This class definition holds the classes functions which is to either load an exam or display an exam
//Modifications:
//08/03/2016    Added new variables and the corresponding setters and getters. Change the displayTest function to allow
//              taking of the exam.
//
//Include the necessary files
#include "Exam.h"
#include "Helper.h"
//Library files
#include <fstream>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <iomanip>
#include <cstring>
#include <string>
using namespace std;
//Constructor
Exam::Exam()
{
    //ctor
}
//Deconstructor
Exam::~Exam()
{
    //dtor
}
//
//Sets file name
void Exam::setFileName(string file){
        fileName = file;
}
//
//Holds the questions that make up the exam. Keyed on array index.
void Exam::setQuestions(string quest, int ndx){
    missQuest[ndx] = quest;
}
//Holds the points available for each of the questions. Keyed on array index.
void Exam::setQuestionPoints(int pvalue, int ndx){
    questPoint[ndx] = pvalue;
}
//Holds whether or not the user got the question right or wrong. Keyed on array index.
void Exam::setPassFail(int PFVal, int ndx){
    passFail[ndx] = PFVal;
}
//Holds how the number of questions that make up the exam
void Exam::setNumQuest(int num){
    numOfQuest = num;
}
//Retrieves the exam question
string Exam::getQuestions(int ndx){
    return missQuest[ndx];
}
//Retrieves the point value for the question
int Exam::getQuestionPoints(int ndx){
    return questPoint[ndx];
}
//Retrieves whether or not the user got it right
int Exam::getPassFail(int ndx){
    return passFail[ndx];
}
//Retrieves the number of questions that make up the exam
int Exam::getNumQuest(){
    return numOfQuest;
}
//Retrieve the file name
string Exam::getFileName() const{
    return fileName;
}
//The function will create and load the exam file. This is option 1 on the menu.
string Exam::loadTestBank(){
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
    Helper h;               //Create instance of the helper class
    //Start of process
    cin.ignore();
    cout << "What do you want the file to be called? " << endl;
    getline(cin, fileName);                                     //Gets name of the new quiz file
    fName = fileName + ".txt";                              //Appends file extension to filename
    ofstream outfile(fName.c_str());                        //Creates an instance of the output file
    if (outfile.is_open()){                                 //As long as the file was opened successfully then populate it
        cout << "How many questions will be in the file? " << endl;
        cin >> nQuesFile;                                   //Determine the number of questions to be placed in the file
        qNumFile = h.validateFileQuest(nQuesFile);
        outfile << qNumFile << endl;                        //Write to file
        while (x < (qNumFile + 1)){                         //Process until all of the questions have been entered
            cout << "What type of question will question #" << x << " be." << endl;
            cout << "TF = true/false. MC = multiple choice" << endl;
            cin >> typeIn;                                  //Determine type of question TF or MC
            validType = h.validateQType(typeIn);
            cout << "How many points is the question worth?" << endl;
            cin >> pVal;                                    //Determine how many points the question is worth
            validPoint = h.validatePVal(pVal);
            outfile << validType << " " << validPoint << endl;  //Write to file
            cin.ignore();
            cout << "What is the question for question #" << x << endl;
            getline(cin,questIn);                           //Determine what the question is
            validQuest = h.checkForInput(questIn);
            outfile << validQuest << endl;                  //Write to file
            if (validType == "TF"){                         //Split flow dependent on question type
                cout << "What is the answer? (True/False) " << endl;
                cin >> questAns;                            //Get answer
                validAns = h.validateTFAns(questAns);
                outfile << validAns << endl;                //Write to file
            } else {
                cout << "Number of answer options?" << endl;
                cin >> qAnsOp;                              //Determine the number of answer choices
                validAnsOp = h.validateAnsOpt(qAnsOp);
                outfile << validAnsOp << endl;              //Write to file
                cin.ignore();
                y = 1;
                while (y < (validAnsOp + 1)){               //Process the number of answer choices
                    cout << "what is the #" << y << " option." << endl;
                    getline(cin, ansOption);                //Determine the answer choice
                    validOPT = h.checkForInput(ansOption);
                    mcAnsOpts[y] = validOPT;
                    outfile << validOPT << endl;            //Write to file
                    y++;
                }//End While
                cout << "What is the answer? (A,B,C,D,E,F) " << endl;
                cin >> questAns;                            //Determine the answer
                validAns = h.validateMCAns(questAns, validAnsOp);
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
//This function will display the quiz and allow the user to answer the questions. This option 2 on the menu.
void Exam::displayTest(string filename){
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
        setNumQuest(nQues);
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
//The function will process the true/false type questions
QuestionIF Exam::processTF(ifstream& myfile, string pVal){
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
QuestionMC Exam::processMC(ifstream& myfile, string pVal){
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
        temp.setAnsOpt(optNumber);
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
void Exam::printTF(QuestionIF temp, int questNumber){
    string ans;
    string validAns;
    string compAns;
    Helper h;
    //Display the question and its answer options
    cout << "Question #" << questNumber << "  " << temp.getQuestion() << endl;
    cout << "Point Value: " << temp.getValue() << endl;
    cout << "Answer Choice:" << endl;
    cout << temp.printOptions(0) << endl;
    cout << temp.printOptions(1) << endl;
    cout << "What is your answer? " << endl;        //Ask use for the answer
    cin >> ans;
    validAns = h.validateTFAns(ans);            //Validates if the users answer is a valid choice of options
    compAns = temp.getAnswer();
    if (validAns == compAns){                   //If the user got the answer right
        cout << "Great Job1!" << endl;
        setQuestions(temp.getQuestion(), (questNumber - 1));        //load the question into the exam array
        setQuestionPoints(temp.getValue(), (questNumber - 1));      //load the points into the exam array
        setPassFail(1, (questNumber - 1));                          //load the P/F into the exam array
    } else {
        cout << "Sorry. Better luck next time!" << endl;
        cout << "The answer is " << temp.getAnswer() << endl;
        setQuestions(temp.getQuestion(), (questNumber - 1));        //load the question into the exam array
        setQuestionPoints(temp.getValue(), (questNumber - 1));      //load the points into the exam array
        setPassFail(0, (questNumber - 1));                          //load the P/F into the exam array
    }
    cout << "\n";
}//end printTF
//Prints out the multiple choice question
void Exam::printMC(QuestionMC temp, int questNumber){
    int x = 0;
    string ans;
    string validAns;
    string compAns;
    Helper h;
    //Display the question and its answer options
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
    cout << "What is your answer? " << endl;                //Ask use for the answer
    cin >> ans;
    validAns = h.validateMCAns(ans,temp.getAnsOpt());       //Validates if the users answer is a valid choice of options
    compAns = temp.getAnswer();
    if (validAns == compAns){                               //If the user got the answer right
        cout << "Great Job1!" << endl;
        setQuestions(temp.getQuestion(), (questNumber - 1));    //load the question into the exam array
        setQuestionPoints(temp.getValue(), (questNumber - 1));  //load the points into the exam array
        setPassFail(1, (questNumber - 1));                      //load the P/F into the exam array
    } else {
        cout << "Sorry. Better luck next time!" << endl;
        cout << "The answer is " << temp.getAnswer() << endl;   //Print out question answer
        setQuestions(temp.getQuestion(), (questNumber - 1));    //load the question into the exam array
        setQuestionPoints(temp.getValue(), (questNumber - 1));  //load the points into the exam array
        setPassFail(0, (questNumber - 1));                      //load the P/F into the exam array
    }
    cout << "\n";
}//end printMC

