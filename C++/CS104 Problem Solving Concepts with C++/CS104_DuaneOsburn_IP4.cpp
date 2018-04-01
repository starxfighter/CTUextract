#include <iostream>
#include <cstdlib>
using namespace std;
//CS104-X-1503B-01
//Author: Duane OSburn
//Created Date: 9/14/2015
// Fourth Program: Receive input, manipulate input and then output result
// Use of user-defined functions. Two for temperature conversion and one to meet the IP requirements
// there is no error handling in the program. Add all four control structures( IF, Switch, While, For) to the program.
//
//Function Signatures
double convCtoF(double convTemp);
double convFtoC(double convTemp);
int luckyNumber(int BDay, int favNum);

int main() {
	int choice, birthDay, numFav, luckNum, randNum, i, switchNum;
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
   cout << "Enter a random integer" << endl;
   cin >> randNum;
//If Control Structure   
   if (randNum > luckNum)
      {switchNum = 1;} 
   else{
       if (randNum < luckNum)
	     {switchNum = 2;}
      else
	     {switchNum = 0;}
   }
//Switch Control Structure		
   switch (switchNum){
   
	    case 1:
	    	cout << "Your lucky number is less than the random number" << endl << endl;
	    	break;
		
		case 2:
			cout << "Your lucky number is greater than the random number" << endl << endl;
			break;
		
		default:
			cout << "Your lucky number is the same as the random number" << endl << endl;
   }
//While Control Structure   
	cout << "Lets add 10 to your favorite number" << endl << endl;
	i = numFav + 9;
	while (numFav <= i){
	    cout << "Not Yet. Favorite number is now:" << numFav << endl;
		numFav ++;} 
	cout << "Now your favorite number is:" << numFav << endl << endl;
//For Control Structure	
	cout << "Lets take your favorite number back to its original value" << endl << endl;
	for (int x = 11; x > 1; x--){
		numFav = numFav - 1;
		cout << "Favorite Number is now" << numFav << endl;
	}	
	cout << "Favorite Number is back to its original value:" << numFav << endl; 
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
