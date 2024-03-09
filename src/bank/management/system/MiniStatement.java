package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class MiniStatement extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton back, exit;
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(350,20,200,30);
        bank.setFont(new Font("raleway", Font.BOLD, 17));
        add(bank);
        
        JLabel mini = new JLabel();
        mini.setBounds(120,100,500,200);
        add(mini);
        
        JLabel card = new JLabel();
        card.setBounds(120,70,300,20);
        add(card);
        
        try{
           Conn conn = new Conn();
           ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
           while(rs.next()){
               card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
           }
        } catch(Exception e){
            System.out.println(e);
        }
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" +rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><html>");
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        exit = new JButton("Exit");
        exit.setBounds(450, 300,100,30);
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        add(exit);
        exit.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(250, 300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);
        
        
        setSize(800,480);
        setLocation(300,100);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
   
    public static void main(String args[]){
        new MiniStatement("");
    }
}
