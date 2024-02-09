package electricity.billing.system;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class main_class extends JFrame
{
    main_class()
    {
        // Shortcut to set visiblity
        setExtendedState(JFrame.MAXIMIZED_BOTH); //Get Frame of size of our screen

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530, 830, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imagLabel = new JLabel(imageIcon2);
        add(imagLabel);

        //To add Components to menu bar
        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,15));//To set font of text

        

        // Menu Bar
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar); // To add menu bar to frame 
        menubar.add(menu); //Add menu to menu bar
        

        //Add sub comopent to menu bar with image
        JMenuItem newCoustomer = new JMenuItem("New Coustomer");
        newCoustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon coutomerImage = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.png"));
        Image coustmerimg = coutomerImage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newCoustomer.setIcon(new ImageIcon(coustmerimg));
        menu.add(newCoustomer);

        JMenuItem Coustomerdetail = new JMenuItem("Deposit Details");
        Coustomerdetail.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon detailsImage = new ImageIcon(ClassLoader.getSystemResource("icons/customerDetails.png"));
        Image detailimg = detailsImage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Coustomerdetail.setIcon(new ImageIcon(detailimg));
        menu.add(Coustomerdetail);

        JMenuItem depositdetails = new JMenuItem("Coustomer Details");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon detailsdeposit = new ImageIcon(ClassLoader.getSystemResource("icons/depositdetails.png"));
        Image detaildepositimg = detailsdeposit.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(detaildepositimg));
        menu.add(depositdetails);

        JMenuItem Calculatebill = new JMenuItem("Calculate Bill");
        Calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon CalculatebillIamge = new ImageIcon(ClassLoader.getSystemResource("icons/calculatorbills.png"));
        Image  Calculatebillimg =  CalculatebillIamge.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Calculatebill.setIcon(new ImageIcon(Calculatebillimg));
        menu.add(Calculatebill);

        // Addong New tab to menu bar named as Information
        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif",Font.PLAIN,15));
        menubar.add(info);

        // Adding componets to INformation tab
        JMenuItem upinfo = new JMenuItem("Update Information");
        upinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon upinfoimage = new ImageIcon(ClassLoader.getSystemResource("icons/refresh.png"));
        Image upinfoimg = upinfoimage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        upinfo.setIcon(new ImageIcon(upinfoimg));
        info.add(upinfo);

        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon viewinfoImage = new ImageIcon(ClassLoader.getSystemResource("icons/information.png"));
        Image viewinfoimg = viewinfoImage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(viewinfoimg));
        info.add(viewinfo);

        //Addong New tab to menu bar named as  User 
        JMenu user = new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,15));
        menubar.add(user);

        // Adding componets to USER tab
        JMenuItem paybill = new JMenuItem("Paybill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon paybillimage = new ImageIcon(ClassLoader.getSystemResource("icons/pay.png"));
        Image paybillimg = paybillimage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybillimg));
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Detalis");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon billdetailsimage = new ImageIcon(ClassLoader.getSystemResource("icons/details.png"));
        Image billdetailsimg = billdetailsimage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsimg));
        user.add(billdetails);





        setLayout(new FlowLayout());
        setVisible(true);

    }
    public static void main(String[] args) {
        new main_class();
    }
}
