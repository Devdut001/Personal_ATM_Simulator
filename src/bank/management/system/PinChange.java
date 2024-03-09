package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
        JTextField tnewPin, trePin;
        JButton change, back;
        String pinnumber;
    
    PinChange(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900,900);
        add(image);
        
        
        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.white);
        text.setFont(new Font("system", Font.BOLD, 16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
        
        JLabel newPin = new JLabel("Enter New Pin:");
        newPin.setForeground(Color.white);
        newPin.setFont(new Font("system", Font.BOLD, 16));
        newPin.setBounds(165,320,180,35);
        image.add(newPin);
        
        tnewPin = new JTextField();
        tnewPin.setFont(new Font("system", Font.BOLD, 16));
        tnewPin.setBounds(330,320,180,25);
        image.add(tnewPin);
        
        
        JLabel rePin = new JLabel("Re-Enter New Pin:");
        rePin.setForeground(Color.white);
        rePin.setFont(new Font("system", Font.BOLD, 16));
        rePin.setBounds(165,360,180,35);
        image.add(rePin);
        
        trePin = new JTextField();
        trePin.setFont(new Font("system", Font.BOLD, 16));
        trePin.setBounds(330,360,180,25);
        image.add(trePin);
        
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        image.add(change);
        change.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);   
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change){
           try { 
                String npin = tnewPin.getText();
                String rpin = trePin.getText();
                
                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                } else if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                } else if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                } else {
                    Conn conn = new Conn();
                    String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                    String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                    String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "PIN changed successfully.");
                    
                }
            } catch (Exception e){
                System.out.println(e);
            }
        } else {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
    }
    
    public static void main(String args[]){
        new PinChange("");
    }
    
}
