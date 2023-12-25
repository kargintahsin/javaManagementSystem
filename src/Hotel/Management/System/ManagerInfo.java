package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame {
    ManagerInfo(){
        JPanel panel=new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,990,590);
        panel.setLayout(null);
        add(panel);

        JTable table =new JTable();
        table.setBackground(new Color(3,45,48));
        table.setBounds(10,34,980,450);
        table.setForeground(Color.WHITE);
        panel.add(table);

        JButton back = new JButton("BACK");
        back.setBounds(350, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(41,11,70,19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(159,11,70,19);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(273,11,70,19);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(416,11,70,19);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(536,11,70,19);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(656,11,70,19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(phone);

        JLabel gmail = new JLabel("E-Mail");
        gmail.setBounds(786,11,70,19);
        gmail.setForeground(Color.WHITE);
        gmail.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gmail);

        JLabel kimlik = new JLabel("Identification");
        kimlik.setBounds(896,11,70,19);
        kimlik.setForeground(Color.WHITE);
        kimlik.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(kimlik);




        try {
            conn c=new conn();
            String q="select * from employee where job ='Manager'";
            ResultSet resultSet =c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1000,600);
        setVisible(true);
    }


    public static void main(String[] args) {
        new ManagerInfo();
    }
}
