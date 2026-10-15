

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class LoginForn extends JFrame {
    JTextField nameField;
    JPasswordField passwordField;
    JButton submitButton;

    LoginForn() {
        setTitle("Login Form");
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        add(passwordField);

        submitButton = new JButton("Submit");
        add(submitButton);

        submitButton.addActionListener(e -> saveData());

        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void saveData() {
        String name = nameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both name and password.");
            return;
        }

        File file = new File("users.csv");
        boolean newFile = !file.exists();

        try (PrintWriter pw = new PrintWriter(
                new FileWriter(file, true))) {

            if (newFile) {
                pw.println("Name,Password");
            }

            pw.println("\"" + name.replace("\"", "\"\"") + "\",\""
                    + password.replace("\"", "\"\"") + "\"");

            JOptionPane.showMessageDialog(this,
                    "Data saved successfully in users.csv!");

            nameField.setText("");
            passwordField.setText("");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error saving file: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForn::new);
    }
}
