package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {
    CustomerInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3, 45, 48));
        panel.add(table);

        try {
            conn c = new conn();
            String Q = "select * from customer";
            ResultSet resultSet=c.statement.executeQuery(Q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel id = new JLabel("ID");
        id.setBounds(31, 11, 46, 14);
        id.setForeground(Color.WHITE);
        id.setBackground(new Color(3, 45, 48));
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id);


        JLabel number = new JLabel("NUMBER");
        number.setBounds(150, 11, 70, 14);
        number.setForeground(Color.WHITE);
        number.setBackground(new Color(3, 45, 48));
        number.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(number);


        JLabel gender = new JLabel("GENDER");
        gender.setBounds(360, 11, 70, 14);
        gender.setForeground(Color.WHITE);
        gender.setBackground(new Color(3, 45, 48));
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);


        JLabel country = new JLabel("COUNTRY");
        country.setBounds(480, 11, 70, 14);
        country.setForeground(Color.WHITE);
        country.setBackground(new Color(3, 45, 48));
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(country);


        JLabel room = new JLabel("ROOM");
        room.setBounds(600, 11, 70, 14);
        room.setForeground(Color.WHITE);
        room.setBackground(new Color(3, 45, 48));
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);


        JLabel deposit = new JLabel("DEPOSIT");
        deposit.setBounds(800, 11, 70, 14);
        deposit.setForeground(Color.WHITE);
        deposit.setBackground(new Color(3, 45, 48));
        deposit.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(deposit);


        JLabel time = new JLabel("CI TIME");
        time.setBounds(690, 11, 70, 14);
        time.setForeground(Color.WHITE);
        time.setBackground(new Color(3, 45, 48));
        time.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(time);




        JLabel name = new JLabel("NAME");
        name.setBounds(270, 11, 46, 14);
        name.setForeground(Color.WHITE);
        name.setBackground(new Color(3, 45, 48));
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);


        JButton back = new JButton("BACK");
        back.setBounds(450, 510, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLayout(null);
        setLocation(500, 100);
        setSize(900, 600);
        setVisible(true);


    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
