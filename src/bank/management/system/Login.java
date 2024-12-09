package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Login extends JFrame {

    private JLabel bankImage; // Declare JLabel at the class level
    private JLabel cardImage;
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
        repaint(); // Ensure the frame updates
    }

    public static void main(String[] args) {
        new Login();
    }
}
