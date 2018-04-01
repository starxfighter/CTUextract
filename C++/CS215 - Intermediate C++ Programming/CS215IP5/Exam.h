//CS215-1603A-01
//Author: Duane Osburn
//Program: Exam class interface
//Created Date: 07/29/2016
//Modified Date: 07/29/2016
//Description: This interface file has the function signatures and variables for the new exam class
//Modifications:
//08/03/2016    Added new variable arrays to hold the exam questions, point values and if the user got the question right or wrong, and
//              number of questions that make up the exam. Corresponding setters and getters added.
//
//Include the necessary files
#ifndef EXAM_H
#define EXAM_H
//
#include <Helper.h>
#include <QuestionIF.h>
#include <QuestionMC.h>
//Library files
#include <fstream>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <iomanip>
#include <cstring>
#include <string>


class Exam
{
    public:
       //constructors and deconstructors
       Exam();
       ~Exam();
       //Mutators
       void setFileName(std::string);
       void setQuestions(std::string, int);
       void setQuestionPoints(int, int);
       void setPassFail(int, int);
       void setNumQuest(int);
       //Accessors
       std::string getFileName() const;
       std::string getQuestions(int ndx);
       int getQuestionPoints(int ndx);
       int getPassFail(int ndx);
       int getNumQuest();
       //Class functions
       std::string loadTestBank();
       void displayTest(std::string);
       QuestionIF processTF(std::ifstream& , std::string);
       QuestionMC processMC(std::ifstream& , std::string);
       void printTF(QuestionIF, int);
       void printMC(QuestionMC, int);

    private:
        std::string fileName;
        Helper h;
        std::ifstream myfile;
        std::string missQuest[10];
        int questPoint[10];
        int passFail[10];
        int numOfQuest;
};

#endif // EXAM_H
