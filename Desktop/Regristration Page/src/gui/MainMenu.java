package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame  {

    JButton signUpButton;
    JButton signInButton;

    public MainMenu() {
        setTitle("Main Page");





        signUpButton = new JButton("Registration");
        signUpButton.setBounds(166,200,150,40);
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Registration page = new Registration();
            }
        });


        signInButton = new JButton("Login");
        signInButton.setBounds(466,200,150,40);
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Login page = new Login();
            }
        });




        add(signUpButton);
        add(signInButton);
       setSize(800,800);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }


}