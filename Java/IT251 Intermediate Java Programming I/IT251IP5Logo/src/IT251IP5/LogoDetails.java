/**
 * Course: IT251 - Intermediate Java Programming I
 * Filename:LogoDetails.java
 * Module: Logo Methods Class 
 * Created: 03/16/2016
 * Modified:03/16/2016
 * 
 * Purpose: This class contains the methods and functions to create the company logo.
 * Modification:
 * 
 *Code for the star and its animation borrowed from:
 *http://www.dreamincode.net/forums/topic/67928-question-of-drawing-star-using-java/
 */
package IT251IP5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

/**
 *
 * @author Duane Osburn
 */
public class LogoDetails extends JPanel {
    private boolean showRays;
    
@Override
public void paint(Graphics g1){
    int xPoints[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
    int yPoints[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
    
    Graphics2D g = (Graphics2D) g1;
    //Set Custom Colors
    final Color DKGREEN = new Color(23,128,54);
    final Color DKYELLOW = new Color(218,196,37);
    //Set Background Color
    g.setColor(DKGREEN);
    Dimension d = this.getSize();
    g.fillRect(0, 0, (int) d.getWidth(), (int) d.getHeight());
    //Draw Body of the logo
    g.setColor(Color.BLUE);
    g.fillOval(225, 275, 130, 120);
    g.setColor(DKYELLOW);
    g.fillRect(225, 225, 130, 120);
    //Draw the points on the shield logo
    g.setColor(Color.BLUE);
    this.drawPoints(g, 225,240);
    g.setColor(DKYELLOW);
    this.drawPoints(g, 278, 240);
    g.setColor(Color.BLUE);
    this.drawPoints(g, 330, 240);
    //Set black band on shield and points to even out the design
    g.setColor(Color.BLACK);
    g.fillRoundRect(220, 225, 138, 20, 20, 20);
    //Set company logo font and print out the font
    Font f = g.getFont();
    Font newFont = new Font("Serif", Font.BOLD, 42);
    g.setFont(newFont);
    g.drawString("Everything 'R Us", 125, 525);
    //Set and draw letters on the shield
    Font newFont1 = new Font("Century", Font.BOLD, 56);
    g.setFont(newFont1);
    g.drawString("E", 230, 290);
    g.drawString("U", 300, 335);
    Font newFont2 = new Font("Century", Font.BOLD, 32);
    g.setFont(newFont2);
    g.drawString("r", 275, 300);
    //Draw animation "rays"
    g.setColor(Color.WHITE);
    if (showRays){
        g.drawLine(225, 250, 175, 245);
        g.drawLine(225, 290, 175, 292);
        g.drawLine(225, 340, 175, 355);
    }else {
        g.drawLine(355, 250, 405, 245);
        g.drawLine(355, 290, 405, 292);
        g.drawLine(355, 340, 405, 355);
    }
    //Draw animated star
    this.drawStar(g, xPoints, yPoints);
//End Method    
}
//Method to draw animated star
private void drawStar(Graphics2D g, int xPoints[], int yPoints[]){
    GeneralPath star = new GeneralPath();
    star.moveTo( xPoints[ 0 ], yPoints[ 0 ] );
    for ( int k = 1; k < xPoints.length; k++ )
        star.lineTo( xPoints[ k ], yPoints[ k ] );
    star.closePath();
    g.translate( 110, 125 );
    for ( int j = 1; j <= 20; j++ )
        {
            g.rotate( Math.PI / 10.0 ); 
            g.setColor(new Color( ( int ) ( Math.random() * 256 ),( int ) ( Math.random() * 256 ),
             ( int ) ( Math.random() * 256 ) ) );
             g.fill( star ); // draw a filled star
        }
}
//Method to draw points on the shield
private void drawPoints(Graphics2D g, int x, int y){
    GeneralPath path = new GeneralPath();
    path.moveTo(x, y);
    path.lineTo(x + 25, y);
    path.lineTo(x + 25 , y - 25);
    path.lineTo(x + 12.5, y - 50);
    path.lineTo(x, y - 25);
     
    g.fill(path);
}
//Method to help set animation of the "rays"
public void setShowRays(boolean showRays){
    this.showRays = showRays;
}
//End Class
}
