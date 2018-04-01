//CS115-1602B-02
//Author: Duane Osburn
//Created Date: 5/18/2016
//Modified Date: 05/18/2016
//Description: This program will recieve input from the user and will then produce a welcome message as
// well as displaying a list of products that are for sale.
//Modifications:
//
//Include the necessary files 
#include "stdafx.h"
#include <iostream>
#include <cstdlib> 
#include <string>
using namespace std;

//Function Signatures

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
//Display company welcome message
	cout << "Hello and welcome to Hard Drives 'N More" << endl;
//Ask for input from the user
	cout << "Please enter your first name: " << endl;
	cin >> firstName;
	cout << "Please enter your last name: " << endl;
	cin >> lastName;
	cout << "Please enter your street address: " << endl;
	getline(cin, stAddress); //used to get a full line of text
	getline(cin, dummy); //used to clear out any extra carriage returns
	cout << "Please enter your city: " << endl;
	cin >> city;
	cout << "Please enter your state: " << endl;
	cin >> state;
	cout << "Please enter your zip code: " << endl;
	cin >> zipCode;
	//Display personalized welcome message
	cout << "Welcome " << firstName << " How can we be of service today" << endl;
	//Build data structure to hold current stock
	struct stock{
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
	cout << "The available stock is as follows" << endl;
	cout << "1. " << fastDrive.stockNum << "\t" << fastDrive.type << "\t" << fastDrive.size << "\t" << fastDrive.speed << "\t" << fastDrive.price << endl;
	cout << "2. " << fastSSD.stockNum << "\t" << fastSSD.type << "\t" << fastSSD.size << "\t" << fastSSD.speed << "\t" << fastSSD.price << endl;
	cout << "3. " << avgDrive.stockNum << "\t" << avgDrive.type << "\t" << avgDrive.size << "\t" << avgDrive.speed << "\t" << avgDrive.price << endl;
}
