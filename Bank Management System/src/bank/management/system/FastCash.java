package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton Rs100, Rs500, Rs1000, Rs2000, Rs5000, Rs10000, exit;
    String pinnumber;
    //Connection c;
    //Statement s;

    public FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0, 0, 800, 700);
        add(Image);

        JLabel Text = new JLabel("SELECT YOUR WITHDRAW AMOUNT");
        Text.setBounds(160, 220, 300, 30);
        Text.setForeground(Color.WHITE);
        Text.setFont(new Font("System", Font.BOLD, 16));
        Image.add(Text);

        Rs100 = new JButton("Rs 100");
        Rs100.setBounds(135, 330, 150, 25);
        //deposite.setForeground(Color.WHITE);
        Rs100.addActionListener(this);
        Image.add(Rs100);

        Rs500 = new JButton("Rs 500");
        Rs500.setBounds(308, 330, 150, 25);
        //deposite.setForeground(Color.WHITE);
        Rs500.addActionListener(this);
        Image.add(Rs500);

        Rs1000 = new JButton("Rs 1000");
        Rs1000.setBounds(135, 358, 150, 25);
        //deposite.setForeground(Color.WHITE);
        Rs1000.addActionListener(this);
        Image.add(Rs1000);

        Rs2000 = new JButton("Rs 2000");
        Rs2000.setBounds(308, 358, 150, 25);
        //deposite.setForeground(Color.WHITE);
        Rs2000.addActionListener(this);
        Image.add(Rs2000);

        Rs5000 = new JButton("Rs 5000");
        Rs5000.setBounds(135, 386, 150, 25);
        //deposite.setForeground(Color.WHITE);
        Rs5000.addActionListener(this);
        Image.add(Rs5000);

        Rs10000 = new JButton("Rs 10000");
        Rs10000.setBounds(308, 386, 150, 25);
        //deposite.setForeground(Color.WHITE);
        Rs10000.addActionListener(this);
        Image.add(Rs10000);

        exit = new JButton("Back");
        exit.setBounds(308, 414, 150, 25);
        //deposite.setForeground(Color.WHITE);
        exit.addActionListener(this);
        Image.add(exit);

        setSize(800, 700);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transections(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposite")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }

                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "','" + date + "','withdraw','" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + "Debited Successfully");

                setVisible(false);
                new Transections(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
