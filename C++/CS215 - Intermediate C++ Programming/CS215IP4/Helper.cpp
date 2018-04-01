//CS215-1603A-01
//Author: Duane Osburn
//Program: Helper class definition
//Created Date: 07/29/2016
//Modified Date: 07/29/2016
//Description: This class definition holds the classes functions.In this case these are all user validation functions.
//Modifications:
//
//Include the necessary files
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

Helper::Helper()
{
    //ctor
}

Helper::~Helper()
{
    //dtor
}
//
//Function to validate the number of questions in the file
int Helper::validateFileQuest(string num){
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
string Helper::validateQType(string typeIn){
    bool valid = false;
    Helper h1;
    typeIn = h1.checkForInput(typeIn);      //recursive call
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
//This function will validate the point value and make sure it is a positive integer
int Helper::validatePVal(string input){
    char stuff[3];          //temp holder
    int validPoint;
    string pointVal;
    bool valid = false;
    Helper h1;
    pointVal = h1.checkForInput(input);             //recursive call
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
                pointVal = h1.checkForInput(input);     //recursive call
            }//end if
    }//end while
    validPoint = atoi(input.c_str());
    return validPoint;
}//end validatePVal
//This function will check and make sure that something has been entered by the user
string Helper::checkForInput(string input){
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
string Helper::validateTFAns(string TFAns){
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
int Helper::validateAnsOpt(string inAnsOp){
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
            valAnsOp = checkForInput(inAnsOp);
        }//end else
     }//end while
     return validIn;
}//end validateAnsOpt
//This function will make sure the answer to the multiple choice question is in the appropriate range
string Helper::validateMCAns(string questAns, int validAnsOp){
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
