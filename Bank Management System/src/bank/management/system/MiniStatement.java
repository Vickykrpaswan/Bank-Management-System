
package bank.management.system;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;


public class MiniStatement extends JFrame{
    
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(100, 200, 400, 100);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(250, 50, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(100, 100, 300, 100);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(100, 180, 300, 20);
        add(balance);
        
        try {
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin= '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number :"+ rs.getString("card_Number").substring(0, 4)+ "XXXXXXXX" + rs.getString("card_Number").substring(12));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            int bal = 0;
            Conn c = new Conn();
            ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){  // &nbsp use for html, in html we create space using &nbsp;
                mini.setText(mini.getText() +"<html>"+ rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposite")) {
                        bal += Integer.parseInt(rs.getString("amount"));
                    } else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
                balance.setText("Your Balance is :"+ bal);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        setSize(600, 500);
        setLocation(350, 80);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MiniStatement("");
    }
    
}
