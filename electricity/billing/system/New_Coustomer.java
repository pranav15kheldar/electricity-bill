package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

public class New_Coustomer extends JFrame implements ActionListener
{
    // Global decleration
    JLabel heading ,Coustomername , meter_num , address , City , State , Email, Mobile_num,textmeter_num;
    TextField textCoustomername , textaddress , textcity ,textstate , textEmail , textmobile_num;
    JButton next , cancel;
    // COnstructor
    New_Coustomer()
    {
        super("New Coustomer");

        // Panel New Coustomer Start
        // Use to create pannel 
        JPanel panel = new JPanel();
        panel.setLayout(null); 
        add(panel);// add panel to frame
        panel.setBackground(new ColorUIResource(252,186,3));  //Set the color of panel

        // Heading 
        heading = new JLabel("New Coustomer"); 
        heading.setBounds(180,10,200,20);
        panel.add(heading);
        heading.setFont(new Font("Tahoma",Font.BOLD,20)); 

        // Coustomer 
        Coustomername = new JLabel("Coustomer Name:");
        Coustomername.setBounds(50,80,130,20);
        panel.add(Coustomername);
        textCoustomername = new TextField();
        textCoustomername.setBounds(180,80,130,20);
        panel.add(textCoustomername);

        // Meter number
        meter_num = new JLabel("Meter Number:");
        meter_num.setBounds(50,120,130,20);
        panel.add(meter_num);
        textmeter_num= new JLabel(" ");
        textmeter_num.setBounds(180, 120, 130, 20);
        panel.add(textmeter_num);
        // Generate Random 6 digit number as meter NUmber
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        textmeter_num.setText(" "+ Math.abs(number));

        // Address
        address = new JLabel("Address:");
        address.setBounds(50,160,130,20);
        panel.add(address);
        textaddress= new TextField();
        textaddress.setBounds(180, 160, 130, 20);
        panel.add(textaddress);

        // City
        City = new JLabel("City:");
        City.setBounds(50,200,130,20);
        panel.add(City);
        textcity= new TextField();
        textcity.setBounds(180, 200, 130, 20);
        panel.add(textcity);

        // State
        State = new JLabel("State:");
        State.setBounds(50,240,130,20);
        panel.add(State);
        textstate= new TextField();
        textstate.setBounds(180, 240, 130, 20);
        panel.add(textstate);

        // Email
        Email = new JLabel("Email:");
        Email.setBounds(50,280,130,20);
        panel.add(Email);
        textEmail= new TextField();
        textEmail.setBounds(180, 280, 130, 20);
        panel.add(textEmail);

        // Mobile NUmber
        Mobile_num = new JLabel("Mobile Number:");
        Mobile_num.setBounds(50,320,130,20);
        panel.add(Mobile_num);
        textmobile_num= new TextField();
        textmobile_num.setBounds(180, 320, 130, 20);
        panel.add(textmobile_num);

        // Next Button
        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE); //to change color of text
        panel.add(next);
        next.addActionListener(this);
        
        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(230,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE); //to change color of text
        cancel.addActionListener(this);
        panel.add(cancel);

        // Panel New Coustomer Ends

        setLayout(new BorderLayout()); // Layout of frame
        add(panel,"Center"); // Add panel to the frame

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/boy.png"));
        Image i2 = i1.getImage().getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imaglabel = new JLabel(i3);
        add(imaglabel,"West");

        setSize(700 , 500);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new New_Coustomer();
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == next)
        {
            String sname = textCoustomername.getText();
            String smeter = textmeter_num.getText();
            String saddress = textaddress.getText();
            String scity = textcity.getText();
            String sstate = textstate.getText();
            String semail = textEmail.getText();
            String smobile = textmobile_num.getText();

             try {
                Database c = new Database();
                // To add data into coustomer table
                String query_customer = "insert into New_Coustomer value('" +sname+"' , '" +smeter+"' , '" +saddress+"' , '" +scity+"' , '" +scity+"' , '" +sstate+"', '" +semail+"' , '"+smobile+"')";
                c.statement.executeUpdate(query_customer);

                // To add data into signup table
               String query_signup = "insert into Signup value('" +smeter+"' , '' , '' , '" +sname+"' , '' , '')";
               c.statement.executeUpdate(query_signup);

                // To show New Customer is added sucessfully
                JOptionPane.showMessageDialog(null, "New Customer Added Sucessfully");
                setVisible(false);
                new Meter_info(smeter);

            } catch (Exception databse_E) 
            {
                databse_E.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }
    
}
