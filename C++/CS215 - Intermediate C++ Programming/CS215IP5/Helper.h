//CS215-1603A-01
//Author: Duane Osburn
//Program: Helper class interface
//Created Date: 07/29/2016
//Modified Date: 07/29/2016
//Description: This interface file has the function signatures and variables for the new helper class
//Modifications:
//
//Include the necessary files
#ifndef HELPER_H
#define HELPER_H
//Library Files
#include <iostream>
#include <cstdlib>
#include <string>


class Helper
{
    public:
     //constructors and deconstructors
       Helper();
       ~Helper();
       //Mutators
       //Accessors
       //Class Functions
       int validateFileQuest(std::string);
       std::string validateQType(std::string);
       int validatePVal(std::string);
       std::string checkForInput(std::string);
       std::string validateTFAns(std::string TFAns);
       int validateAnsOpt(std::string);
       std::string validateMCAns(std::string, int);
    private:
};

#endif // HELPER_H
