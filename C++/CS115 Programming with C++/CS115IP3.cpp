//CS115-1602B-02
//Author: Duane Osburn
//Created Date: 5/26/2016
//Modified Date: 06/02/2016
//Description: This program will recieve input from the user and will then produce a welcome message as
// well as displaying a list of products that are for sale.
//Modifications:
//05/26/2016 Added functionality to allow the user to place an order, subtotal the order and produce a final order total
//06/02/2016 Added a customer class to the program and use class functions to get information out of the new customer class
//
//Include the necessary files 
#include "Customer.h" //customer class file
#include <iostream>
#include <cstdlib> 
#include <string>
using namespace std;

//Function Signatures
bool validateSelection(int choice);
double addCharges(double sTotal);
int validateZip(int input);

//Start of the main section of the program
int main() {
	//Declare variables
	string firstName;
	string lastName;
	string stAddress;
	string city;
	string state;
	string dummy;
	int zipCode;
	int validZip;
	int selection;
	int userQty;
	int orderHold[3] = { 0,0,0 };
	double subTotal;
	double grandTotal;
	//
	//Create customer class object	
	Customer customer;	
	//Display company welcome message
	cout << "Hello and welcome to Hard Drives 'N More" << endl;
	//Ask for input from the user
	cout << "Please enter your first name: " << endl;
	cin >> firstName;
	customer.setCustFirstName(firstName);
	cout << "Please enter your last name: " << endl;
	cin >> lastName;
	customer.setCustLastName(lastName);
	cin.ignore();
	cout << "Please enter your street address: " << endl;
	getline(cin, stAddress); //used to get a full line of text
	customer.setCustAddr(stAddress);
	cout << "Please enter your city: " << endl;
	cin >> city;
	customer.setCustCity(city);
	cout << "Please enter your state: " << endl;
	cin >> state;
	customer.setCustState(state);
	cout << "Please enter your zip code: " << endl;
	cin >> zipCode;
	validZip = validateZip(zipCode); //Makes sure that a 5 digit zipcode is entered
	customer.setCustZip(validZip);
	//Display personalized welcome message
	cout << "Welcome " << customer.getCustFirstName() << " How can we be of service today" << endl;
	//Build data structure to hold current stock
	struct stock {
		int stockNum;
		string type;
		string size;
		string speed;
		double price;
	};
	//Declare and set stock object called fastDrive
	stock fastDrive;
	fastDrive.stockNum = 12456;
	fastDrive.type = "Plate";
	fastDrive.size = "1TB";
	fastDrive.speed = "16ms";
	fastDrive.price = 129.00;
	//Declare and set stock object called fastSSD
	stock fastSSD;
	fastSSD.stockNum = 45889;
	fastSSD.type = "SSD";
	fastSSD.size = "256gb";
	fastSSD.speed = "32ms";
	fastSSD.price = 256.25;
	//Declare and set stock object called avgDrive
	stock avgDrive;
	avgDrive.stockNum = 99645;
	avgDrive.type = "Plate";
	avgDrive.size = "500gb";
	avgDrive.speed = "10ms";
	avgDrive.price = 89.99;
	//Display the available stock
	cout << "\nThe available stock is as follows" << endl;
	cout << "1. " << fastDrive.stockNum << "\t" << fastDrive.type << "\t" << fastDrive.size << "\t" << fastDrive.speed << "\t" << fastDrive.price << endl;
	cout << "2. " << fastSSD.stockNum << "\t" << fastSSD.type << "\t" << fastSSD.size << "\t" << fastSSD.speed << "\t" << fastSSD.price << endl;
	cout << "3. " << avgDrive.stockNum << "\t" << avgDrive.type << "\t" << avgDrive.size << "\t" << avgDrive.speed << "\t" << avgDrive.price << endl;
	cout << "\n\nEnter the item number you wish to order or hit 0 to exit: " << endl;
	cin >> selection;
	//Asks user to enter how many of their selection they want
	//the qunatity entered is save to an array for later processing
	//this will continue to loop until the user enters a 0 to exit the order process
	while (selection != 0) {
		if (validateSelection(selection)){
			cout << "Enter the qunatity desired: " << endl;
			cin >> userQty;
			orderHold[selection - 1] = orderHold[selection - 1] + userQty;
		}
		else {
			cout << "Item number entered is invalid." << endl;
		}
		cout << "\n\nEnter the item number you wish to order or hit 0 to exit: " << endl;
		cin >> selection;
	}
	//This will display the order summary as well as grand totals
	cout << "Your order is as follows" << endl;
	grandTotal = 0;
	for (int x = 0; x < 3; x++){
		subTotal = 0;
		if (orderHold[x] > 0){
			switch (x){     //the subtotal line displayed is dependent on the values held in the array. The index value represents the item number which in turn determines the product
   
	    		case 0:
	    			subTotal = fastDrive.price * orderHold[x];
	    			cout << fastDrive.stockNum << "\t" << fastDrive.type << "\t" << fastDrive.size << "\t" << fastDrive.speed << "\tPrice: " << fastDrive.price << "\tQty Ordered " << orderHold[x] << "\tSubtotal " << subTotal << endl;
			   	break;
		
				case 1:
					subTotal = fastSSD.price * orderHold[x];
					cout << fastSSD.stockNum << "\t" << fastSSD.type << "\t" << fastSSD.size << "\t" << fastSSD.speed << "\tPrice: " << fastSSD.price << "\tQty Ordered " << orderHold[x] << "\tSubtotal " << subTotal << endl;
		      	break;
		
				case 2:
					subTotal = avgDrive.price * orderHold[x];
					cout << avgDrive.stockNum << "\t" << avgDrive.type << "\t" << avgDrive.size << "\t" << avgDrive.speed << "\tPrice: " << avgDrive.price << "\tQty Ordered " << orderHold[x] << "\tSubtotal " << subTotal << endl;
				break;	
   			}
   			//this will establish the grandtotal for the order
   			grandTotal = grandTotal + addCharges(subTotal);
		}
	}
	cout << "The grand total is " << grandTotal << endl;
	//Shows that the customer class has been created and populated with the users input
	cout << "The order will be shipped to " << customer.getCustFirstName() << " " << customer.getCustLastName() << endl <<
		"\t\t\t" << customer.getCustAddr() << endl <<
		"\t\t\t" << customer.getCustCity() << " , " << customer.getCustState() << endl <<
		"\t\t\t" << customer.getCustZip() << endl;
}
//This function will add tax to the item subtotal and then determine if a shipping charge is needed. All orders < 2000 will get a shipping charge.
//The tax rate is hard coded at this time for ease of use 
double addCharges(double sTotal){
		double rollingTotal = 0;
		double taxRate = 0.075;
		double shipChrg = 19.95;
		rollingTotal = sTotal + (sTotal * taxRate);
		cout << "\tThe subtotal with tax is " << rollingTotal << endl;
		if (rollingTotal < 2000){
			rollingTotal = rollingTotal + shipChrg;
			cout << "\tA shipping charge of " << shipChrg << " has been assessed"<< endl;
		}
		return rollingTotal;
}
//This function will validate the selection of the item to order. It will return a boolean that will be interrogated by an IF structure	
bool validateSelection(int choice){
	bool valid = false;
	if (choice == 1 || choice == 2 || choice == 3){
		valid = true;}
	else{
		valid = false;}
	return valid;	
			
}
//This function will validate the zip code by ensuring that 5 digits have been entered. Anything more or less will ask the user
//to re-enter the zip code until its considered valid	
int validateZip(int input){
    string flag = "n";
	int len = 1;
	int i = input;  
	while (flag =="n"){
		for (len = 0; i > 0; len++){
			i = i/10;
		}
		//
		if (len == 5){
			flag = "y";}
		else {
			cout << "invalid zip code. Please re-enter" << endl;
			cin >> i;
		}	
	}
	return input;
}
