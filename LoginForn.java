
import javax.swing.*;
import java.awt.*;

public class LoginForn extends JFrame {
    LoginForn() {
        setTitle("Login Form");
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        add(new JTextField(20));

        add(new JLabel("Password:"));
        JPasswordField password = new JPasswordField(20);
        add(password);

        add(new JButton("Submit"));

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForn();
    }
}

