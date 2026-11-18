import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class AddPassword extends JFrame {

    JTextField websiteField;
    JTextField usernameField;
    JPasswordField passwordField;

    JButton saveButton;

    AddPassword() {

        setTitle("Add Password");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(Color.BLACK);

        JLabel title = new JLabel("ADD PASSWORD");
        title.setBounds(120, 20, 250, 30);
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        
        JLabel websiteLabel = new JLabel("Website:");
        websiteLabel.setBounds(40, 80, 100, 30);
        websiteLabel.setForeground(Color.YELLOW);
        add(websiteLabel);

        websiteField = new JTextField();
        websiteField.setBounds(140, 80, 180, 30);
        add(websiteField);

        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(40, 130, 100, 30);
        usernameLabel.setForeground(Color.YELLOW);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(140, 130, 180, 30);
        add(usernameField);

        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 180, 100, 30);
        passwordLabel.setForeground(Color.YELLOW);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 180, 180, 30);
        add(passwordField);

        
        saveButton = new JButton("SAVE");
        saveButton.setBounds(130, 240, 120, 40);
        saveButton.setBackground(Color.YELLOW);
        saveButton.setForeground(Color.BLACK);
        add(saveButton);

        
        saveButton.addActionListener(e -> savePassword());

        setVisible(true);
    }

    void savePassword() {

        String website = websiteField.getText().trim();
        String username = usernameField.getText().trim();
        String password = String.valueOf(passwordField.getPassword()).trim();

        
        System.out.println("Website: " + website);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        
        if (website.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        
        String encryptedPassword = EncryptionUtil.encrypt(password);

        
        System.out.println("Encrypted Password: " + encryptedPassword);

        
        if (encryptedPassword == null) {
            JOptionPane.showMessageDialog(this,
                    "Encryption Failed! Check EncryptionUtil.");
            return;
        }

        try {

            FileWriter writer = new FileWriter("passwords.txt", true);

            writer.write("Website: " + website + "\n");
            writer.write("Username: " + username + "\n");
            writer.write("Password: " + encryptedPassword + "\n");
            writer.write("----------------------\n");

            writer.close();

            JOptionPane.showMessageDialog(this,
                    "Password Saved Successfully!");

        } catch (IOException e) {

            JOptionPane.showMessageDialog(this,
                    "Error Saving Password!");
        }
    }
}