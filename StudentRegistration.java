
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class StudentRegistration extends JFrame {

    JTextField nameField, rollField, courseField, emailField;
    JButton registerButton;

    StudentRegistration() {
        setTitle("Student Registration Portal");
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Course:"));
        courseField = new JTextField();
        add(courseField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        registerButton = new JButton("Register");
        add(registerButton);

        registerButton.addActionListener(e -> saveStudent());

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void saveStudent() {
        String name = nameField.getText().trim();
        String roll = rollField.getText().trim();
        String course = courseField.getText().trim();
        String email = emailField.getText().trim();

        if (name.isEmpty() || roll.isEmpty()
                || course.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields.");
            return;
        }

        File file = new File("students.csv");
        boolean newFile = !file.exists();

        try (PrintWriter pw = new PrintWriter(
                new FileWriter(file, true))) {

            if (newFile) {
                pw.println("Name,Roll Number,Course,Email");
            }

            pw.println("\"" + name.replace("\"", "\"\"") + "\","
                    + "\"" + roll.replace("\"", "\"\"") + "\","
                    + "\"" + course.replace("\"", "\"\"") + "\","
                    + "\"" + email.replace("\"", "\"\"") + "\"");

            JOptionPane.showMessageDialog(this,
                    "Student registered successfully!");

            nameField.setText("");
            rollField.setText("");
            courseField.setText("");
            emailField.setText("");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error saving student: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRegistration::new);
    }
}
