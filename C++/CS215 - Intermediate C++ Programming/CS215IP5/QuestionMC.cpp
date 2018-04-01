//CS215-1603A-01
//Author: Duane Osburn
//Program: QuestionMC class definition
//Created Date: 07/17/2016
//Modified Date: 07/17/2016
//Description: This class definition holds the classes functions
//Modifications:
//08/03/2016 Added variable answerOptions to hold the number of answer options for the question. Added corresponding
//           setters and getters.
//
//Include the necessary files
#include "QuestionMC.h" //This is the QuestionMC interface file
#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;
//Constructor
QuestionMC::QuestionMC()
{
    //ctor
}
QuestionMC::QuestionMC(string questIn, int pvalue, string ans):Question(questIn, pvalue)
{
    answer = ans;
}

QuestionMC::~QuestionMC()
{
    //dtor
}
//Sets answer
void QuestionMC::setAnswer(string ans){
    answer = ans;
}
//Set answer choices
void QuestionMC::setOptions(int ndx, string value){
    options[ndx] = value;
}
//Set the number of answer options
void QuestionMC::setAnsOpt(int ansOpt){
    answerOptions = ansOpt;
}
//Retrieve answer
string QuestionMC::getAnswer() const{
    return answer;
}
//Retrieve the number of answer options
int QuestionMC::getAnsOpt() const{
    return answerOptions;
}
//Retrieve answer choices
string QuestionMC::printOptions(int ndx){
    string temp = options[ndx];
    return temp;
}
//Unknown at this time
string QuestionMC::addOption(){
    return anOption;
}
