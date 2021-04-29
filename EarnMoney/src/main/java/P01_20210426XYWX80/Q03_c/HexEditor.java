package P01_20210426XYWX80.Q03_c;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * @author : ZWH 2021/4/28
 * @version : 1.0
 */
public class HexEditor extends JFrame implements ActionListener {
    private JTextArea textArea;

    public HexEditor() throws HeadlessException {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Load");

        load.addActionListener(this);

        file.add(load);
        menuBar.add(file);

        textArea = new JTextArea(5,10);

        this.setJMenuBar(menuBar);
        this.add(textArea);

        this.setSize(150,120);
        this.setLocation(350,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String location = JOptionPane.showInputDialog("Input the File Location");
        InputStream is = null;
        try {
            is = new FileInputStream(location);

            int length = 0;
            byte[] byteBuffer = new byte[1024];
            while ((length = is.read(byteBuffer)) != -1){
                textArea.append(new String(byteBuffer,0,length));
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
    }
}
