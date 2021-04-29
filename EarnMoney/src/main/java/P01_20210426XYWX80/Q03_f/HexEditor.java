package P01_20210426XYWX80.Q03_f;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @author : ZWH 2021/4/28
 * @version : 1.0
 */
public class HexEditor extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JTextArea textArea2;
    private JButton updateButton;
    private String location;

    public HexEditor() throws HeadlessException {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");

        load.addActionListener(this);
        save.addActionListener(this);

        file.add(load);
        file.add(save);
        menuBar.add(file);

        textArea = new JTextArea(5, 10);
        textArea2 = new JTextArea(5, 20);
        JLabel label = new JLabel(" ");
        updateButton = new JButton("Update hex");
        updateButton.addActionListener(this);

        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(layout);
        panel.add(textArea);
        panel.add(label);
        panel.add(textArea2);

        this.setJMenuBar(menuBar);
        this.add(panel, BorderLayout.NORTH);
        this.add(updateButton, BorderLayout.SOUTH);

        this.setSize(350, 150);
        this.setLocation(350, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load": {
                location = JOptionPane.showInputDialog("Input the File Location");
                InputStream is = null;
                try {
                    is = new FileInputStream(location);

                    int length = 0;
                    byte[] byteBuffer = new byte[1024];
                    while ((length = is.read(byteBuffer)) != -1) {
                        textArea.append(new String(byteBuffer, 0, length));
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } finally {
                    try {
                        is.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                break;
            }
            case "Update hex": {
                textArea2.setText("");
                for (char c : textArea.getText().toCharArray()) {
                    if (Integer.valueOf(c) == 10) {
                        textArea2.append("0A ");
                    } else {
                        textArea2.append(Integer.toHexString(c) + " ");
                    }
                }
                textArea2.append("\b");
                break;
            }
            case "Save": {
                if (location == null || location.length() == 0) {
                    location = JOptionPane.showInputDialog("Input the File Location");
                }
                OutputStream os = null;
                try {
                    os = new FileOutputStream(location);
                    os.write(textArea.getText().getBytes());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } finally {
                    try {
                        os.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        }
    }
}