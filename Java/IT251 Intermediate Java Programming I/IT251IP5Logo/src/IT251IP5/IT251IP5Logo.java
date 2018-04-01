/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:IT251IP5Logo.java
 * Module: Driver Application 
 * Created: 03/16/2016
 * Modified:03/16/2016
 * 
 * Purpose: This driver application will create a company logo in a JFrame using general shapes and generalPath. Some animation has 
 * also been included.
 * Modification:
 * 
 */
package IT251IP5;


import javax.swing.JFrame;

/**
 *
 * @author Duane Osburn
 */
public class IT251IP5Logo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create the JFrame window
        JFrame window = new JFrame("Everything 'R Us");
        window.setBounds(600, 200, 600, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create an instance of the LogoDetails class which builds the logo
        LogoDetails logo = new LogoDetails();
        window.add(logo);
        //Make sure the window is visible
        window.setVisible(true);
        //Create an instance of the animator class to start the animations
        Animation a = new Animation(logo);
    //End Main    
    }
//End Class    
}
