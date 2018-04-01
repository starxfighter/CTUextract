//CS215-1603A-01
//Author: Duane Osburn
//Program: QuestionIF class interface
//Created Date: 07/17/2016
//Modified Date: 07/17/2016
//Description: This interface file has the function signatures and variables for the new questionIF class
//Modifications:
//
//Include the necessary files
#ifndef QUESTIONMC_H
#define QUESTIONMC_H
//
#include <iostream>
#include <cstdlib>
#include <string>
#include <Question.h>



class QuestionMC : public Question
{
    public:
       //constructors and deconstructors
       QuestionMC();
       QuestionMC(std::string questIn, int pvalue, std::string ans);
       ~QuestionMC();
       //Mutators
       void setAnswer(std::string);
       void setOptions(int, std::string);
       //Accessors
       std::string getAnswer() const;
       std::string printOptions(int);
       std::string addOption();
    private:
       std::string answer;
       std::string options[6];
       std::string anOption;
};

#endif // QUESTIONMC_H
