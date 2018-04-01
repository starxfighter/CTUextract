/**
 * Course: IT351 - Advance Java Programming
 * Filename:Server.java
 * Module: Server side application
 * Created: 08/19/2016
 * Modified:08/19/2016
 * 
 * Purpose: This server application will get a request from a client to either retrieve the contents of the customer or product file.
 * Once the contents have been retrieved the application will place them in the appropriate class structure and then load them into an object 
 * array that will be sent to the client that called the server. 
  * Modification:
 * 
 * 
 */
package IT351Ip2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Duane Osburn
 */
public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Creates an instance of the socket that the server will use for communication with the client
        System.out.println("Starting Up Server");
        ServerSocket ss = new ServerSocket(3718);
        int i = 1;
        //The server will continue to run in the background until it is physically ended
        while (true){
            //Makes the connection with the client
            Socket socket = ss.accept();
            //Create the necessary instances in order to pass information back and forth with the client
            System.out.println("Got a connection");
            runClientController rcc = new runClientController(socket.getInputStream(), socket.getOutputStream());
            Thread t = new Thread(rcc);
            System.out.println("Starting thread # " + i);
            t.start();
            i++;
        }//End While
    }//End Main
}//End

