//CS215-1603A-01
//Author: Duane Osburn
//Created Date: 07/17/2016
//Modified Date: 07/17/2016
//Description: This program will read in a file of questions. Load them into the correct class and then print them out.
//Modifications:
//
//Include the necessary files
//Class Files
#include "Question.h" //Question parent class file
#include "QuestionIF.h" //Child class file for IF questions
#include "QuestionMC.h" //Child class file for multiple choice questions
//Library files
#include <fstream>
#include <iostream>
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

//Start of the main section
int main(){
    //Declare working variables
    string fline;
    string numOFques;
    string quesType;
    string pVal;
    //Create instances of the child classes
    QuestionIF tf;
    QuestionMC mc;
    //Declare control variables
    int nQues;
    int cntl = 1;
    int quesTnum = 0;
    //Create instance of the question file
    ifstream myfile("testbank.txt");
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


