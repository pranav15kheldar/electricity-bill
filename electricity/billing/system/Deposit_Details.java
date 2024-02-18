package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.ColorUIResource;

import net.proteanit.sql.DbUtils;

public class Deposit_Details extends JFrame implements ActionListener {
    Choice search_meter_ch, serch_meter_month_ch;
    JTable table;
    JButton search, Print, Close;

    Deposit_Details() {

        super("Deposit Details");
        getContentPane().setBackground(new ColorUIResource(192, 186, 254));

        JLabel serch_meter_num = new JLabel("Searc by Meter Number");
        serch_meter_num.setBounds(20, 20, 150, 20);

        search_meter_ch = new Choice();
        search_meter_ch.setBounds(180, 20, 120, 30);
        add(serch_meter_num);
        add(search_meter_ch);
        try {
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("SELECT * from bill");
            while (resultSet.next()) {
                search_meter_ch.add(resultSet.getString("meter_num"));
            }
        } catch (Exception e) {

        }

        JLabel serch_meter_name = new JLabel("Search By Month");
        serch_meter_name.setBounds(400, 20, 100, 20);

        serch_meter_month_ch = new Choice();
        serch_meter_month_ch.setBounds(540, 20, 120, 30);
        add(serch_meter_name);
        add(serch_meter_month_ch);
        serch_meter_month_ch.add("January");
        serch_meter_month_ch.add("February");
        serch_meter_month_ch.add("MArch");
        serch_meter_month_ch.add("April");
        serch_meter_month_ch.add("May");
        serch_meter_month_ch.add("June");
        serch_meter_month_ch.add("July");
        serch_meter_month_ch.add("Augest");
        serch_meter_month_ch.add("September");
        serch_meter_month_ch.add("October");
        serch_meter_month_ch.add("November");
        serch_meter_month_ch.add("December");

        // Table
        table = new JTable();
        try {
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("SELECT * from bill");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ScrollPane is used to print table
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 100, 700, 500);
        scroll.setBackground(Color.WHITE);
        add(scroll);

        search = new JButton("Search");
        search.setBackground(Color.WHITE);
        search.setBounds(20, 70, 80, 20);
        add(search);
        search.addActionListener(this);

        Print = new JButton("Print");
        Print.setBackground(Color.WHITE);
        Print.setBounds(120, 70, 80, 20);
        add(Print);
        Print.addActionListener(this);

        Close = new JButton("Close");
        Close.setBackground(Color.WHITE);
        Close.setBounds(600, 70, 80, 20);
        add(Close);
        Close.addActionListener(this);

        setSize(700, 500);
        setLocation(400, 200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Deposit_Details();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            // Searching Data in data base and print it
            String query_search = "SELECT * from bill WHERE meter_num = '" + search_meter_ch.getSelectedItem()
                    + "' and month = '" + serch_meter_month_ch.getSelectedItem() + "'";
            try {
                Database c = new Database();
                ResultSet resultSet = c.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == Print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
}
