//CS215-1603A-01
//Author: Duane Osburn
//Program: Question class interface
//Created Date: 07/17/2016
//Modified Date: 07/17/2016
//Description: This interface file has the function signatures and variables for the new question class
//Modifications:
//
//Include the necessary files
#ifndef QUESTION_H
#define QUESTION_H
//
#include <iostream>
#include <cstdlib>
#include <string>
//
class Question
{
    public:
       //constructors and deconstructors
       Question(std::string questIn, int pvalue);
       Question();
       ~Question();
       //Mutators
       void setQuestion(std::string);
       void setValue(int);
       //Accessors
       std::string getQuestion() const;
       int getValue() const;
       virtual std::string printOptions(int);
       virtual std::string getAnswer();
    private:
        std::string question;
        int value;
        std::string options[6];
        std::string answer;
};

#endif // QUESTION_H
