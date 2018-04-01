//CS215-1603A-01
//Author: Duane Osburn
//Program: Exam class interface
//Created Date: 07/29/2016
//Modified Date: 07/29/2016
//Description: This interface file has the function signatures and variables for the new exam class
//Modifications:
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
       //Accessors
       std::string getFileName() const;
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
};

#endif // EXAM_H
