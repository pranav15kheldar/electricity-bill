package electricity.billing.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class view_information extends JFrame {
    view_information() {
        super("View Infromation");

        // JLabel heading = new JLabel("View Information");
        // heading.setBounds(250, 0, 500, 40);
        // heading.setFont(new Font("serif", Font.BOLD, 20));
        // add(heading);

        setBounds(350, 150, 850, 650);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel heading = new JLabel("View Customer Information");
        heading.setBounds(250, 0, 500, 40);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(70, 80, 100, 20);
        add(name);

        JLabel nametext = new JLabel("");
        nametext.setBounds(200, 80, 100, 20);
        add(nametext);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(70, 140, 100, 20);
        add(meterNo);

        JLabel meterNotext = new JLabel("");
        meterNotext.setBounds(200, 140, 100, 20);
        add(meterNotext);

        JLabel address = new JLabel("Address");
        address.setBounds(70, 200, 100, 20);
        add(address);

        JLabel addressText = new JLabel("");
        addressText.setBounds(200, 200, 150, 20);
        add(addressText);

        JLabel city = new JLabel("City");
        city.setBounds(70, 260, 150, 20);
        add(city);

        JLabel citytext = new JLabel("");
        citytext.setBounds(200, 260, 150, 20);
        add(citytext);

        JLabel state = new JLabel("State");
        state.setBounds(500, 80, 150, 20);
        add(state);

        JLabel statetext = new JLabel("");
        statetext.setBounds(600, 80, 150, 20);
        add(statetext);

    }

    public static void main(String[] args) {
        new view_information();
    }
}
