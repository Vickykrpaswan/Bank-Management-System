package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposite extends JFrame implements ActionListener {

    JTextField amount;
    JButton Deposite, Back;
    String pinnumber;

    Deposite(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0, 0, 800, 700);
        add(Image);

        JLabel Text = new JLabel("Inter Your Amount You Want To Deposite");
        Text.setBounds(153, 220, 300, 30);
        Text.setForeground(Color.WHITE);
        Text.setFont(new Font("System", Font.BOLD, 14));
        Image.add(Text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 16));
        amount.setBounds(158, 250, 280, 30);
        add(amount);

        Deposite = new JButton("Deposite");
        Deposite.setBounds(308, 386, 150, 25);
        //deposite.setForeground(Color.WHITE);
        Deposite.addActionListener(this);
        Image.add(Deposite);

        Back = new JButton("Back");
        Back.setBounds(308, 414, 150, 25);
        //deposite.setForeground(Color.WHITE);
        Back.addActionListener(this);
        Image.add(Back);

        setSize(800, 700);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Deposite) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Inter Your Amount You Want To Deposite");

            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+ pinnumber +"','"+ date +"','Deposite','"+ number +"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposite Success");

                    setVisible(false);
                    new Transections(pinnumber).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        } else if (ae.getSource() == Back) {
            setVisible(false);
            new Transections(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposite("");
    }
}
