package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Login extends JFrame {

    private JLabel bankImage; // Declare JLabel at the class level

    Login() {
        super("Bank Management System");

        setLayout(null);

        int frameWidth = 850;
        int frameHeight = 480;
        int imageWidth = 100;
        int imageHeight = 100;

        // Calculate the initial x position for centering
        int x = (frameWidth - imageWidth) / 2;

        // Load and scale the image
        ImageIcon bankIcon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bankImg = bankIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
        ImageIcon bank = new ImageIcon(bankImg);

        // Initialize the JLabel and set its bounds
        bankImage = new JLabel(bank);
        bankImage.setBounds(x, 20, imageWidth, imageHeight);
        add(bankImage);

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
        int frameHeight = getHeight(); // Get current frame height

        int imageWidth = bankImage.getWidth();   // Use the current image width
        int imageHeight = bankImage.getHeight(); // Use the current image height

        int x = (frameWidth - imageWidth) / 2; // Center horizontally

        bankImage.setBounds(x, 20, imageWidth, imageHeight); // Update bounds
        repaint(); // Ensure the frame updates
    }

    public static void main(String[] args) {
        new Login();
    }
}
