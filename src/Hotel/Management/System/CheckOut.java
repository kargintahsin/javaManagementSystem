package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

public class CheckOut extends JFrame {

    CheckOut() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 100, 30);
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel roomNum = new JLabel("Room Number:");
        roomNum.setBounds(30, 130, 150, 30);
        roomNum.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNum.setForeground(Color.WHITE);
        panel.add(roomNum);

        JLabel labelroomNum = new JLabel();
        labelroomNum.setBounds(200, 130, 100, 30);
        labelroomNum.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelroomNum.setForeground(Color.WHITE);
        panel.add(labelroomNum);

        Choice customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        panel.add(customer);

        JLabel userID = new JLabel("Customer ID:");
        userID.setBounds(30, 80, 100, 30);
        userID.setFont(new Font("Tahoma", Font.BOLD, 14));
        userID.setForeground(Color.WHITE);
        panel.add(userID);

        JLabel checkintime = new JLabel("Check-In Time:");
        checkintime.setBounds(30, 180, 150, 30);
        checkintime.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkintime.setForeground(Color.WHITE);
        panel.add(checkintime);

        JLabel labelcheckintime = new JLabel();
        labelcheckintime.setBounds(200, 180, 300, 30);
        labelcheckintime.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelcheckintime.setForeground(Color.WHITE);
        panel.add(labelcheckintime);


        JLabel checkouttime = new JLabel("Check-Out Time:");
        checkouttime.setBounds(30, 230, 150, 30);
        checkouttime.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkouttime.setForeground(Color.WHITE);
        panel.add(checkouttime);

        Date date = new Date();

        JLabel labelcheckouttime = new JLabel("" + date);
        labelcheckouttime.setBounds(200, 230, 300, 30);
        labelcheckouttime.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelcheckouttime.setForeground(Color.WHITE);
        panel.add(labelcheckouttime);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");
            while (resultSet.next()) {
                customer.add(resultSet.getString("number"));
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

        JButton checkOut = new JButton("Check-Out");
        checkOut.setBounds(30, 300, 120, 30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn cv = new conn();
                    cv.statement.executeUpdate("delete from customer where number ='" + customer.getSelectedItem() + "'");
                    cv.statement.executeUpdate("update room set availability ='Available' where roomnumber='" + labelroomNum.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }

            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300, 300, 120, 30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from customer where number='" + customer.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        labelroomNum.setText(resultSet.getString("room"));
                        labelcheckintime.setText(resultSet.getString("checkintime"));
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170, 300, 120, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLayout(null);
        setLocation(500, 210);
        setSize(800, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
