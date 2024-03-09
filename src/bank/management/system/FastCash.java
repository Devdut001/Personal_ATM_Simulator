package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, exit;
    String pinnumber;
    
    FastCash(String pinnumber) {
        
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(220, 180,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);
        
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(160, 316,155,30);
        hundred.setFont(new Font("system", Font.BOLD, 16));
        hundred.addActionListener(this);
        image.add(hundred);
        
        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(345, 316,160,30);
        fiveHundred.setFont(new Font("system", Font.BOLD, 16));
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(160, 350,155,30);
        thousand.setFont(new Font("system", Font.BOLD, 16));
        thousand.addActionListener(this);
        image.add(thousand);
        
        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(345, 350,160,30);
        twoThousand.setFont(new Font("system", Font.BOLD, 16));
        twoThousand.addActionListener(this);
        image.add(twoThousand);
        
        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(160, 384,155,30);
        fiveThousand.setFont(new Font("system", Font.BOLD, 16));
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);
        
        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(345, 384,160,30);
        tenThousand.setFont(new Font("system", Font.BOLD, 16));
        tenThousand.addActionListener(this);
        image.add(tenThousand);
        
        exit = new JButton("Back");
        exit.setBounds(345, 418,160,30);
        exit.setFont(new Font("system", Font.BOLD, 16));
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        
        setLocation(300,0);
        setSize(900,900);
        //setUndecorated(true);
        setVisible(true);
        
        
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                        
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                } 
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"' )";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +amount+ " Debited Successfully.");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
        }
        
    }
    
    public static void main (String args[]){
        
        new FastCash("");
    }
    
}
