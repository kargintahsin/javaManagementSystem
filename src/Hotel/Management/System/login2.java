package Hotel.Management.System;

import javax.swing.*;
import javax.xml.stream.FactoryConfigurationError;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login2 extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1, b2;

    login2(){
        JLabel label1 = new JLabel("Username");
        label1.setBounds(40, 20, 100, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        add(label1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40, 70, 100, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        add(label2);

        textField1 = new JTextField();
        textField1.setBounds(150, 20, 150, 30);
        textField1.setForeground(Color.WHITE);
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField1.setBackground(new Color(26, 104, 110));
        add(textField1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150, 70, 150, 30);
        passwordField1.setForeground(Color.WHITE);
        passwordField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordField1.setBackground(new Color(26, 104, 110));
        add(passwordField1);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(255, 300, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(350, -30, 255, 300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(150, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(150, 200, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(3, 45, 48)); //giriş ekranı arka plan rengi
        setLayout(null);
        setLocation(400, 270);
        setSize(600, 300);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String user = textField1.getText();
                String password = passwordField1.getText();
                String q = "select*from login2 where user_name='" + user + "'and password = '" + password + "'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next()) {
                    new admin();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login2();
    }
}