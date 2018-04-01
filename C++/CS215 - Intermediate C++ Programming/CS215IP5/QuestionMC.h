//CS215-1603A-01
//Author: Duane Osburn
//Program: QuestionIF class interface
//Created Date: 07/17/2016
//Modified Date: 07/17/2016
//Description: This interface file has the function signatures and variables for the new questionIF class
//Modifications:
//08/03/2016 Added variable answerOptions to hold the number of answer options for the question. Added corresponding
//           setters and getters.
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
       void setAnsOpt(int);
       //Accessors
       std::string getAnswer() const;
       int getAnsOpt() const;
       std::string printOptions(int);
       std::string addOption();
    private:
       std::string answer;
       std::string options[6];
       std::string anOption;
       int answerOptions;
};

#endif // QUESTIONMC_H
