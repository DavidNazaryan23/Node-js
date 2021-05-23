package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import appLogic.*;
import exceptions.*;

class Registration
        extends JFrame
   {

    private Container c;
    private JLabel title;
    private JLabel fullName;
    private JTextField fullNameText;
    private JLabel username;
    private JTextField usernameText;
    private JLabel email;
    private JTextField emailText;
    private JButton signUp;
    private JButton reset;
    private JLabel password;
    private JTextField passwordText;
    private JLabel resultText;


    public Registration()
    {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        fullName = new JLabel("Name");
        fullName.setFont(new Font("Arial", Font.PLAIN, 20));
        fullName.setSize(100, 20);
        fullName.setLocation(250, 100);
        c.add(fullName);

        fullNameText = new JTextField();
        fullNameText.setFont(new Font("Arial", Font.PLAIN, 15));
        fullNameText.setSize(190, 20);
        fullNameText.setLocation(350, 100);
        c.add(fullNameText);

        username = new JLabel("Username");
        username.setFont(new Font("Arial", Font.PLAIN, 20));
        username.setSize(100, 20);
        username.setLocation(250, 150);
        c.add(username);

        usernameText = new JTextField();
        usernameText.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameText.setSize(190, 20);
        usernameText.setLocation(350, 150);
        c.add(usernameText);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(250, 200);
        c.add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Arial", Font.PLAIN, 15));
        emailText.setSize(190, 20);
        emailText.setLocation(350, 200);
        c.add(emailText);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(250, 250);
        c.add(password);

        passwordText = new JTextField();
        passwordText.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordText.setSize(190, 20);
        passwordText.setLocation(350, 250);
        c.add(passwordText);


        resultText = new JLabel();
        resultText.setFont(new Font("Arial", Font.PLAIN, 25));
        resultText.setSize(350, 30);
        resultText.setLocation(350, 300);
        c.add(resultText);





        signUp = new JButton("Submit");
        signUp.setFont(new Font("Arial", Font.PLAIN, 15));
        signUp.setSize(100, 20);
        signUp.setLocation(300, 350);


        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameText.getText();
                String username = usernameText.getText();
                String email = emailText.getText();
                String password = passwordText.getText();

                try {

                    Authorization.registerUser(fullName,email,username,password);

                    resultText.setForeground(Color.GREEN);
                    resultText.setText("User Created Successfully");





                } catch (InvalidNameException | InvalidEmailException | InvalidUsernameException | InvalidPasswordException | ExistingUserException exception ){
                    resultText.setForeground(Color.RED);
                    resultText.setText(exception.getMessage());
                }




            }
        });

        c.add(signUp);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(420, 350);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fullNameText.setText(null);
                usernameText.setText(null);
                emailText.setText(null);
                passwordText.setText(null);
                resultText.setText(null);
            }
        });


        c.add(reset);





        setVisible(true);
    }




}