package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {
    UpdateRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/calender.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel CID = new JLabel("Update Room Status");
        CID.setBounds(124, 11, 222, 25);
        CID.setFont(new Font("Tahoma", Font.BOLD, 20));
        CID.setForeground(Color.WHITE);
        panel.add(CID);

        JLabel ID = new JLabel("ID:");
        ID.setBounds(25, 88, 46, 15);
        ID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ID.setForeground(Color.WHITE);
        panel.add(ID);

        Choice c=new Choice();
        c.setBounds(248,85,140,20);
        panel.add(c);

        try {
            conn C =new conn();

            ResultSet resultSet=C.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                c.add(resultSet.getString("number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel RoomNo = new JLabel("Room Number:");
        RoomNo.setBounds(25, 129, 107, 15);
        RoomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        RoomNo.setForeground(Color.WHITE);
        panel.add(RoomNo);

        JLabel name = new JLabel("Availability:");
        name.setBounds(25, 174, 97, 15);
        name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        JTextField roomText=new JTextField();
        roomText.setBounds(248,129,140,20);
        panel.add(roomText);

        JTextField nameText=new JTextField();
        nameText.setBounds(248,174,140,20);
        panel.add(nameText);


        JLabel CI = new JLabel("Clean Status:");
        CI.setBounds(25, 216, 97, 15);
        CI.setFont(new Font("Tahoma", Font.PLAIN, 14));
        CI.setForeground(Color.WHITE);
        panel.add(CI);

        JTextField CIText=new JTextField();
        CIText.setBounds(248,216,140,20);
        panel.add(CIText);



        JButton update = new JButton("Update");
        update.setBounds(120, 315, 89, 23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn C =new conn();
                    String status= CIText.getText();
                    C.statement.executeUpdate("update room set cleaning_status='"+status+"' where roomnumber=" +roomText.getText());
                    JOptionPane.showMessageDialog(null,"Updated Succesfully");
                    setVisible(false);



                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton back = new JButton("Back");
        back.setBounds(180, 355, 89, 23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        JButton check = new JButton("Check");
        check.setBounds(60, 355, 89, 23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=c.getSelectedItem();
                String q="select * from customer where number ='"+id+"'";

                try {
                    conn c =new conn();
                    ResultSet resultSet=c.statement.executeQuery(q);

                    while (resultSet.next()){
                        roomText.setText(resultSet.getString("room"));



                    }

                    ResultSet resultSet1=c.statement.executeQuery("select * from room where roomnumber='"+roomText.getText()+"'");

                    while (resultSet1.next()){
                        nameText.setText(resultSet1.getString("availability"));
                        CIText.setText(resultSet1.getString("cleaning_status"));


                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        setLayout(null);
        setLocation(400,200);
        setSize(950,450);
        setVisible(true);

    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}

