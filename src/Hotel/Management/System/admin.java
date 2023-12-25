package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {

    JButton add_Employee, add_Room, add_Drivers, loguot, back;

    admin() {

        //Çalışan Ekleme Butonu
        add_Employee = new JButton("Add Employee");
        add_Employee.setBounds(250, 230, 200, 30);
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setForeground(Color.BLACK);
        add_Employee.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Employee.addActionListener(this);
        add(add_Employee);

        //Oda Ekleme Butonu
        add_Room = new JButton("Add Room");
        add_Room.setBounds(250, 380, 200, 30);
        add_Room.setBackground(Color.WHITE);
        add_Room.setForeground(Color.BLACK);
        add_Room.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Room.addActionListener(this);
        add(add_Room);

        //Sürücü Ekleme Butonu
        add_Drivers = new JButton("Add Driver");
        add_Drivers.setBounds(250, 530, 200, 30);
        add_Drivers.setBackground(Color.WHITE);
        add_Drivers.setForeground(Color.BLACK);
        add_Drivers.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Drivers.addActionListener(this);
        add(add_Drivers);

        //Çıkış Butonu
        loguot = new JButton("Log Out");
        loguot.setBounds(10, 800, 95, 30);
        loguot.setBackground(Color.BLACK);
        loguot.setForeground(Color.WHITE);
        loguot.setFont(new Font("Tahoma", Font.BOLD, 15));
        loguot.addActionListener(this);
        add(loguot);

        //Geri Butonu
        back = new JButton("Back");
        back.setBounds(110, 800, 95, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);


        //Çalışan İkonu
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/team.png"));
        Image l11 = l1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(l11);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(70, 180, 120, 120);
        add(label);

        //Oda İkonu
        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/room.png"));
        Image image = imageIcon1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(70, 340, 120, 120);
        add(label1);

        //Sürücü İkonu
        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icons/driver.png"));
        Image image1 = imageIcon2.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon imageIcon12 = new ImageIcon(image1);
        JLabel label2 = new JLabel(imageIcon12);
        label2.setBounds(70, 500, 120, 120);
        add(label2);


        getContentPane().setBackground(new Color(3, 45, 48));
        setLayout(null);
        setSize(1920, 1050);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_Employee) {
            new AddEmployee();

        } else if (e.getSource() == add_Room) {
            new AddRoom();

        } else if (e.getSource() == add_Drivers) {
            new addDriver();

        } else if (e.getSource() == loguot) {
            System.exit(102);

        } else if (e.getSource() == back) {
            new Dashboard();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new admin();
    }
}
