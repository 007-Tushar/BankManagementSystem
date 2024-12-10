package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Login extends JFrame {

    private JLabel bankImage; // Declare JLabel at the class level
    private JLabel cardImage;
    private JLabel bgImage;
    private ImageIcon bgIcon; // Cache the original background icon
    private JLabel welcomeMsg;
    private  JLabel labelCardNo;
    private JLabel labelPin;
    private JTextField textCardNo;
    private JPasswordField passwordPin;
    Login() {
        super("Bank Management System");

        setLayout(null);

        int frameWidth = 850;
        int frameHeight = 480;
        int imageWidth = 100;
        int imageHeight = 100;

        // Calculate the initial x position for centering
        int x = (frameWidth - imageWidth) / 2;

        // Bank Image
        ImageIcon bankIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bankImg = bankIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
        ImageIcon bank = new ImageIcon(bankImg);

        // Initialize the JLabel and set its bounds
        bankImage = new JLabel(bank);
        bankImage.setBounds(x, 20, imageWidth, imageHeight);
        add(bankImage);

        // Card image
        ImageIcon cardIcon = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image cardImg = cardIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
        ImageIcon card = new ImageIcon(cardImg);

        // Initialize the JLabel and set its bounds
        cardImage = new JLabel(card);
        cardImage.setBounds(450, 200, imageWidth, imageHeight);
        add(cardImage);

        //Welcome message
        welcomeMsg = new JLabel("Welcome to ATM");
        welcomeMsg.setForeground(Color.WHITE);
        welcomeMsg.setFont(new Font("AvantGarde", Font.BOLD, 38));
        welcomeMsg.setBounds(230,140,450, 40);
        add(welcomeMsg);

        //Label Card Number
        labelCardNo = new JLabel("Card No.");
        labelCardNo.setForeground(Color.WHITE);
        labelCardNo.setFont(new Font("Ralway", Font.BOLD, 20));
        labelCardNo.setBounds(230,180, 250, 60);
        add(labelCardNo);

        //Text field
        textCardNo = new JTextField(15);
        textCardNo.setForeground(Color.BLACK);
        textCardNo.setFont(new Font("Arial", Font.BOLD, 14));
        textCardNo.setBounds(350, 195, 350,30);
        add(textCardNo);

        //Label PIN
        labelPin = new JLabel("PIN");
        labelPin.setForeground(Color.WHITE);
        labelPin.setFont(new Font("Ralway", Font.BOLD, 20));
        labelPin.setBounds(230, 180, 100, 160);
        add(labelPin);

        //Password field
        passwordPin = new JPasswordField(4);
        passwordPin.setForeground(Color.BLACK);
        passwordPin.setFont(new Font("Arial", Font.BOLD, 20));
        passwordPin.setBounds(350,245,350, 30);
        add(passwordPin);








        //Background Image
        bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image bgImg = bgIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT);
        ImageIcon bg = new ImageIcon(bgImg);

        // Initialize the JLabel and set its bounds
        bgImage = new JLabel(bg);
        bgImage.setBounds(0, 0, frameWidth, frameHeight);
        add(bgImage);


        // Frame properties
        setSize(frameWidth, frameHeight);
        setLocation(210, 110);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a listener to adjust the image position dynamically when resizing
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustImagePosition();
            }
        });
    }

    // Method to adjust the image position dynamically
    private void adjustImagePosition() {
        int frameWidth = getWidth();   // Get current frame width
        int frameHeight = getHeight();

        int imageWidth = bankImage.getWidth();   // Use the current image width
        int imageHeight = bankImage.getHeight(); // Use the current image height

        int xbank = (frameWidth - imageWidth) / 2; // Center horizontally
        int xcard = (frameWidth - imageWidth);
        int ycard = (frameHeight- imageHeight);

        bankImage.setBounds(xbank, 20, imageWidth, imageHeight); // Update bounds
        cardImage.setBounds(xcard - 60, ycard - 80, 150, 150);
        bgImage.setBounds(0, 0, frameWidth, frameHeight);
        welcomeMsg.setBounds(xbank - 100, 140, 450, 40);

        // Scale the background image to fit the frame
        Image bgImg = bgIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT);
        bgImage.setIcon(new ImageIcon(bgImg));
        bgImage.setBounds(0, 0, frameWidth, frameHeight);

        // Refresh the frame
        revalidate();
        repaint();

    }

    public static void main(String[] args) {
        new Login();
    }
}
