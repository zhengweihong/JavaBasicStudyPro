package P14_Adapter_or_Wrapper;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 适配器/转换器模式，测试
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(
                "/Users/ZWH/WorkSpace/IDEAWorkspace/JavaBasicStudyPro" +
                        "/DesignPattern/src/main/resources/a.txt");
        // isr是转换器，fis不能直接给到br
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        isr.close();
        fis.close();

        Frame f = new Frame();
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
    }
}
