
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    TextField t1, t2, t3;
    Button b1, b2, b3, b4;

    Calculator() {
        setTitle("Simple Calculator");
        setLayout(new FlowLayout());

        t1 = new TextField(10);
        t2 = new TextField(10);
        t3 = new TextField(10);

        b1 = new Button("+");
        b2 = new Button("-");
        b3 = new Button("*");
        b4 = new Button("/");

        add(new Label("First Number:"));
        add(t1);

        add(new Label("Second Number:"));
        add(t2);

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        add(new Label("Result:"));
        add(t3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setSize(300, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());
        double result = 0;

        if (e.getSource() == b1)
            result = a + b;
        else if (e.getSource() == b2)
            result = a - b;
        else if (e.getSource() == b3)
            result = a * b;
        else if (e.getSource() == b4) {
            if (b == 0) {
                t3.setText("Cannot divide by zero");
                return;
            }
            result = a / b;
        }

        t3.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

