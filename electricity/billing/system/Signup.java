package electricity.billing.system;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

// To apply action listener we need to impelent actionlistner to our class

public class Signup extends JFrame implements ActionListener {
    JTextField textmeterNo, textemployid, textusername, textname, textpassword;
    Choice Accountas;
    JButton Create, Back;

    Signup() {
        super("Signup Page");
        // To change color of backgound of whole pannel
        getContentPane().setBackground(new Color(168, 203, 255));

        JLabel title = new JLabel("Create - Account");
        add(title);
        title.setBounds(0, 0, 120, 20);

        // Create Account As
        JLabel createAccountas = new JLabel("Create Account As:");
        add(createAccountas);
        createAccountas.setBounds(30, 50, 120, 20);
        Accountas = new Choice();
        add(Accountas);
        Accountas.setBounds(160, 50, 120, 20);
        Accountas.add("Admin");
        Accountas.add("Coustomer");

        // Meter Number
        JLabel meterNo = new JLabel("Meter Number");
        add(meterNo);
        meterNo.setBounds(30, 100, 125, 20);
        meterNo.setVisible(false);
        textmeterNo = new JTextField();
        add(textmeterNo);
        textmeterNo.setVisible(false);
        textmeterNo.setBounds(160, 100, 125, 20);

        // Employer ID
        JLabel employeid = new JLabel("Employer id:");
        add(employeid);
        employeid.setBounds(30, 100, 125, 20);
        employeid.setVisible(true);
        textemployid = new JTextField();
        add(textemployid);
        textemployid.setVisible(true);
        textemployid.setBounds(160, 100, 125, 20);

        // Username
        JLabel username = new JLabel("Username:");
        add(username);
        username.setBounds(30, 140, 125, 20);
        textusername = new JTextField();
        add(textusername);
        textusername.setBounds(160, 140, 125, 20);

        // Name
        JLabel name = new JLabel("Name");
        add(name);
        name.setBounds(30, 180, 125, 20);
        textname = new JTextField("");
        add(textname);
        textname.setBounds(160, 180, 125, 20);

        // To get name according to meter number
        textmeterNo.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Database c = new Database();
                    ResultSet resultSet = c.statement
                            .executeQuery("SELECT * from Signup where meter_no = '" + textmeterNo.getText() + "'");
                    if (resultSet.next()) {
                        textname.setText(resultSet.getString("name"));
                    }
                } catch (Exception E) {

                }
            }

        });

        // Password
        JLabel passWord = new JLabel("Password");
        add(passWord);
        passWord.setBounds(30, 220, 125, 20);
        textpassword = new JTextField();
        add(textpassword);
        textpassword.setBounds(160, 220, 125, 20);

        // Item listener to select wether it is admin or it is coustomer.
        Accountas.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                String userchoice = Accountas.getSelectedItem();
                if (userchoice.equals("Coustomer")) {
                    employeid.setVisible(false);
                    textemployid.setVisible(false);
                    meterNo.setVisible(true);
                    textmeterNo.setVisible(true);

                } else {
                    employeid.setVisible(true);
                    textemployid.setVisible(true);
                    meterNo.setVisible(false);
                    textmeterNo.setVisible(false);
                }
            }

        });

        // Create Button
        Create = new JButton("Create");
        Create.setBounds(40, 285, 100, 25);
        add(Create);
        Create.setBackground(new Color(66, 127, 219)); // TO change backgound color of button
        Create.setForeground(Color.WHITE);// TO change color of text of button
        Create.addActionListener(this); // to know wether button is click or not

        // Back Button
        Back = new JButton("Back");
        Back.setBounds(180, 285, 100, 25);
        add(Back);
        Back.setBackground(new Color(66, 127, 219)); // TO change backgound color of button
        Back.setForeground(Color.WHITE);// TO change color of text of button
        Back.addActionListener(this);// to know wether button is click or not

        // Image used for signup
        ImageIcon signupImg = new ImageIcon(ClassLoader.getSystemResource("icons\\sign-up.png"));
        Image singupImg_2 = signupImg.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(singupImg_2);
        JLabel profileLabel = new JLabel(fprofileOne);
        add(profileLabel);
        profileLabel.setBounds(350, 40, 250, 250);

        setLayout(null); // to remove default layout i.e border laypout from our frame
        setSize(640, 400);
        setLocation(500, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Create) // getSoucre returns on which button event is performed
        {
            String sAccountas = Accountas.getSelectedItem();
            String susername = textusername.getText();
            String Sname = textname.getText();
            String Spassword = textpassword.getText();
            String Smeter = textmeterNo.getText();

            try {
                Database c = new Database();
                String query = null;
                query = "insert into Signup value('" + Smeter + "' , '" + susername + "' , '" + Sname + "' , '"
                        + Spassword + "' , '" + sAccountas + "')";
                c.statement.executeUpdate(query);

                // To show account is cerated
                JOptionPane.showMessageDialog(null, "Account Created");
                setVisible(false);
                new Login();

            } catch (Exception databse_E) {
                databse_E.printStackTrace();
            }
        } else if (e.getSource() == Back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
