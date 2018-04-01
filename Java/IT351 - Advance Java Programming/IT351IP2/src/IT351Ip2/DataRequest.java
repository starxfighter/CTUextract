/**
 * Course: IT351 - Advance Java Programming
 * Filename:DataRequest.java
 * Module: Communication Class
 * Created: 08/19/2016
 * Modified:08/19/2016
 * 
 * Purpose: This class is used to control the communication between the client and the server. It is through the use of this class that the server knows
 * what information that the client is asking for.
 * Modification:
 * 
 */
package IT351Ip2;

import java.io.Serializable;

/**
 *
 * @author Duane Osburn
 */
public class DataRequest implements Serializable
{
    //Declare and Initialize variables
    private int dataType;
    
    public static final int CUSTOMER = 0;
    public static final int PRODUCT = 1;

    //Setters and Getters
    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }
//End    
}
