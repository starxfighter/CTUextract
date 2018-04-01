/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT351Ip2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ClientController
{
    public void clientConv(InputStream inputStream, OutputStream outputStream) throws IOException, ClassNotFoundException
    {
        System.out.println("Running client controller");
        ObjectInputStream in = new ObjectInputStream(inputStream);
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        //Receives the data request from the client which tells the server what information the client wants
        DataRequest request = (DataRequest) in.readObject();
        //Use of a switch here to control the flow of processing. 
        switch (request.getDataType()){
            case DataRequest.CUSTOMER:
                System.out.println("Returning Customer");
                out.writeObject(readCustFile());
                out.flush();
            break;
            case DataRequest.PRODUCT:
                System.out.println("Returning Product");
                out.writeObject(readProdFile());
                out.flush();
            break;
        }
        
    }//End clientConv
//This method will read the customer file, parse the data, load it into the class structure and then pass a list of objects back
    public static List<Customer> readCustFile() throws IOException{
        //create necessary instances to read in the file
        File file = new File("customer.txt");
        FileReader freader = new FileReader(file);
        BufferedReader reader = new BufferedReader(freader);
        //Create array list to hold the data lines read in
        List<Customer> cust = new ArrayList<Customer>();
        //Do the first read of the file
        String data = reader.readLine();
        
        //Continue processing until the end of the file is reached
        while (data != null){
            Customer c = null;
            try{
                c = parseCust(data);
            }catch(Exception e){
                System.out.println("Problem doing the parsing");
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
            }
            //if the record did not parse then set error messagage otherwise add the record to the array list
            if (c == null){
                System.out.println("The data line is bad " + data);
            }else{
                cust.add(c);
            }
            //read next data line in the file
            data = reader.readLine();
        }//end while
        reader.close();
        return cust;
    }
//This method will parse the customer file. The file is a comma separated file
    private static Customer parseCust(String dline){
        //Declare and Initialize variables
        String custID;
        String firstName;
        String lastName;
        String streetAddr;
        String city;
        String state;
        int zip;
        String phone;
        //Separate data line into individual tokens
        StringTokenizer st = new StringTokenizer(dline, ",");
        //Assign tokens to data elements
        custID = st.nextToken();
        firstName = st.nextToken().trim();
        lastName = st.nextToken().trim();
        streetAddr = st.nextToken();
        city = st.nextToken();
        state = st.nextToken();
        String tZip = st.nextToken();
        zip = Integer.parseInt(tZip);
        phone = st.nextToken();
        //Data validation
        if (firstName.length() == 0){
            return null;
        }
        if (lastName.length() == 0){
            return null;
        }
        
        //Initialize instance of Customer class
        Customer ct = new Customer();
        //Build Customer Class instance
        ct.setCustID(custID);
        ct.setCustFName(firstName);
        ct.setCustLName(lastName);
        ct.setCustStAddr(streetAddr);
        ct.setCustCity(city);
        ct.setCustState(state);
        ct.setCustZip(zip);
        ct.setCustPhone(phone);
        //Return completed Customer class
        return ct;
    }
//This method will read the product file, parse the data, load it into the class structure and then pass a list of objects back
    public static List<Product> readProdFile() throws IOException{
        //create necessary instances to read in the file
        File file = new File("product.txt");
        FileReader freader = new FileReader(file);
        BufferedReader reader = new BufferedReader(freader);
        //Create array list to hold the data lines read in
        List<Product> prod = new ArrayList<Product>();
        //Do the first read of the file
        String data = reader.readLine();
        
        //Continue processing until the end of the file is reached
        while (data != null){
            Product p = null;
            try{
                p = parseProd(data);
            }catch(Exception e){
                System.out.println("Problem doing the parsing");
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
            }
            //if the record did not parse then set error messagage otherwise add the record to the array list
            if (p == null){
                System.out.println("The data line is bad " + data);
            }else{
                prod.add(p);
            }
            //read next data line in the file
            data = reader.readLine();
        }//end while
        reader.close();
        return prod;
    }
//This method will parse the product file. The file is a comma separated file
    private static Product parseProd(String dline){
        //Declare and Initialize variables
        String pId;
        String pName;
        String pDesc;
        double pPrice;
        
        //Separate data line into individual tokens
        StringTokenizer st = new StringTokenizer(dline, ",");
        //Assign tokens to data elements
        pId = st.nextToken();
        pName = st.nextToken().trim();
        pDesc = st.nextToken().trim();
        String tPrice = st.nextToken();
        pPrice = Double.parseDouble(tPrice);
        //Data validation
        if (pName.length() == 0){
            return null;
        }
               
        //Initialize instance of Product class
        Product pr = new Product();
        //Build Product Class instance
        pr.setProductId(pId);
        pr.setProductName(pName);
        pr.setProductDesc(pDesc);
        pr.setProductPrice(pPrice);
        //Return completed Product class       
        return pr;
    }
    
}//Class End
