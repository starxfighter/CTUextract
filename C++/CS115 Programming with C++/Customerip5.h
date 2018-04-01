//CS115-1602B-02
//Author: Duane Osburn
//Program: customer class interface 
//Created Date: 06/02/2016
//Modified Date: 06/02/2016
//Description: This interface file has the function signatures and variables for the new customer class
//Modifications:
//
//Include the necessary files 
#ifndef CUSTOMER_H
#define CUSTOMER_H

#include <iostream>
#include <cstdlib> 
#include <string>
//Declare the customer class
class Customer
{
	//Declare the class function signatures
	public:
		//constructors and deconstructors
		Customer();
		~Customer();
		//Mutators
		void setCustFirstName(std::string);
		void setCustLastName(std::string);
		void setCustAddr(std::string);
		void setCustCity(std::string);
		void setCustState(std::string);
		void setCustZip(int);
		//Accessors
		std::string getCustFirstName() const;
		std::string getCustLastName() const;
		std::string getCustAddr() const;
		std::string getCustCity() const;
		std::string getCustState() const;
		int getCustZip() const;
	//Declare the class variables
	private:
	std::string custFirstName;
	std::string custLastName;
	std::string custAddress;
	std::string custCity;
	std::string custState;
	int custZipCode;
};

#endif
