package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class newCostumer extends JFrame implements ActionListener {
    JTextField numberTextField,nameTextField,countryTextField,depositTextField;
    JComboBox comboBoxID,comboBoxGender;
    Choice c1;
    JLabel date;
    JButton add,back;

    newCostumer(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 150, 200, 200);
        panel.add(label);

        //Yeni müşteri Bilgiler
        JLabel labelNew = new JLabel("NEW COSTUMER FORM ");
        labelNew.setBounds(118, 11, 268, 53);
        labelNew.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelNew.setForeground(Color.WHITE);
        panel.add(labelNew);

        JLabel labelID = new JLabel("ID: ");
        labelID.setBounds(35, 76, 280, 14);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        comboBoxID=new JComboBox(new String[] {"Passport","Identification Card","Driver Lisence"});
        comboBoxID.setBounds(271,73,150,20);
        comboBoxID.setBackground(new Color(3,45,48));
        comboBoxID.setForeground(Color.WHITE);
        comboBoxID.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(comboBoxID);

        JLabel labelNumber = new JLabel("NUMBER: ");
        labelNumber.setBounds(35, 111, 280, 14);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);
        numberTextField=new JTextField();
        numberTextField.setBounds(271,111,150,20);
        panel.add(numberTextField);


        JLabel labelName = new JLabel("NAME: ");
        labelName.setBounds(35, 151, 280, 14);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);
        nameTextField=new JTextField();
        nameTextField.setBounds(271,151,150,20);
        panel.add(nameTextField);


        JLabel labelGender = new JLabel("GENDER: ");
        labelGender.setBounds(35, 191, 280, 14);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);
        comboBoxGender=new JComboBox(new String[] {"Male","Female"});
        comboBoxGender.setBounds(271,191,150,20);
        comboBoxGender.setBackground(new Color(3,45,48));
        comboBoxGender.setForeground(Color.WHITE);
        comboBoxGender.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(comboBoxGender);


        JLabel labelCountry = new JLabel("COUNTRY: ");
        labelCountry.setBounds(35, 231, 280, 14);
        labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelCountry.setForeground(Color.WHITE);
        panel.add(labelCountry);
        countryTextField=new JTextField();
        countryTextField.setBounds(271,231,150,20);
        panel.add(countryTextField);


        JLabel labelRoom = new JLabel("Allocated Room Number: ");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        c1=new Choice();
        try {
            conn c=new conn();
            ResultSet resultSet =c.statement.executeQuery("select * from room");
            while (resultSet.next()){
                c1.add(resultSet.getString("roomnumber"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel labelCIS = new JLabel("Checked-In: ");
        labelCIS.setBounds(35, 316, 200, 14);
        labelCIS.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCIS.setForeground(Color.WHITE);
        panel.add(labelCIS);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271, 316, 200, 14);
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        date.setForeground(Color.WHITE);
        panel.add(date);


        JLabel labelDeposit = new JLabel("DEPOSIT: ");
        labelDeposit.setBounds(35, 359, 280, 14);
        labelDeposit.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);
        depositTextField=new JTextField();
        depositTextField.setBounds(271,359,150,20);
        panel.add(depositTextField);


        add = new JButton("ADD");
        add.setBounds(100, 430, 120, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260, 430, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);



        setLayout(null);
        setLocation(500,150);
        setSize(850,550);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            conn c =new conn();
            String gender=null;
            if(comboBoxGender.getSelectedItem()=="Male"){
                gender="Male";
            }else {gender="Female";}

            String s1=(String) comboBoxID.getSelectedItem();
            String s2 =numberTextField.getText();
            String s3 = nameTextField.getText();
            String s4 = gender;
            String s5=countryTextField.getText();
            String s6= c1.getSelectedItem();
            String s7 = date.getText();
            String s8=depositTextField.getText();

            try {
                String q = "insert into customer values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                String q1= "update room set availability='Occupied' where roomnumber="+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Customer Succesfully Added");
                setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
            }


        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new newCostumer();
    }
}
