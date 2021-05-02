package P01_2021042680.Q03_ab;

import javax.swing.*;
import java.awt.*;

/**
 * @author : ZWH 2021/4/28
 * @version : 1.0
 */
public class HexEditor extends JFrame {
    private JTextArea textArea;

    public HexEditor() throws HeadlessException {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem load = new JMenuItem("Load");

        file.add(load);
        menuBar.add(file);

        textArea = new JTextArea(5,10);

        this.setJMenuBar(menuBar);
        this.add(textArea);

        this.setSize(200,150);
        this.setLocation(350,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
