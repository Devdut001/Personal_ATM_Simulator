package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    
    JTextField adhaarTextField, panTextField;
    JButton next;
    JRadioButton scitizen1, scitizen2, exaccount1, exaccount2;
    JComboBox religion1, qualification1, category1, income1, occupation1;
    String formno;

    SignupTwo(String formno) {
        
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
       
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("raleway", Font.BOLD, 25));
        additionalDetails.setBounds(250, 80, 400, 30);
        add(additionalDetails);
        
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("raleway", Font.BOLD, 20));
        religion.setBounds(100, 190, 100, 30);
        add(religion);
        
        String valReligion[] = {"Hindu", "Muslim", "Christian", "Sikh", "Jain", "Others"};  
        religion1 = new JComboBox(valReligion);
        religion1.setFont(new Font("raleway", Font.BOLD,20));
        religion1.setBounds(300, 190, 400, 30);
        religion1.setBackground(Color.white);
        add(religion1);
        
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("raleway", Font.BOLD, 20));
        category.setBounds(100, 240, 200, 30);
        add(category);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Others"};  
        category1 = new JComboBox(valCategory);
        category1.setFont(new Font("raleway", Font.BOLD,20));
        category1.setBounds(300, 240, 400, 30);
        category1.setBackground(Color.white);
        add(category1);
        
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("raleway", Font.BOLD, 20));
        income.setBounds(100, 290, 200, 30);
        add(income);
        
        String valIncome[] = {"none", "< 150000", "< 300000", "<500000", "<1000000", ">1000000"};  
        income1 = new JComboBox(valIncome);
        income1.setFont(new Font("raleway", Font.BOLD,20));
        income1.setBounds(300, 290, 400, 30);
        income1.setBackground(Color.white);
        add(income1);
        
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("raleway", Font.BOLD, 20));
        qualification.setBounds(100, 340, 200, 30);
        add(qualification);
        
        String valQualification[] = {"Non-graduate", "Graduate", "Post-graduate", "Doctrate", "Others"};  
        qualification1 = new JComboBox(valQualification);
        qualification1.setFont(new Font("raleway", Font.BOLD,20));
        qualification1.setBounds(300, 340, 400, 30);
        qualification1.setBackground(Color.white);
        add(qualification1);
        
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        
        String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Others"};  
        occupation1 = new JComboBox(valOccupation);
        occupation1.setFont(new Font("raleway", Font.BOLD,20));
        occupation1.setBounds(300, 390, 400, 30);
        occupation1.setBackground(Color.white);
        add(occupation1);
       
        
        JLabel adhaar = new JLabel("Adhaar No:");
        adhaar.setFont(new Font("raleway", Font.BOLD, 20));
        adhaar.setBounds(100, 440, 200, 30);
        add(adhaar);
        
        adhaarTextField = new JTextField();
        adhaarTextField.setFont(new Font("raleway", Font.BOLD,20));
        adhaarTextField.setBounds(300, 440, 400, 30);
        add(adhaarTextField);
        
        
        JLabel scitizen = new JLabel("Senior Citizen:");
        scitizen.setFont(new Font("raleway", Font.BOLD, 20));
        scitizen.setBounds(100, 490, 200, 30);
        add(scitizen);
        
        scitizen1 = new JRadioButton("Yes");
        scitizen1.setBounds(300,490,60,30);
        scitizen1.setBackground(Color.white);
        add(scitizen1);
        
        scitizen2 = new JRadioButton("No");
        scitizen2.setBounds(450,490,120,30);
        scitizen2.setBackground(Color.white);
        add(scitizen2);
        
        ButtonGroup scitizengroup = new ButtonGroup();
        scitizengroup.add(scitizen1);
        scitizengroup.add(scitizen1);
        
        
        JLabel pan = new JLabel("PAN No:");
        pan.setFont(new Font("raleway", Font.BOLD, 20));
        pan.setBounds(100, 540, 200, 30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("raleway", Font.BOLD,20));
        panTextField.setBounds(300, 540, 400, 30);
        add(panTextField);
        
        
        JLabel exaccount = new JLabel("Existing Account:");
        exaccount.setFont(new Font("raleway", Font.BOLD, 20));
        exaccount.setBounds(100, 590, 200, 30);
        add(exaccount);
        
        exaccount1 = new JRadioButton("Yes");
        exaccount1.setBounds(300,590,60,30);
        exaccount1.setBackground(Color.white);
        add(exaccount1);
        
        exaccount2 = new JRadioButton("No");
        exaccount2.setBounds(450,590,120,30);
        exaccount2.setBackground(Color.white);
        add(exaccount2);
        
        ButtonGroup exaccountgroup = new ButtonGroup();
        exaccountgroup.add(exaccount1);
        exaccountgroup.add(exaccount2);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620,630,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String sreligion = (String) religion1.getSelectedItem();
        
        String scategory = (String) category1.getSelectedItem();
        
        String sincome = (String) income1.getSelectedItem();
        
        String squalification = (String) qualification1.getSelectedItem();
        
        String soccupation = (String) occupation1.getSelectedItem();
        
        String sadhaar = adhaarTextField.getText();
        
        String sCitizen = null;
        if(scitizen1.isSelected()) {
            sCitizen = "Yes";
        } else if (scitizen2.isSelected()){
            sCitizen = "No";
        }
        
        String span = panTextField.getText();
        
        String sExaccount = null;
        if(exaccount1.isSelected()) {
            sExaccount = "Yes";
        } else if (exaccount2.isSelected()){
            sExaccount = "No";
        }
        
        
        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+squalification+"', '"+soccupation+"', '"+sadhaar+"', '"+sCitizen+"', '"+span+"', '"+sExaccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String args[]){

        new SignupTwo("");
    }
}