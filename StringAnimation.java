
import javax.swing.*;
import java.awt.*;

public class StringAnimation extends JPanel implements Runnable {
    String str = "Hello Java";
    int x = 0;
    Thread t;

    public StringAnimation() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            x = x + 10;

            if (x > getWidth())
                x = 0;

            repaint();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(str, x, 100);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("String Animation");
        StringAnimation panel = new StringAnimation();

        f.add(panel);
        f.setSize(500, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}


