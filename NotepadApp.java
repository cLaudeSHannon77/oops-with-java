
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class NotepadApp extends JFrame implements ActionListener {
    JTextArea area;
    JMenuItem newFile, open, save, cut, copy, paste, exit;

    NotepadApp() {
        setTitle("Simple Notepad");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area = new JTextArea();
        add(new JScrollPane(area));

        JMenuBar mb = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        newFile = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");

        file.add(newFile);
        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);

        mb.add(file);
        mb.add(edit);
        setJMenuBar(mb);

        newFile.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        try {
            if (source == newFile) {
                area.setText("");
            } else if (source == open) {
                JFileChooser fc = new JFileChooser();
                if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    BufferedReader br = new BufferedReader(
                            new FileReader(fc.getSelectedFile()));
                    area.read(br, null);
                    br.close();
                }
            } else if (source == save) {
                JFileChooser fc = new JFileChooser();
                if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    BufferedWriter bw = new BufferedWriter(
                            new FileWriter(fc.getSelectedFile()));
                    area.write(bw);
                    bw.close();
                }
            } else if (source == cut) {
                area.cut();
            } else if (source == copy) {
                area.copy();
            } else if (source == paste) {
                area.paste();
            } else if (source == exit) {
                System.exit(0);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "File error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new NotepadApp();
    }
}
