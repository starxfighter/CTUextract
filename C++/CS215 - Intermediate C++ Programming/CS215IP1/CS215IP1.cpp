//CS215-1603A-01
//Author: Duane Osburn
//Created Date: 07/09/2016
//Modified Date:
//Description: This program will receive input from the user and will then produce a tabular information consisting of student names
// and their GPA scores. The program will account for a maximum of 10 students.
//Modifications:
//
//Include the necessary files
#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <cstring>
#include <string>
using namespace std;

//Function Signatures
double validGPA(double gpaTemp);
string validateStudent(string stuTemp);

//Start of the main section of the program
int main() {
	//Declare variables
	string students[10];            //array to hold student names
	double GPA[10] = {0};           //array to hold student gpa
	//Working and hold variables
	int i = 0;
	string stuTemp;
	string stuHold;
	string tempGPA;
	double gpaTemp;
	//Display welcome message
	cout << "Hello and welcome to The Teachers Gradebook" << endl;
	//Ask for input from the user
	cout << "Please enter the students name (last, first): " << endl;
	cout << "Enter XX to display the gradebook" << endl;
	getline(cin, stuTemp);
	//continue looping unit the control character is enter or 10 entries have been entered
	while (stuTemp != "XX" && i < 10){
        stuHold = validateStudent(stuTemp);                   //Validate that something was entered for a student name
        students[i] = stuHold;                           //stores the student name into an array
        cout << "Please enter the GPA: " << endl;        //ask for the student's GPA
        cin >> tempGPA;
        cin.ignore();
        gpaTemp = atof(tempGPA.c_str());                 //convert GPA from a string to a double
        GPA[i] = validGPA(gpaTemp);                      //Validate the GPA entered is valid
        cout << "Please enter the students name (last, first): " << endl;
        cout << "Enter XX to quit the gradebook" << endl;
        getline(cin, stuTemp);
        i++;
	}//end while
	cout << "\n";
	cout << "Name(Last, First) " << "\t\t\t\t" << "GPA" << endl;
	//Print out the stored information
    for (int x = 0; x < 10; x++){
        if (students[x].length() > 0){
            double rdnum=static_cast<double>(static_cast<int>(GPA[x]*100+0.5))/100.0; //round the GPA to two decimal points
            cout << students[x] << "\t\t\t\t\t" << rdnum << endl;
        } //end if
    }//end for
}// end main
//Validates that the GPA entered is between 0 and 100
double validGPA(double gpaTemp){
    string flag = "n";
    string tempIn;
	while (flag =="n"){                //Processes until there is valid data
        if (gpaTemp >= 0 && gpaTemp <= 100){              //Checks that the GPA is within the right range
            flag = "y";}
        else {
            cout << "invalid GPA. Please re-enter" << endl;      //Asks user for new input if invalid
            cin >> tempIn;
            cin.ignore();
            gpaTemp = atof(tempIn.c_str());               //Converts string to double
        }//end if
    }//end while
	return gpaTemp;                                       //Returns valid GPA
} //End validGPA
//Validates that the user entered at least something for the student name
string validateStudent(string stuTemp){
    string flag = "n";
    int inputLen;
    while (flag == "n"){                          //Process until there is valid data
        inputLen = stuTemp.length();              //Finds the  length of the string inputted by the user
        if (inputLen > 0){                        //Make sure that something was entered
            flag = "y";}
        else {
            cout << "no student name entered. Please re-enter" << endl;     //Asks user for new input if invalid
            getline(cin, stuTemp);
        }//end if
    }//end while
    return stuTemp;                                 //Returns valid student name
}//end validateStudent
