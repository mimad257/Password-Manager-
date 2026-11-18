import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewPasswords extends JFrame {

    JTextArea textArea;

    ViewPasswords() {

        // Frame settings
        setTitle("Saved Passwords");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        // Text area
        textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.YELLOW);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setEditable(false);

        // Scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Load data
        loadPasswords();

        setVisible(true);
    }

    void loadPasswords() {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("passwords.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                // Password line handling
                if (line.startsWith("Password: ")) {

                    String encryptedPassword =
                            line.substring(10).trim();

                    String decryptedPassword =
                            EncryptionUtil.decrypt(encryptedPassword);

                    // 🔥 DEBUG OUTPUT (console)
                    System.out.println("Encrypted: " + encryptedPassword);
                    System.out.println("Decrypted: " + decryptedPassword);

                    // SAFE CHECK
                    if (decryptedPassword == null || decryptedPassword.isEmpty()) {
                        textArea.append("Password: " + encryptedPassword + "\n");
                    } else {
                        textArea.append("Password: " + decryptedPassword + "\n");
                    }

                } else {

                    // Normal lines (Website, Username, separator)
                    textArea.append(line + "\n");
                }
            }

            reader.close();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(this,
                    "No Password File Found!");
        }
    }
}