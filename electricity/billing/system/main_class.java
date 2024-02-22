package electricity.billing.system;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class main_class extends JFrame implements ActionListener {
    String usernameAcctype;

    main_class(String susernameAcctype) {
        this.usernameAcctype = susernameAcctype;
        // Shortcut to set visiblity
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Get Frame of size of our screen

        // Setting Image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530, 830, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imagLabel = new JLabel(imageIcon2);
        add(imagLabel);

        // Creating Menu bar
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar); // To add menu bar to frame

        // Adding Componets to menu bar named as Menu
        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif", Font.PLAIN, 15));// To set font of text

        // Add sub comopent to menu bar with image
        // New Coustomer
        JMenuItem newCoustomer = new JMenuItem("New Coustomer");
        newCoustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon coutomerImage = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.png"));
        Image coustmerimg = coutomerImage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newCoustomer.setIcon(new ImageIcon(coustmerimg));
        menu.add(newCoustomer);

        // Coustomer Detail
        JMenuItem Coustomerdetail = new JMenuItem("Deposit Details");
        Coustomerdetail.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon detailsImage = new ImageIcon(ClassLoader.getSystemResource("icons/customerDetails.png"));
        Image detailimg = detailsImage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Coustomerdetail.setIcon(new ImageIcon(detailimg));
        menu.add(Coustomerdetail);
        // Deposit details
        JMenuItem depositdetails = new JMenuItem("Coustomer Details");
        depositdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon detailsdeposit = new ImageIcon(ClassLoader.getSystemResource("icons/depositdetails.png"));
        Image detaildepositimg = detailsdeposit.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(detaildepositimg));
        menu.add(depositdetails);
        // Calculate Bills
        JMenuItem Calculatebill = new JMenuItem("Calculate Bill");
        Calculatebill.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon CalculatebillIamge = new ImageIcon(ClassLoader.getSystemResource("icons/calculatorbills.png"));
        Image Calculatebillimg = CalculatebillIamge.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Calculatebill.setIcon(new ImageIcon(Calculatebillimg));
        menu.add(Calculatebill);

        // Addong New tab to menu bar named as Information
        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif", Font.PLAIN, 15));

        // Adding componets to INformation tab
        // Update information
        JMenuItem upinfo = new JMenuItem("Update Information");
        upinfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon upinfoimage = new ImageIcon(ClassLoader.getSystemResource("icons/refresh.png"));
        Image upinfoimg = upinfoimage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        upinfo.setIcon(new ImageIcon(upinfoimg));
        info.add(upinfo);
        // View Information
        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon viewinfoImage = new ImageIcon(ClassLoader.getSystemResource("icons/information.png"));
        Image viewinfoimg = viewinfoImage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(viewinfoimg));
        info.add(viewinfo);

        // Addong New tab to menu bar named as User
        JMenu user = new JMenu("User");
        user.setFont(new Font("serif", Font.PLAIN, 15));
        menubar.add(user);
        // Adding componets to USER tab
        JMenuItem paybill = new JMenuItem("Paybill");
        paybill.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon paybillimage = new ImageIcon(ClassLoader.getSystemResource("icons/pay.png"));
        Image paybillimg = paybillimage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybillimg));
        user.add(paybill);
        // Bill details
        JMenuItem billdetails = new JMenuItem("Bill Detalis");
        billdetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon billdetailsimage = new ImageIcon(ClassLoader.getSystemResource("icons/details.png"));
        Image billdetailsimg = billdetailsimage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsimg));
        user.add(billdetails);

        // Adding New tab to menu bar named as Bill
        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("serif", Font.PLAIN, 15));

        // Generate bill
        JMenuItem genBill = new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon genbillimage = new ImageIcon(ClassLoader.getSystemResource("icons/bill.png"));
        Image genbillimg = genbillimage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        genBill.setIcon(new ImageIcon(genbillimg));
        bill.add(genBill);

        // Adding new tab to menu bar named as utility
        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("serif", Font.PLAIN, 15));

        // Adding Componets to utility tab
        // Note Pad
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon notepadimage = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image notepadimg = notepadimage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadimg));
        utility.add(notepad);
        // Bill Calculator
        JMenuItem Billcalculator = new JMenuItem("Calculator");
        Billcalculator.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon Billcalculatorimage = new ImageIcon(ClassLoader.getSystemResource("icons/calculatorbills.png"));
        Image Billcalculatorimg = Billcalculatorimage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Billcalculator.setIcon(new ImageIcon(Billcalculatorimg));
        // Billcalculator.setBackground(new Color()); to change background color using
        // RGB Value
        utility.add(Billcalculator);

        // Adding New Tab to menu bar as Exit
        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif", Font.PLAIN, 15));

        // Adding Componets to utility tab
        // Note Pad
        JMenuItem eexit = new JMenuItem("Exit");
        eexit.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon eexitimage = new ImageIcon(ClassLoader.getSystemResource("icons/exit.png"));
        Image eexitimg = eexitimage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitimg));
        exit.add(eexit);

        if (usernameAcctype.equals("Admin")) {
            menubar.add(menu); // Add tab to menu bar
        } else {
            menubar.add(info);
            menubar.add(bill);
            menubar.add(utility);
            menubar.add(exit);
        }

        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new main_class(" ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
