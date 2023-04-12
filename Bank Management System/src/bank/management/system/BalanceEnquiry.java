package bank.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton Back;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 600);
        add(image);

        Back = new JButton("Back");
        Back.setBounds(245, 360, 100, 20);
        Back.addActionListener(this);
        image.add(Back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            
            while (rs.next()) {
                if (rs.getString("type").equals("Deposite")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your balance is Rs :"+ balance);
        text.setForeground(Color.WHITE);
        text.setBounds(150, 250, 200, 20);
        image.add(text);

        setSize(600, 630);
        setLocation(350, 80);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transections(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
