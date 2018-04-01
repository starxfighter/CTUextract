#include <iostream>
#include <cstdlib>
using namespace std;
//CS104-X-1503B-01
//Author: Duane OSburn
//Created Date: 8/24/2015
// Second Program: Recieve input, manipulate inout and then ouptut result
// there is no error handling in the program

int main() {
	int choice;
	double tempin, newtemp;
	cout << "Let's Convert a Temperature"<< endl;
	cout << "What do you want to convert from" << endl;
	cout << "Enter 1 for Celsius or 2 for Fahrenheit" << endl;
	cin >> choice;
	cout << "enter tempertaure" << endl;
	cin >> tempin;
	if (choice == 1 || choice == 2){
			if (choice == 2){
				newtemp = ((tempin - 32)/ 1.8);}
			else {
				newtemp = ((tempin * 1.8) + 32);}
		}
   cout << "The new temperature is: " << newtemp <<endl;
   
}
