/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:Animation.java
 * Module: Animation Class 
 * Created: 03/16/2016
 * Modified:03/16/2016
 * 
 * Purpose: This class controls the animation of the "rays"
 * Modification:
 * 
 */
package IT251IP5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Duane Osburn
 */
public class Animation implements ActionListener{
    //Set class variables
    private LogoDetails logo;
    private int count;
    //Create instance of the logodetails class
    public Animation(LogoDetails logo){
        this.logo = logo;
        Timer t = new Timer(50, this);
        t.start();
    }
    //Override actionlistener method to control when the "rays" are visible
    @Override
    public void actionPerformed(ActionEvent e){
        count = count + 1;
        if (count % 10 == 0){
            logo.setShowRays(false);
        }
        if (count % 8 == 0){
            logo.setShowRays(true);
        }
        logo.repaint();
    //End Method    
    }
//End Class    
}
