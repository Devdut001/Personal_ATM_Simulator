package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceEnquiry, exit;
    String pinnumber;
    
    Transactions(String pinnumber) {
        
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(220, 180,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);
        
        
        deposit = new JButton("Deposit");
        deposit.setBounds(160, 316,155,30);
        deposit.setFont(new Font("system", Font.BOLD, 16));
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(345, 316,160,30);
        withdrawl.setFont(new Font("system", Font.BOLD, 16));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(160, 350,155,30);
        fastcash.setFont(new Font("system", Font.BOLD, 16));
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(345, 350,160,30);
        ministatement.setFont(new Font("system", Font.BOLD, 16));
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(160, 384,155,30);
        pinchange.setFont(new Font("system", Font.BOLD, 16));
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(345, 384,160,30);
        balanceEnquiry.setFont(new Font("system", Font.BOLD, 16));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(345, 418,160,30);
        exit.setFont(new Font("system", Font.BOLD, 16));
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        
        setLocation(300,0);
        setSize(900,900);
        setVisible(true);
        
        
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main (String args[]){
        
        new Transactions("");
    }
    
}
