
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


public class Transections extends JFrame implements ActionListener{
    
    JButton deposite, fastcash, ministatement, balance, withdraw, pinchange, exit;
    String pinnumber;

    public Transections(String pinnumber) {
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(0,0,800,700);
        add(Image);
        
        
        JLabel Text = new JLabel("Please Select Your Transection");
        Text.setBounds(175, 220, 300, 30);
        Text.setForeground(Color.WHITE);
        Text.setFont(new Font("System", Font.BOLD,16));
        Image.add(Text);
        
        deposite = new JButton("DEPOSITE");
        deposite.setBounds(135, 330, 150, 25);
        //deposite.setForeground(Color.WHITE);
        deposite.addActionListener(this);
        Image.add(deposite);
        
        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(308, 330, 150, 25);
        //deposite.setForeground(Color.WHITE);
        withdraw.addActionListener(this);
        Image.add(withdraw);
        
        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(135, 358, 150, 25);
        //deposite.setForeground(Color.WHITE);
        fastcash.addActionListener(this);
        Image.add(fastcash);
        
        ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(308, 358, 150, 25);
        //deposite.setForeground(Color.WHITE);
        ministatement.addActionListener(this);
        Image.add(ministatement);
        
        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(135, 386, 150, 25);
        //deposite.setForeground(Color.WHITE);
        pinchange.addActionListener(this);
        Image.add(pinchange);
        
        balance = new JButton("BALANCE ENQUIRY");
        balance.setBounds(308, 386, 150, 25);
        //deposite.setForeground(Color.WHITE);
        balance.addActionListener(this);
        Image.add(balance);
        
        exit = new JButton("EXIT");
        exit.setBounds(308, 414, 150, 25);
        //deposite.setForeground(Color.WHITE);
        exit.addActionListener(this);
        Image.add(exit);
        
        setSize(800,700);
        setLocation(350,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }else if(ae.getSource()== deposite){
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        }else if(ae.getSource()== withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()== pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource() == balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transections("");
    }
}
