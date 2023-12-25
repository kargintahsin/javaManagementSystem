package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {
    UpdateCheck(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel CID = new JLabel("Check-In Details");
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

        JLabel name = new JLabel("Name:");
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


        JLabel CI = new JLabel("Checked-In:");
        CI.setBounds(25, 216, 97, 15);
        CI.setFont(new Font("Tahoma", Font.PLAIN, 14));
        CI.setForeground(Color.WHITE);
        panel.add(CI);

        JTextField CIText=new JTextField();
        CIText.setBounds(248,216,140,20);
        panel.add(CIText);

        JLabel AP = new JLabel("Amount Paid:");
        AP.setBounds(25, 261, 150, 15);
        AP.setFont(new Font("Tahoma", Font.PLAIN, 14));
        AP.setForeground(Color.WHITE);
        panel.add(AP);

        JTextField APText=new JTextField();
        APText.setBounds(248,261,140,20);
        panel.add(APText);


        JLabel PA = new JLabel("Pending Amount:");
        PA.setBounds(25, 302, 150, 15);
        PA.setFont(new Font("Tahoma", Font.PLAIN, 15));
        PA.setForeground(Color.WHITE);
        panel.add(PA);

        JTextField PAText=new JTextField();
        PAText.setBounds(248,302,140,20);
        panel.add(PAText);


        JButton update = new JButton("Update");
        update.setBounds(56, 378, 89, 23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn C =new conn();
                    String q=c.getSelectedItem();
                    String room=roomText.getText();
                    String name=nameText.getText();
                    String check=CI.getText();
                    String amount=APText.getText();
                    C.statement.executeUpdate("update customer set room='"+room+"',name='"+name+"',checkintime='"+check+"',deposit='"+amount+"' where number ='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Succesfully");
                    setVisible(false);



                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton back = new JButton("Back");
        back.setBounds(168, 378, 89, 23);
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
        check.setBounds(281, 378, 89, 23);
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
                        nameText.setText(resultSet.getString("name"));
                        CIText.setText(resultSet.getString("checkintime"));
                        APText.setText(resultSet.getString("deposit"));

                    }

                    ResultSet resultSet1=c.statement.executeQuery("select * from room where roomnumber='"+roomText.getText()+"'");

                    while (resultSet1.next()){

                        String price=resultSet1.getString("price");
                        int amountPaid=Integer.parseInt(price)- Integer.parseInt(APText.getText());
                        PAText.setText(""+amountPaid);
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        setLayout(null);
        setLocation(400,200);
        setSize(950,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateCheck();



    }
}
