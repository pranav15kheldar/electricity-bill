package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// To apply action listener we need to impelent actionlistner to our class
public class Login extends JFrame implements ActionListener
{
    JTextField userTest , passTest;// Declear globaly because we have to use it with database using JDBC
    Choice loginChoice;
    JButton loginButton , CancelButton , signupButton;
    Login()
    {
        super("Login"); //use to add title to our page and must be first in the constructor
        getContentPane().setBackground(Color.lightGray); // Change Color of frame background
        JLabel username = new JLabel("Username"); // label for username
        userTest = new JTextField(); //Test field For user name
        JLabel passWord = new JLabel("Password"); // label for Password
        passTest = new JTextField(); //Text field for password
        add(username);
        add(userTest);
        add(passWord);
        add(passTest);

        // As we remove layout but we have to set our componets to do so we use setbound function
        username.setBounds(300, 60, 100,20);
        userTest.setBounds(400, 60, 200, 20);
        passWord.setBounds(300, 100, 100, 20);
        passTest.setBounds(400, 100, 200, 20);


        JLabel loggin = new JLabel("Login In As");
        add(loggin);
        loggin.setBounds(300, 140, 100, 20);
        loginChoice = new Choice();
        add(loginChoice);
        loginChoice.setBounds(400, 140,150, 20);
        // To add Choice to our Drop down list
        loginChoice.add("Admin");
        loginChoice.add("Coustomer");

        // Buttons
        // LOgin Button
        loginButton = new JButton("Login");
        loginButton.setBounds(330, 180, 100, 20);
        add(loginButton);
        loginButton.addActionListener(this);//to know wether button is click or not 

        // Cancel Button
        CancelButton = new JButton("Cancel");
        CancelButton.setBounds(450, 180, 100, 20);
        add(CancelButton);
        CancelButton.addActionListener(this);//to know wether button is click or not 

        // SignUp Button
        signupButton = new JButton("SignUp");
        signupButton.setBounds(400, 220, 100, 20);
        add(signupButton);
        signupButton.addActionListener(this);//to know wether button is click or not 
        
        // image 
       ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icons\\profile.png"));
       Image profileTwo = profileOne.getImage().getScaledInstance(250 , 250 , Image.SCALE_DEFAULT);
       ImageIcon fprofileOne = new ImageIcon(profileTwo);
       JLabel profileLabel = new JLabel(fprofileOne);
       add(profileLabel);
       profileLabel.setBounds(10, 10, 250, 250);

        setLayout(null); // to remove default layout i.e border laypout from our frame
        setSize(640, 300);
        setLocation(500, 200);
        setVisible(true); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) 
    {
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == signupButton) //getSoucre returns on which button event is performed
        {
            setVisible(false);
            new Signup();
        }
        else if(e.getSource() == CancelButton)
        {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
}
