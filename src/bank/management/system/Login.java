package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    Login(){
        super("Bank Management System");

        setLayout(null);

        int frameWidth = 850;
        int frameHeight = 480;
        int imageWidth = 100;
        int imageHeight = 10;

        int x = (frameWidth - imageWidth) / 2;
        int y = (frameHeight - imageHeight) / 2;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(imageWidth,imageHeight,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(x,y,100,100);
        add(image);



        //frame location and size settings

        setSize(frameWidth,frameHeight);
        setLocation(210,110);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Login();
    }
}
