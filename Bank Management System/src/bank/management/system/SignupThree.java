
package bank.management.system;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;

    public SignupThree(String formno) {
        this.formno=formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(250, 30, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100, 100, 200, 40);
        add(type);
        
        r1= new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 150 , 150, 20);
        add(r1);
        
        r2= new JRadioButton("Fixed Deposite");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 150 , 150, 20);
        add(r2);
        
        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 180 , 200, 20);
        add(r3);
        
        r4= new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 180 , 200, 20);
        add(r4);
       
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100, 220, 200, 40);
        add(card);
        
        JLabel carddetail = new JLabel("16 Digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100, 255, 300, 20);
        add(carddetail);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-1234");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330, 220, 300, 40);
        add(number);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100, 280, 200, 40);
        add(pin);
        
        JLabel pindetail = new JLabel("4 Digit PIN Number");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100, 320, 300, 20);
        add(pindetail);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330, 280, 300, 40);
        add(pnumber);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100, 350, 200, 40);
        add(services);
        
        c1= new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBounds(100, 400, 200, 30);
        add(c1);
        
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBounds(350, 400, 200, 30);
        add(c2);
        
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBounds(100, 450, 200, 30);
        add(c3);
        
        c4= new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBounds(350, 450, 200, 30);
        add(c4);
        
        c5= new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBounds(100, 500, 200, 30);
        add(c5);
        
        c6= new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBounds(350, 500, 200, 30);
        add(c6);
        
        c7= new JCheckBox("I heredby decleare that the above imfomation is given by me.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBounds(100, 550, 400, 20);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.setBounds(100, 600, 200, 20);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(350, 600, 200, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(700,850);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String accountType= null;
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposite";
            }else if(r3.isSelected()){
                accountType="Current Account";
            }else if(r4.isSelected()){
                accountType="Recurring Account";
            }
            
            Random random= new Random();
            String cardnumber = ""+Math.abs((int) (random.nextLong() % 90000000L)+5040936000000000L);
            String pinnumber = ""+Math.abs((int) (random.nextLong() % 9000L)+1000L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility +"ATM Card";
            }else if(c2.isSelected()){
                facility = facility +"Internet Banking";
            }else if(c3.isSelected()){
                facility = facility +"Mobile Banking";
            }else if(c3.isSelected()){
                facility = facility +"Email & SMS Alerts";
            }else if(c4.isSelected()){
                facility = facility +"Check Book";
            }else if(c5.isSelected()){
                facility = facility +"E-Statement";
            }
            
            try {
                if(accountType.equals(null))
                {
                    JOptionPane.showMessageDialog(null, "Account Type is Requred");
                }
                
                else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "CardNumber : "+ cardnumber + "\n PIN: "+ pinnumber);
                    
                    setVisible(false);
                    new Deposite(pinnumber).setVisible(true);
                }
                
            } catch (Exception e) {
                System.out.println("e");
            }
            
            
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new SignupThree("");
    }
}
