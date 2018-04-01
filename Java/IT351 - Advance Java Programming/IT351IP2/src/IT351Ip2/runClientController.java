/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT351Ip2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class runClientController implements Runnable
{
    private InputStream in;
    private OutputStream out;

    public runClientController(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    
        
        
    @Override
    public void run()
    {
        System.out.println("Starting client controller");
        ClientController cc = new ClientController();
        try {
           cc.clientConv(in, out);
        } catch (Exception ex) {
            Logger.getLogger(runClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
