package electricity.billing.system;

import java.awt.*;
import javax.swing.*;

public class Splash_screen extends JFrame
{

    Splash_screen()
    {
        ImageIcon image_Icon = new ImageIcon(ClassLoader.getSystemResource("icons\\Splash.jpg")); // Impot image from System
        Image imageone = image_Icon.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT); //Scalling of image
        ImageIcon imageIcon2 = new ImageIcon(imageone);//This cantnot add directly to jframe hence we creadted this object
        JLabel imagLabel = new JLabel(imageIcon2); // object of label to add image on frame
        add(imagLabel); //Add image to Frame


        setSize(600, 800);
        setLocation(500, 10);
        setVisible(true); //Must be in the last 

        // Using sleep Function in try and catch because there may be chances of some exceptions
        try {
            Thread.sleep(1200);  //To hold splash screen
            setVisible(false);
            // To open any other page after splash screen is to be add there
            new Login();

        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    public static void main(String[] args) 
    {
        new Splash_screen();
    }
}
