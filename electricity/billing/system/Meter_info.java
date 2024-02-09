package electricity.billing.system;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

public class Meter_info extends JFrame implements ActionListener
{
    JLabel heading , meter_num , meterType , phaseCode , Billtype , btime , note, note2,textmeter_num;
    Choice chmeterType , chphaseCode , chbillType ,chmeterLOC;
    JButton Submit;
    String meterNumber;
    Meter_info(String meterNumber )
    {
        super("Meter Information");
        this.meterNumber = meterNumber;

        // Panel New Coustomer Start
        // Use to create pannel 
        JPanel panel = new JPanel();
        panel.setLayout(null); 
        add(panel);// add panel to frame
        panel.setBackground(new ColorUIResource(252,186,3));  //Set the color of panel

        heading = new JLabel("Meter Information"); 
        heading.setBounds(180,10,200,20);
        panel.add(heading);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));

        meter_num = new JLabel("Meter Number:");
        meter_num.setBounds(50,80,130,20);
        panel.add(meter_num);
        textmeter_num= new JLabel(meterNumber);
        textmeter_num.setBounds(180, 80, 130, 20);
        panel.add(textmeter_num);

        meter_num = new JLabel("Meter Number:");
        meter_num.setBounds(50,120,130,20);
        panel.add(meter_num);
        chmeterLOC = new Choice();
        chmeterLOC.setBounds(180,120,150,20);
        chmeterLOC.add("Outside");
        chmeterLOC.add("Inside");
        add(chmeterLOC);

        meterType = new JLabel("Meter Type:");
        meterType.setBounds(50,160,130,20);
        panel.add(meterType);
        chmeterType = new Choice();
        chmeterType.setBounds(180,160,130,20);
        chmeterType.add("Electric Meter");
        chmeterType.add("Solar Meter");
        chmeterType.add("Smater Meter");
        panel.add(chmeterType);

        phaseCode = new JLabel("Phase Code:");
        phaseCode.setBounds(50,200,130,20);
        panel.add(phaseCode);
        chphaseCode = new Choice();
        chphaseCode.setBounds(180,200,130,20);
        chphaseCode.add("011");
        chphaseCode.add("022");
        chphaseCode.add("033");
        chphaseCode.add("044");
        chphaseCode.add("055");
        chphaseCode.add("066");
        chphaseCode.add("077");
        chphaseCode.add("088");
        chphaseCode.add("099");
        panel.add(chphaseCode);

        Billtype = new JLabel("Bill Type:");
        Billtype.setBounds(50,240,130,20);
        panel.add(Billtype);
        chbillType = new Choice();
        chbillType.setBounds(180,240,130,20);
        chbillType.add("Normal");
        chbillType.add("Industrial");
        panel.add(chbillType);

        btime = new JLabel("30 Days Billing Time...");
        btime.setBounds(50,280,130,20);
        panel.add(btime);

        note = new JLabel("Note:-");
        note.setBounds(50,320,130,20);
        panel.add(note);

        note2 = new JLabel("By default Bill is calculated for 30 Days");
        note2.setBounds(50,340,250,20);
        panel.add(note2);
        
        // Submit BUtton
        Submit = new JButton("Submit");
        Submit.setBounds(230,380,100,25);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE); //to change color of text
        panel.add(Submit);
        Submit.addActionListener(this);

        // Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.png"));
        Image i2 = i1.getImage().getScaledInstance(230, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imaglabel = new JLabel(i3);
       

        setLayout(new BorderLayout()); // Layout of frame
        add(panel,"Center"); // add panel to frame
        add(imaglabel,"East"); // Add image to frame
        setSize(700 , 500);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Meter_info("");
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == Submit) 
        {
            String smeternumber = meterNumber;
            String smetreloc = chmeterLOC.getSelectedItem();
            String smeterType = chmeterType.getSelectedItem();
            String sphaseCode = chphaseCode.getSelectedItem();
            String sbilltype = chbillType.getSelectedItem();
            String sday = "30";

            String query_meterInfo = "insert into meter_info values('"+smeternumber+"' , '"+smetreloc+"' , '"+smeterType+"' , '"+sphaseCode+"' , '"+sbilltype+"' '"+sday+"')";

            try 
            {
               Database c = new Database();
               c.statement.executeUpdate(query_meterInfo);
               JOptionPane.showMessageDialog(null,"Information Submit Sucessfully");
               setVisible(false);
            } catch (Exception E) 
            {
                
            }

        }
        else
        {
            setVisible(false);
        }
    }
}
