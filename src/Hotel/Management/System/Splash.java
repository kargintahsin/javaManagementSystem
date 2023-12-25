package Hotel.Management.System;

import javax.swing.*;

public class Splash extends JFrame {
    Splash() {
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/splash.gif"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0, 0, 320, 480);
        add(label);


        setUndecorated(true);
        setLayout(null);
        setLocation(300, 80);
        setSize(320, 480);
        setVisible(true);


        try {
            Thread.sleep(3000);
            setVisible(false);
            new Login();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
