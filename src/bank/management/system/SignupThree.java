package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton rSavings, rCurrent, rRecurring, rFixedDeposit;
    JCheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7;
    String formno;
    JButton submit, cancel;
    
    SignupThree(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("raleway", Font.BOLD, 25));
        accountDetails.setBounds(280, 40, 400, 40);
        add(accountDetails);
        
        
        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("raleway", Font.BOLD, 25));
        accountType.setBounds(100, 140, 200, 30);
        add(accountType);
        
        rSavings = new JRadioButton("Savings Account");
        rSavings.setFont(new Font("raleway", Font.BOLD, 15));
        rSavings.setBackground(Color.white);
        rSavings.setBounds(100, 180, 250, 20);
        add(rSavings);
        
        rCurrent = new JRadioButton("Current Account");
        rCurrent.setFont(new Font("raleway", Font.BOLD, 15));
        rCurrent.setBackground(Color.white);
        rCurrent.setBounds(100, 220, 250, 20);
        add(rCurrent);
        
        rRecurring = new JRadioButton("Recurring Deposit Account");
        rRecurring.setFont(new Font("raleway", Font.BOLD, 15));
        rRecurring.setBackground(Color.white);
        rRecurring.setBounds(350, 180, 250, 20);
        add(rRecurring);
        
        rFixedDeposit = new JRadioButton("Fixed Deposit Account");
        rFixedDeposit.setFont(new Font("raleway", Font.BOLD, 15));
        rFixedDeposit.setBackground(Color.white);
        rFixedDeposit.setBounds(350, 220, 250, 20);
        add(rFixedDeposit);
        
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(rSavings);
        accountgroup.add(rCurrent);
        accountgroup.add(rRecurring);
        accountgroup.add(rFixedDeposit);
        
        JLabel card = new JLabel("CARD NUMBER:");
        card.setFont(new Font("raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 300, 40);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-8795");
        number.setFont(new Font("raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 40);
        add(number);
        
        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);
        
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 300, 40);
        add(pin);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("raleway", Font.BOLD, 22));
        pinNumber.setBounds(330, 370, 300, 40);
        add(pinNumber);
        
        JLabel pinDetail = new JLabel("Your 4 Digit Password");
        pinDetail.setFont(new Font("raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 400, 300, 20);
        add(pinDetail);
        
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 200, 30);
        add(services);
        
        cb1 = new JCheckBox("ATM Card");
        cb1.setBackground(Color.white);
        cb1.setFont(new Font("raleway", Font.BOLD, 15));
        cb1.setBounds(100, 500, 200, 30);
        add(cb1);
        
        cb2 = new JCheckBox("Internet Banking");
        cb2.setBackground(Color.white);
        cb2.setFont(new Font("raleway", Font.BOLD, 15));
        cb2.setBounds(350, 500, 200, 30);
        add(cb2);
        
        cb3 = new JCheckBox("Mobile Banking");
        cb3.setBackground(Color.white);
        cb3.setFont(new Font("raleway", Font.BOLD, 15));
        cb3.setBounds(100, 530, 200, 30);
        add(cb3);
        
        cb4 = new JCheckBox("SMS & Email Alerts");
        cb4.setBackground(Color.white);
        cb4.setFont(new Font("raleway", Font.BOLD, 15));
        cb4.setBounds(350, 530, 200, 30);
        add(cb4);
        
        cb5 = new JCheckBox("Cheque Book");
        cb5.setBackground(Color.white);
        cb5.setFont(new Font("raleway", Font.BOLD, 15));
        cb5.setBounds(100, 560, 200, 30);
        add(cb5);
         
        cb6 = new JCheckBox("E-Statement");
        cb6.setBackground(Color.white);
        cb6.setFont(new Font("raleway", Font.BOLD, 15));
        cb6.setBounds(350, 560, 200, 30);
        add(cb6);
   
        cb7 = new JCheckBox("I hereby declare that above entered details are correct to best of my knowledge");
        cb7.setBackground(Color.white);
        cb7.setFont(new Font("raleway", Font.BOLD, 12));
        cb7.setBounds(100, 600, 600, 30);
        add(cb7);
        
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("raleway", Font.BOLD, 14));
        submit.setBounds(250, 630,100,30);
        submit.addActionListener(this);
        add(submit);
        
        
        cancel = new JButton("Submit");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("raleway", Font.BOLD, 14));
        cancel.setBounds(420, 630,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,700);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== submit){
            String saccountType = null;
            if (rSavings.isSelected()){
                saccountType = "Savings Account";
            } else if (rCurrent.isSelected()){
                saccountType = "Current Account";
            } else if (rRecurring.isSelected()){
                saccountType = "Recurring Deposit Account";
            } else if (rFixedDeposit.isSelected()){
                saccountType = "Fixed Deposit Account";
            }
            
            Random random = new Random();
            String scardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 504093600000000L);
            
            String spinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if (cb1.isSelected()){
                facility = facility + " ATM Card";
            } else if (cb2.isSelected()){
                facility = facility + " Internet Banking";
            } else if (cb3.isSelected()){
                facility = facility + " Mobile Banking";
            } else if (cb4.isSelected()){
                facility = facility + " SMS & Email Alerts";
            } else if (cb5.isSelected()){
                facility = facility + " Cheque Book";
            } else if (cb6.isSelected()){
                facility = facility + " E-Statement";
            }
            
            try {
                if (saccountType.equals("")){
                    JOptionPane.showMessageDialog(null, "account type is required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+saccountType+"', '"+scardnumber+"', '"+spinnumber+"', '"+facility+"' )";
                    String query2 = "insert into login values('"+formno+"', '"+scardnumber+"', '"+spinnumber+"')";
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + scardnumber + "\n Pin: " + spinnumber);
                    
                    
                    setVisible(false);
                    new Deposit(spinnumber).setVisible(true);
                }
            } catch (Exception e){
                System.out.println(e);
            }
            
        } else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    
    public static void main(String args[]){

        new SignupThree("");

    }
    
}


