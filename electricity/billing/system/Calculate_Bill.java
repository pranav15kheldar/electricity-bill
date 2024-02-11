package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class Calculate_Bill extends JFrame implements ActionListener
{
    Choice chmeternum,chmonth;
    JLabel textname, textaddress;
    TextField textunitConsumed;
    JButton Submit , Cancel;
    Calculate_Bill()
    {   
        // Created panel 
        // Panel Starts
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new ColorUIResource(214,195,247));
        add(panel); // Add panel to frame

        //  Heading
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(70, 10, 300, 20);
        heading.setFont(new FontUIResource("Tahoma", Font.BOLD, 20)); // Set fontsize and font style of Heading
        panel.add(heading); // added heading to panel 

        //Meter NUmber 
        JLabel meternum = new JLabel("Meter Number");
        meternum.setBounds(50, 80, 100, 20);
        panel.add(meternum);

        chmeternum = new Choice();
        // To extract data from database and show it in Dropdown
        try 
        {
            Database c =new Database();
            ResultSet resultset = c.statement.executeQuery("SELECT * from New_Coustomer");
            while (resultset.next()) 
            {
                chmeternum.add(resultset.getString("meter_no"));
                
            }
        } 
        catch (Exception e) 
        {
            
        }
        chmeternum.setBounds(180, 80, 100, 20);
        panel.add(chmeternum);

        // Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 120, 100, 20);
        panel.add(name);
        textname = new JLabel("");
        textname.setBounds(180, 120,150, 20);
        panel.add(textname);

        // Address
        JLabel address =new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);
        textaddress = new JLabel("");
        textaddress.setBounds(180, 160,150, 20);
        panel.add(textaddress);

        // extract Name and Address from data base according to meter number
        try
        {
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("SELECT * from New_Coustomer where meter_no = '"+chmeternum.getSelectedItem()+"'");
            while (resultSet.next()) 
            {
                textname.setText(resultSet.getString("name"));
                textaddress.setText(resultSet.getString("address"));    
            }
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }
        // To update name and address according to meter number
        chmeternum.addItemListener(new ItemListener() 
        {

            @Override
            public void itemStateChanged(ItemEvent e) 
            {
                try
        {
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("SELECT * from New_Coustomer where meter_no = '"+chmeternum.getSelectedItem()+"'");
            while (resultSet.next()) 
            {
                textname.setText(resultSet.getString("name"));
                textaddress.setText(resultSet.getString("address"));    
            }
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }
            }
            
        });
        // Unit Consumed
        JLabel unitConsumed = new JLabel("Unit Consumed");
        unitConsumed.setBounds(50, 200, 100, 20);
        panel.add(unitConsumed);
        textunitConsumed = new TextField();
        textunitConsumed.setBounds(180, 200, 150, 20);
        panel.add(textunitConsumed);

        // Month
        JLabel month = new JLabel("Month");
        month.setBounds(50, 240, 100, 20);
        panel.add(month);
        chmonth = new Choice();
        chmonth.add("January");
        chmonth.add("February");
        chmonth.add("MArch");
        chmonth.add("April");
        chmonth.add("May");
        chmonth.add("June");
        chmonth.add("July");
        chmonth.add("Augest");
        chmonth.add("September");
        chmonth.add("October");
        chmonth.add("November");
        chmonth.add("December");
        chmonth.setBounds(180, 240, 100, 20);
        panel.add(chmonth);

        // Submit Button
        Submit = new JButton("Submit");
        Submit.setBounds(80, 300, 100, 20);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(this);
        panel.add(Submit);

        // Cancel BUtton
        Cancel = new JButton("Cancel");
        Cancel.setBounds(220, 300, 100, 20);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        panel.add(Cancel);
        // Panel Ends

        // Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/budget.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imaglabel = new JLabel(i3);
        add(imaglabel,"East");

        setSize(650,400);
        setLocation(400, 200);
        setVisible(true);
    }
 public static void main(String[] args) 
 {
    new Calculate_Bill();
 }
@Override
public void actionPerformed(ActionEvent e)
{       
        // Global Declearation
        String smeternum = chmeternum.getSelectedItem();
        String sunit = textunitConsumed.getText();
        String smonth = chmonth.getSelectedItem();
        int totalBill = 0;
    
    if (e.getSource() == Submit) 
    {
        //When Submit button is pressed
        int units = Integer.parseInt(sunit);
        String query_tax = "select * from tax";
        try {
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery(query_tax);
            // Calculation of total bill to paid
            while (resultSet.next()) 
            {
                totalBill += units * Integer.parseInt(resultSet.getString("cost_per_unit"));
                totalBill += Integer.parseInt(resultSet.getString("meter_rent"));    
                totalBill += Integer.parseInt(resultSet.getString("service_charge"));
                totalBill += Integer.parseInt(resultSet.getString("service_tax"));
                totalBill += Integer.parseInt(resultSet.getString("swach_bharat"));
                totalBill += Integer.parseInt(resultSet.getString("fixed_tax"));
                
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
    else
    {
        setVisible(false);
    }
    // Storing data into bill table 
    String query_total_bill = "INSERT into bill values ('"+smeternum+"','"+smonth+"','"+ sunit+"','"+ totalBill+"' , 'Not Paid')";
    try {
        Database c = new Database();
        c.statement.executeUpdate(query_total_bill);
        JOptionPane.showMessageDialog(null,"Customer Bill Update Sucessfully");
    } catch (Exception EE) {
        EE.printStackTrace();
    }
   
}   
}
