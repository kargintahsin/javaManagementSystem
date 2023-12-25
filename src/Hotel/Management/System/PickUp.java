package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {
    PickUp(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 590);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel PUS = new JLabel("Pick Up Service");
        PUS.setBounds(90, 11, 160, 25);
        PUS.setFont(new Font("Tahoma", Font.BOLD, 20));
        PUS.setForeground(Color.WHITE);
        panel.add(PUS);

        JLabel TOC = new JLabel("Type Of Car");
        TOC.setBounds(32 ,97, 89, 14);
        TOC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        TOC.setForeground(Color.WHITE);
        panel.add(TOC);

        Choice c= new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);

        try {
            conn C =new conn();
            ResultSet resultSet=C.statement.executeQuery("select * from driver");
            while (resultSet.next()){
                c.add(resultSet.getString("carname"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10, 233, 800, 250);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3, 45, 48));
        panel.add(table);

        try {
            conn C =new conn();
            String q = "select * from driver";
            ResultSet resultSet=C.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(24 ,205, 60, 20);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setForeground(Color.WHITE);
        panel.add(name);


        JLabel age = new JLabel("Age");
        age.setBounds(165 ,205, 60, 20);
        age.setFont(new Font("Tahoma", Font.BOLD, 14));
        age.setForeground(Color.WHITE);
        panel.add(age);


        JLabel gender = new JLabel("Gender");
        gender.setBounds(264 ,205, 60, 20);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);


        JLabel company = new JLabel("Company");
        company.setBounds(366 ,205, 80, 20);
        company.setFont(new Font("Tahoma", Font.BOLD, 14));
        company.setForeground(Color.WHITE);
        panel.add(company);

        JLabel available = new JLabel("Available");
        available.setBounds(600 ,205, 60, 20);
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel location = new JLabel("Location");
        location.setBounds(700 ,205, 60, 20);
        location.setFont(new Font("Tahoma", Font.BOLD, 14));
        location.setForeground(Color.WHITE);
        panel.add(location);



        JLabel carName = new JLabel("Car Name");
        carName.setBounds(486 ,205, 70, 20);
        carName.setFont(new Font("Tahoma", Font.BOLD, 14));
        carName.setForeground(Color.WHITE);
        panel.add(carName);

        JButton display = new JButton("Display");
        display.setBounds(200, 500, 120, 30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where carname='"+c.getSelectedItem()+"'";
                try {
                    conn c =new conn();
                    ResultSet resultSet= c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        JButton back = new JButton("Back");
        back.setBounds(420, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setLayout(null);
        setLocation(500, 100);
        setSize(800, 600);
        setVisible(true);

    }

    public static void main(String[] args) {
        new PickUp();

    }
}
