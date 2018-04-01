//CS215-1603A-01
//Author: Duane Osburn
//Program: Question class definition
//Created Date: 07/17/2016
//Modified Date: 07/17/2016
//Description: This class definition holds the classes functions
//Modifications:
//
//Include the necessary files
#include "Question.h" //This is the Question interface file
#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;
//Constructor
Question::Question()
{
    //ctor
}
Question::Question(string questIn, int pvalue)
{
    question = questIn;
    value = pvalue;
}
//deconstructor
Question::~Question()
{
    //dtor
}
//Sets question
void Question::setQuestion(string quest){
        question = quest;
}
//Sets point value
void Question::setValue(int pvalue){
        value = pvalue;
}
//Retrieve the question
string Question::getQuestion()const {
    return question;
}
//Retrieve the point value
int Question::getValue() const {
    return value;
}
//Returns the answer choices
string Question::printOptions(int ndx){
    return options[ndx];
}
//Returns the answer to the question
string Question::getAnswer(){
    return answer;
}
