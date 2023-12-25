package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception() {
        //sağ panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280, 5, 1650, 1020);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        //sol panel
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 270, 1020);
        panel1.setBackground(new Color(3, 45, 48));
        add(panel1);

        //yeni müşteri formu butonu
        JButton btnNCF = new JButton("New Customer Form");
        btnNCF.setBounds(30, 30, 200, 30);
        btnNCF.setBackground(Color.BLACK);
        btnNCF.setForeground(Color.WHITE);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new newCostumer();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //Oda butonu
        JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30, 70, 200, 30);
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.WHITE);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Room();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //Department butonu
        JButton btnDepartment = new JButton("Department");
        btnDepartment.setBounds(30, 110, 200, 30);
        btnDepartment.setBackground(Color.BLACK);
        btnDepartment.setForeground(Color.WHITE);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Department();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //Çalışan bilgileri butonu
        JButton btnAEI = new JButton("All Employee Info");
        btnAEI.setBounds(30, 150, 200, 30);
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.WHITE);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Employee();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //Müşteri Bilgileri Butonu
        JButton btnCI = new JButton("Costumer Info");
        btnCI.setBounds(30, 190, 200, 30);
        btnCI.setBackground(Color.BLACK);
        btnCI.setForeground(Color.WHITE);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   new CustomerInfo();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //Yönetici Bilgileri Butonu
        JButton btnMI = new JButton("Manager Info");
        btnMI.setBounds(30, 230, 200, 30);
        btnMI.setBackground(Color.BLACK);
        btnMI.setForeground(Color.WHITE);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ManagerInfo();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //Çıkış Butonu
        JButton btnCO = new JButton("Check Out");
        btnCO.setBounds(30, 270, 200, 30);
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.WHITE);
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //Güncelleme-Detaylar butonu
        JButton btnUC = new JButton("Update Check-In Details");
        btnUC.setBounds(30, 310, 200, 30);
        btnUC.setBackground(Color.BLACK);
        btnUC.setForeground(Color.WHITE);
        panel1.add(btnUC);
        btnUC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateCheck();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //Oda durumu güncelleme butonu
        JButton btnURS = new JButton("Update Room Status");
        btnURS.setBounds(30, 350, 200, 30);
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.WHITE);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateRoom();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //getir götür hizmeti butonu
        JButton btnPUS = new JButton("Pick Up Service");
        btnPUS.setBounds(30, 390, 200, 30);
        btnPUS.setBackground(Color.BLACK);
        btnPUS.setForeground(Color.WHITE);
        panel1.add(btnPUS);
        btnPUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new PickUp();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        //Oda arama butonu
        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30, 430, 200, 30);
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.WHITE);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new SearchRoom();

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1920, 1050);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Reception() {

        };
    }
}
