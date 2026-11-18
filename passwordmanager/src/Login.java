import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    JPasswordField passwordField;
    JButton loginButton;

    
    private final String MASTER_PASSWORD = "Imad123";

    Login() {

        setTitle("Login - Password Manager");
        setSize(500 , 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(Color.BLACK);

        JLabel title = new JLabel("MASTER LOGIN");
        title.setBounds(160, 20, 200, 30);
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        JLabel label = new JLabel("Enter Password:");
        label.setBounds(50, 80, 150, 25);
        label.setForeground(Color.WHITE);
        add(label);

        passwordField = new JPasswordField();
        passwordField.setBounds(170, 80, 150, 25);
        add(passwordField);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(190, 130, 100, 35);
        loginButton.setBackground(Color.YELLOW);
        loginButton.setForeground(Color.BLACK);
        add(loginButton);

        loginButton.addActionListener(e -> checkLogin());

        setVisible(true);
    }

    void checkLogin() {

        String password = String.valueOf(passwordField.getPassword());

        if (password.equals(MASTER_PASSWORD)) {

            JOptionPane.showMessageDialog(this,
                    "Login Successful!");

            new Dashboard();   
            this.dispose();   

        } else {

            JOptionPane.showMessageDialog(this,
                    "Wrong Password!");
        }
    }
}