package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDriver extends JFrame implements ActionListener {
    JTextField nameText,ageText,carCText,carNText,locText;
    JComboBox genderComboBox,availableComboBox;
    JButton add,back;
    addDriver(){


        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);


        JLabel label = new JLabel("ADD DRIVER");
        label.setBounds(194,10,150,22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(label);

        //Sürücü İsim Bilgisi Alma
        JLabel name = new JLabel("NAME");
        name.setBounds(64,70,102,22);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);
        nameText=new JTextField();
        nameText.setBounds(174,70,156,20);
        nameText.setForeground(Color.WHITE);
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        nameText.setBackground(new Color(16,108,115));
        panel.add(nameText);

        //Sürücü yaş bilgisi alma
        JLabel age = new JLabel("AGE");
        age.setBounds(64,110,102,22);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(age);
        ageText=new JTextField();
        ageText.setBounds(174,110,156,20);
        ageText.setForeground(Color.WHITE);
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setBackground(new Color(16,108,115));
        panel.add(ageText);

        //Yeni Çalışan Cinsiyet Bilgisi Girme
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(64, 150, 102, 22);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        genderComboBox=new JComboBox(new String[] {"Male","Female"});
        genderComboBox.setBounds(176,150,154,20);
        genderComboBox.setForeground(Color.WHITE);
        genderComboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        genderComboBox.setBackground(new Color(16,108,115));
        panel.add(genderComboBox);

        //Sürücü Araç Şirketi
        JLabel carC = new JLabel("CAR COMPANY");
        carC.setBounds(64,190,110,22);
        carC.setForeground(Color.WHITE);
        carC.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carC);
        carCText=new JTextField();
        carCText.setBounds(174,190,156,20);
        carCText.setForeground(Color.WHITE);
        carCText.setFont(new Font("Tahoma",Font.BOLD,14));
        carCText.setBackground(new Color(16,108,115));
        panel.add(carCText);

        //Sürücü Araç Şirketi
        JLabel carN = new JLabel("CAR NAME");
        carN.setBounds(64,230,102,22);
        carN.setForeground(Color.WHITE);
        carN.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carN);
        carNText=new JTextField();
        carNText.setBounds(174,230,156,20);
        carNText.setForeground(Color.WHITE);
        carNText.setFont(new Font("Tahoma",Font.BOLD,14));
        carNText.setBackground(new Color(16,108,115));
        panel.add(carNText);

        //Sürücü Müsaitlik Durumu
        JLabel availabla = new JLabel("AVAILABLE");
        availabla.setBounds(64, 270, 102, 22);
        availabla.setFont(new Font("Tahoma", Font.BOLD, 14));
        availabla.setForeground(Color.WHITE);
        panel.add(availabla);
        availableComboBox=new JComboBox(new String[] {"Yes","No"});
        availableComboBox.setBounds(176,270,154,20);
        availableComboBox.setForeground(Color.WHITE);
        availableComboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        availableComboBox.setBackground(new Color(16,108,115));
        panel.add(availableComboBox);

        //Sürücü Konumu
        JLabel loc = new JLabel("LOCATION");
        loc.setBounds(64,310,102,22);
        loc.setForeground(Color.WHITE);
        loc.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(loc);
        locText=new JTextField();
        locText.setBounds(174,310,156,20);
        locText.setForeground(Color.WHITE);
        locText.setFont(new Font("Tahoma",Font.BOLD,14));
        locText.setBackground(new Color(16,108,115));
        panel.add(locText);

        //Onaylama
        add = new JButton("ADD");
        add.setBounds(64, 380, 111, 33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        //Geri Dönme
        back = new JButton("BACK");
        back.setBounds(198, 380, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/driver-license.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500, 60, 300, 300);
        panel.add(label1);



        setUndecorated(true);
        setLayout(null);
        setLocation(20, 200);
        setSize(900, 500);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name = nameText.getText();
            String age = ageText.getText();
            String gender =(String) genderComboBox.getSelectedItem();
            String company = carCText.getText();
            String carname = carNText.getText();
            String location = locText.getText();
            String available = (String) availableComboBox.getSelectedItem();

            try {
                conn c = new conn();
                String q = "insert into driver values('" + name + "','" + age + "','" + gender + "','" + company + "','" + carname + "','" + available + "','" + location + "')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Driver Succesfully Added");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            new admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addDriver();
    }

}
