//CS115-1602B-02
//Author: Duane Osburn
//Program: customer class definition
//Created Date: 06/02/2016
//Modified Date: 06/02/2016
//Description: This class definition holds the classes functions
//Modifications:
//
//Include the necessary files 
#include "Customer.h" //This is the classes interface file
#include <iostream>
#include <cstdlib> 
#include <string>
using namespace std;
//Constructor
Customer::Customer()
{
}
//deconstructor
Customer::~Customer()
{
}
//Sets the customers first name
void Customer::setCustFirstName(string name){
	custFirstName = name;
}
//Sets the customers last name
void Customer::setCustLastName(string lname){
	custLastName = lname;
}
//Sets the customers address
void Customer::setCustAddr(string addr){
	custAddress = addr;
}
//Sets the customers city
void Customer::setCustCity(string city){
	custCity = city;
}
//Sets the customers state
void Customer::setCustState(string state){
	custState = state;
}
//Sets the customers zip code
void Customer::setCustZip(int zip){
	custZipCode = zip;
}
//Retrieves the customers first name
string Customer::getCustFirstName() const{
	return custFirstName;
}
//Retrieves the customers last name
string Customer::getCustLastName() const{
	return custLastName;
}
//Retrieves the customers address
string Customer::getCustAddr() const{
	return custAddress;
}
//Retrieves the customers city
string Customer::getCustCity() const{
	return custCity;
}
//Retrieves the customers state
string Customer::getCustState() const{
	return custState;
}
//Retrieves the customes zip code
int Customer::getCustZip() const{
	return custZipCode;
}
	
