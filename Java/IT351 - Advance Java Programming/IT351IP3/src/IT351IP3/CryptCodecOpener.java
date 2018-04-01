/**
 * Course: IT351 - Advance Java Programming
 * Filename:CryptCodecOpener.java
 * Module: Encryption Interface for MS Access
 * Created: 
 * Modified:
 * 
 * Purpose: This class is necessary in order to access a MS Access database that has been encrypted. The code comes from Ucanaccess which is a MS Access
 * JDBC driver. 
 * Modification:
 * 
 */
package IT351IP3;

/**
 *
 * @author Ucanaccess
 */
import java.io.File;
import java.io.IOException;
import net.ucanaccess.jdbc.JackcessOpenerInterface;
import com.healthmarketscience.jackcess.CryptCodecProvider;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;

public class CryptCodecOpener implements JackcessOpenerInterface {
         @Override
    public Database open(File fl,String pwd) throws IOException {
       DatabaseBuilder dbd =new DatabaseBuilder(fl);
       dbd.setAutoSync(false);
       dbd.setCodecProvider(new CryptCodecProvider(pwd));
       dbd.setReadOnly(false);
       return dbd.open();
    }
  //Notice that the parameter setting autosync =true is recommended with UCanAccess for performance reasons. 
  //UCanAccess flushes the updates to disk at transaction end. 
  //For more details about autosync parameter (and related tradeoff), see the Jackcess documentation. 
}