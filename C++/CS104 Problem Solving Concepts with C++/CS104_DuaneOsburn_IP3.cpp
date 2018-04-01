#include <iostream>
#include <cstdlib>
using namespace std;
//CS104-X-1503B-01
//Author: Duane OSburn
//Created Date: 9/07/2015
// Third Program: Recieve input, manipulate inout and then ouptut result
// Use of user-defined functions. Two for temperature conversion and one to meet the IP requirements
// there is no error handling in the program
//
//Function Signatures
double convCtoF(double convTemp);
double convFtoC(double convTemp);
int luckyNumber(int BDay, int favNum);

int main() {
	int choice, birthDay, numFav, luckNum;
	double tempin, newtemp;
	cout << "Let's Convert a Temperature"<< endl;
	cout << "What do you want to convert from" << endl;
	cout << "Enter 1 for Celsius or 2 for Fahrenheit" << endl;
	cin >> choice;
	cout << "enter tempertaure" << endl;
	cin >> tempin;
	if (choice == 1 || choice == 2){
			if (choice == 2){
			    newtemp = convFtoC(tempin);}
			else {
			    newtemp = convCtoF(tempin);}
		}
   cout << "The new temperature is: " << newtemp <<endl;
   cout << "Enter the day of your birth" << endl;
   cin >> birthDay;
   cout << "Enter your favorite number" << endl;
   cin >> numFav;
   luckNum = luckyNumber(birthDay, numFav);
   cout << "Your lucky number is: " << luckNum << endl;
}
//Calculates temperature from Celsius to Fahrenheit
double convCtoF(double convTemp){
	double convertedTemp;
	convertedTemp = ((convTemp * 1.8) + 32);
	return convertedTemp;
}
//Calculates temperature from Fahrenheit to Celsius
double convFtoC(double convTemp){
	double convertedTemp;
	convertedTemp = ((convTemp - 32)/ 1.8);
	return convertedTemp;
}
//Calculates a persons lucky number
int luckyNumber(int BDay, int favNum){
	int luckynum;
	luckynum = ((BDay + favNum) + 1);
	return luckynum;
}
