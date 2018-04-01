//CS215-1603A-01
//Author: Duane Osburn
//Program: QuestionIF class definition
//Created Date: 07/17/2016
//Modified Date: 07/17/2016
//Description: This class definition holds the classes functions
//Modifications:
//
//Include the necessary files
#include "QuestionIF.h" //This is the QuestionIF interface file
#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;
//Constructor
QuestionIF::QuestionIF()
{
    //ctor
}
QuestionIF::QuestionIF(string questIn, int pvalue, string ans):Question(questIn, pvalue)
{
    answer = ans;
}
//Deconstructor
QuestionIF::~QuestionIF()
{
    //dtor
}
//Sets answer
void QuestionIF::setAnswer(string ans){
    answer = ans;
}
//Retrieve answer
string QuestionIF::getAnswer() const{
    return answer;
}
//Set the answer choices
void QuestionIF::setOptions(int ndx, string value){
    options[ndx] = value;
}
//Retrieves the answer choices
string QuestionIF::printOptions(int ndx){
    string temp = options[ndx];
    return temp;
}
