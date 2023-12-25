package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBoxRoom;
    Choice choice;
    JTable table;
    JButton search, back;

    SearchRoom() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel searchRoom = new JLabel("Search Room");
        searchRoom.setBounds(250, 11, 186, 31);
        searchRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
        searchRoom.setForeground(Color.WHITE);
        panel.add(searchRoom);

        JLabel rbt = new JLabel("Room Bed Type");
        rbt.setBounds(50, 73, 120, 16);
        rbt.setFont(new Font("Tahoma", Font.BOLD, 14));
        rbt.setForeground(Color.WHITE);
        panel.add(rbt);

        JLabel rn = new JLabel("Room Number");
        rn.setBounds(23, 162, 150, 20);
        rn.setFont(new Font("Tahoma", Font.BOLD, 14));
        rn.setForeground(Color.WHITE);
        panel.add(rn);

        JLabel available = new JLabel("Availability");
        available.setBounds(175, 162, 150, 20);
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(458, 162, 150, 20);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        price.setForeground(Color.WHITE);
        panel.add(price);

        JLabel SS = new JLabel("Clean Status");
        SS.setBounds(306, 162, 150, 20);
        SS.setFont(new Font("Tahoma", Font.BOLD, 14));
        SS.setForeground(Color.WHITE);
        panel.add(SS);

        JLabel BT = new JLabel("Bed Type");
        BT.setBounds(580, 162, 150, 20);
        BT.setFont(new Font("Tahoma", Font.BOLD, 14));
        BT.setForeground(Color.WHITE);
        panel.add(BT);


        checkBoxRoom = new JCheckBox("Only Display Available");
        checkBoxRoom.setBounds(480, 69, 205, 23);
        //searchRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
        checkBoxRoom.setForeground(Color.WHITE);
        checkBoxRoom.setBackground(new Color(3, 45, 48));
        panel.add(checkBoxRoom);

        choice = new Choice();
        choice.add("Single");
        choice.add("Double");
        choice.setBounds(170, 70, 120, 20);
        panel.add(choice);

        table = new JTable();
        table.setBounds(0, 187, 700, 150);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3, 45, 48));
        panel.add(table);

        search = new JButton("SEARCH");
        search.setBounds(200, 400, 120, 30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        panel.add(search);

        back = new JButton("BACK");
        back.setBounds(380, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ;

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        } catch (Exception E) {
            E.printStackTrace();
        }


        setUndecorated(true);
        setLayout(null);
        setLocation(500, 200);
        setSize(700, 500);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String Q = "select * from room where bed_type='"+choice.getSelectedItem()+"'";
            String Q1 = "select * from room where availability ='Available' and bed_type ='"+choice.getSelectedItem()+"'";

            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(Q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                if (checkBoxRoom.isSelected()) {
                    ResultSet resultSet1 = c.statement.executeQuery(Q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));

                }


            } catch (Exception E) {
                E.printStackTrace();
            }


        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
