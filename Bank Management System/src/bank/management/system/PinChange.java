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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener {

    JButton Submit, Back;
    JPasswordField npin, repin;
    JLabel Text, PinText, rePinText;
    String pinnumber;

    public PinChange(String Pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);

        Image.setBounds(0, 0, 800, 700);
        add(Image);

        Text = new JLabel("Enter Your New PIN");
        Text.setBounds(200, 220, 300, 30);
        Text.setForeground(Color.WHITE);
        Text.setFont(new Font("System", Font.BOLD, 16));
        Image.add(Text);

        PinText = new JLabel("New PIN");
        PinText.setBounds(140, 280, 300, 30);
        PinText.setForeground(Color.WHITE);
        PinText.setFont(new Font("System", Font.BOLD, 16));
        Image.add(PinText);

        npin = new JPasswordField();
        npin.setFont(new Font("Raleway", Font.BOLD, 25));
        npin.setBounds(260, 280, 180, 30);
        Image.add(npin);

        rePinText = new JLabel("Re-Enter PIN");
        rePinText.setBounds(140, 330, 300, 30);
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 16));
        Image.add(rePinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(260, 330, 180, 30);
        Image.add(repin);

        Submit = new JButton("Submit");
        Submit.setBounds(350, 380, 100, 25);
        //deposite.setForeground(Color.WHITE);
        Submit.addActionListener(this);
        Image.add(Submit);

        Back = new JButton("Back");
        Back.setBounds(350, 414, 100, 25);
        //deposite.setForeground(Color.WHITE);
        Back.addActionListener(this);
        Image.add(Back);

        setSize(800, 700);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Submit) {
            try {
                String newpin = npin.getText();
                String re_pin = repin.getText();

                if (!newpin.equals(re_pin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN Does Not Match");
                    return;
                }
                if (newpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter Your New PIN");
                    return;
                }
                if (re_pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter Your New PIN");
                    return;
                }
                
                Conn conn= new Conn();
                String query1= "update bank set pin= '"+re_pin+"' where pin= '"+pinnumber+"'";
                String query2= "update login set pin= '"+re_pin+"' where pin= '"+pinnumber+"'";
                String query3= "update signupthree set pin= '"+re_pin+"' where pin= '"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transections(re_pin).setVisible(true);

            } catch (Exception e) {
                System.out.println("e");
            }
        }else{
            setVisible(false);
            new Transections(pinnumber).setVisible(true);
        } 
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
