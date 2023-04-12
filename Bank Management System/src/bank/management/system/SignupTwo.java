package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener {

    
    JTextField panNumber, adharNumber;
    JButton next;
    JRadioButton syes, sno, ayes, ano;
    JComboBox religion, category, income, education, occupation;
    String formno;

    public SignupTwo(String formno) {
        this.formno=formno;
        setLayout(null);
        setTitle("Application Form: Page 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(280, 80, 400, 30);
        add(additionalDetails);

        JLabel rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100, 140, 200, 30);
        add(rel);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Ishai"};
        religion= new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100, 190, 200, 30);
        add(cat);

        String valCategory[]={"General","Obc","Sc","St"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(100, 240, 200, 30);
        add(inc);

        String incomeCategory[]={"null","< 15,0000","< 20,0000","=> 20,0000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);
        
       
        JLabel qualificational = new JLabel("Qualification:");
        qualificational.setFont(new Font("Raleway", Font.BOLD, 20));
        qualificational.setBounds(100, 315, 200, 30);
        add(qualificational);

        String valEducation[]={"Post-Graduate","Graduate","Intermediate","Matriculation","Non"};
        education = new JComboBox(valEducation);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100, 390, 200, 30);
        add(occ);

        String valOccupation[]={"Salaried","Self-Employed","Bussiness","Student","Other"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pan = new JLabel("Pan Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panNumber = new JTextField();
        panNumber.setFont(new Font("Raleway", Font.BOLD, 14));
        panNumber.setBounds(300, 440, 400, 30);
        add(panNumber);

        JLabel adhar = new JLabel("Adhar Number:");
        adhar.setFont(new Font("Raleway", Font.BOLD, 20));
        adhar.setBounds(100, 490, 200, 30);
        add(adhar);

        adharNumber = new JTextField();
        adharNumber.setFont(new Font("Raleway", Font.BOLD, 14));
        adharNumber.setBounds(300, 490, 400, 30);
        add(adharNumber);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorCitizen = new ButtonGroup();
        seniorCitizen.add(syes);
        seniorCitizen.add(sno);
        

        JLabel account = new JLabel("Existing Account:");
        account.setFont(new Font("Raleway", Font.BOLD, 20));
        account.setBounds(100, 590, 200, 30);
        add(account);

        ayes = new JRadioButton("Yes");
        ayes.setBounds(300,590,100,30);
        ayes.setBackground(Color.WHITE);
        add(ayes);
        
        ano = new JRadioButton("No");
        ano.setBounds(450,590,100,30);
        ano.setBackground(Color.WHITE);
        add(ano);
        
        ButtonGroup existingAccount = new ButtonGroup();
        existingAccount.add(ayes);
        existingAccount.add(ano);
        

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setVisible(true);
        setLocation(350, 10);
    }

    public void actionPerformed(ActionEvent ae) {
        
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorCitizen = null;
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorCitizen = "No";
        }
        
        String existingAccount = null;
        if (ayes.isSelected()) {
            existingAccount = "Yes";
        } else if (ano.isSelected()) {
            existingAccount = "No";
        }
        
        String spanNumber = panNumber.getText();
        String sadharNumber = adharNumber.getText();
        
 
        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + spanNumber + "','" + sadharNumber + "','" + seniorCitizen + "','" + existingAccount + "')";
                c.s.executeUpdate(query);
                
                // Signup three object
                setVisible(false);
                new SignupThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
