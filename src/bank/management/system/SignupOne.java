package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, others, married, unmarried, other;
    JDateChooser dateChooser;
    

    SignupOne() {
        
        setLayout(null);
        
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random );
        formno.setFont(new Font("raleway", Font.BOLD, 35));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details" );
        personalDetails.setFont(new Font("raleway", Font.BOLD, 25));
        personalDetails.setBounds(250, 80, 400, 30);
        add(personalDetails);
        
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("raleway", Font.BOLD,20));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("raleway", Font.BOLD,20));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.green);
        add(dateChooser);
        
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);
        
        others = new JRadioButton("Others");
        others.setBounds(600,290,120,30);
        others.setBackground(Color.white);
        add(others);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);
        
        
        JLabel email = new JLabel("E-Mail:");
        email.setFont(new Font("raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("raleway", Font.BOLD,20));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,120,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,120,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other = new JRadioButton("Others");
        other.setBounds(600,390,120,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup marriedgroup = new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(unmarried);
        marriedgroup.add(other);
        
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("raleway", Font.BOLD,20));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("raleway", Font.BOLD,20));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("raleway", Font.BOLD,20));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("raleway", Font.BOLD,20));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);
        
        
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
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        } else if (others.isSelected()){
            gender = "Others";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()){
            marital = "Female";
        } else if (other.isSelected()){
            marital = "Others";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        
        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String args[]){

        new SignupOne();
    }
}