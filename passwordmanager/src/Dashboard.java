import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    JButton addButton;
    JButton viewButton;
    JButton exitButton;

    Dashboard() {

        // Frame Title
        setTitle("Password Manager");

        // Frame Size
        setSize(500, 400);

        // Close Program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center Window
        setLocationRelativeTo(null);

        // Layout
        setLayout(null);

        // Background Color
        getContentPane().setBackground(Color.BLACK);

        // Heading
        JLabel heading = new JLabel("PASSWORD MANAGER");
        heading.setBounds(90, 30, 350, 40);
        heading.setForeground(Color.YELLOW);
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        add(heading);

        // Add Password Button
        addButton = new JButton("Add Password");
        addButton.setBounds(150, 120, 180, 40);
        addButton.setBackground(Color.YELLOW);
        addButton.setForeground(Color.BLACK);
        add(addButton);

// Add Password Button Action
addButton.addActionListener(e -> new AddPassword());

// View Password Button
viewButton = new JButton("View Passwords");
viewButton.setBounds(150, 180, 180, 40);
viewButton.setBackground(Color.YELLOW);
viewButton.setForeground(Color.BLACK);
add(viewButton); //  IMPORTANT: must add to frame

// View Password Button Action
viewButton.addActionListener(e -> new ViewPasswords());
        

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(150, 240, 180, 40);
        exitButton.setBackground(Color.YELLOW);
        exitButton.setForeground(Color.BLACK);
        add(exitButton);

        // Exit Action
        exitButton.addActionListener(e -> System.exit(0));

        // Make Window Visible
        setVisible(true);
    }
}