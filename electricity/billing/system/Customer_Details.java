package electricity.billing.system;

import javax.swing.JFrame;

public class Customer_Details extends JFrame {
    Customer_Details() {
        super("Customer Details");
        setSize(700, 500);
        setLocation(400, 200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Customer_Details();
    }
}
