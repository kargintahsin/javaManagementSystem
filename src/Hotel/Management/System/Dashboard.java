package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dashboard extends JFrame implements ActionListener {
    JButton add, rec;


    Dashboard() {
        super("Hotel Adı");


        rec = new JButton("RECEPTION");
        rec.setBounds(700, 770, 140, 30);
        rec.setFont(new Font("Tahoma", Font.BOLD, 15));
        rec.setBackground(new Color(255, 98, 0));
        rec.setForeground(Color.WHITE);
        rec.addActionListener(this);
        add(rec);

        add = new JButton("ADMIN");
        add.setBounds(1060, 770, 140, 30);
        add.setFont(new Font("Tahoma", Font.BOLD, 15));
        add.setBackground(new Color(255, 98, 0));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icons/information-desk.png"));
        Image i22 = i111.getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT);
        ImageIcon imageIcon111 = new ImageIcon(i22);
        JLabel label11 = new JLabel(imageIcon111);
        label11.setBounds(640, 500, 256, 256);
        add(label11);


        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/boss.png"));
        Image i2 = i11.getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11 = new ImageIcon(i2);
        JLabel label1 = new JLabel(imageIcon11);
        label1.setBounds(1000, 500, 256, 256);
        add(label1);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard2.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(1920, 1050, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0, 0, 1920, 1050);
        add(label);


        setLayout(null);
        setSize(1920, 1050);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rec) {
            new Reception();
            setVisible(false);

        } else {
            new login2();
            setVisible(false);

        }


    }

    public static void main(String[] args) {
        new Dashboard();


    }


}
