package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        text.setBounds(190,330,700,35);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("raleway", Font.BOLD, 16));
        amount.setBounds(212,380,250,25);
        add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(400,450,110,28);
        withdraw.setFont(new Font("system", Font.BOLD, 16));
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.black);
        image.add(withdraw);
        withdraw.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(410,486,100,28);
        back.setFont(new Font("system", Font.BOLD, 16));
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        image.add(back);
        back.addActionListener(this);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        //setUndecorated(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == withdraw){
            String swithdraw = amount.getText();
            Date date = new Date();
            if (swithdraw.equals("")){
                JOptionPane.showMessageDialog(null, "please enter the amount");
            } else {
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+swithdraw+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+swithdraw+" Withdrawed successfully.");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
        
    }
    
    public static void main (String args[]){
        
        new Withdrawl("");
        
    }
    
}
