
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.ResultSet;
import javax.swing.JOptionPane; 

public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text= new JLabel("Welcome To ATM");
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno= new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);
        
        cardTextField= new JTextField();
        cardTextField.setBounds(300, 160, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin= new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 400, 40);
        add(pin);
        
        pinTextField= new JPasswordField();
        pinTextField.setBounds(300, 230, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login= new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        add(login);
        
        clear= new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(450, 300, 100, 30);
        clear.addActionListener(this);
        add(clear);
        
        signup= new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300, 350, 250, 30);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query= "select * from login where card_Number = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            
            try {
                ResultSet rs= conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transections(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number Or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        else if(ae.getSource() == signup){
            
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String[] args)
    {
        new Login();
    }
}
