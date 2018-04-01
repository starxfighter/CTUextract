//CS215-1603A-01
//Author: Duane Osburn
//Program: QuestionMC class definition
//Created Date: 07/17/2016
//Modified Date: 07/17/2016
//Description: This class definition holds the classes functions
//Modifications:
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
//Retrieve answer
string QuestionMC::getAnswer() const{
    return answer;
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
