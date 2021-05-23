package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import appLogic.*;
import exceptions.*;

class Login
        extends JFrame
{

    private Container c;
    private JLabel title;
    private JLabel email;
    private JTextField emailText;
    private JButton signIn;
    private JButton reset;
    private JLabel password;
    private JTextField passwordText;
    private JLabel resultText;


    public Login()
    {
        setTitle("Login Form");
        setBounds(300, 90, 900, 600);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Login Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 100);
        c.add(title);


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





        signIn = new JButton("Submit");
        signIn.setFont(new Font("Arial", Font.PLAIN, 15));
        signIn.setSize(100, 20);
        signIn.setLocation(300, 350);


        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = emailText.getText();
                String password = passwordText.getText();

                try {

                    Authorization.logIn(email,password);

                    resultText.setForeground(Color.GREEN);
                    resultText.setText("Logged In Successfully");





                } catch (InvalidPasswordException | NoSuchUserException exception ){

                    resultText.setForeground(Color.RED);
                    resultText.setText(exception.getMessage());

                }




            }
        });

        c.add(signIn);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(420, 350);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                emailText.setText(null);
                passwordText.setText(null);
                resultText.setText(null);
            }
        });


        c.add(reset);





        setVisible(true);
    }




}