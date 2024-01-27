package P07_Observer.C04_AWT;

import java.awt.*;
import java.awt.event.*;

/**
 * @author : ZWH
 * @date : 2024/01/26
 * @Description : 观察者模式：测试，Java AWT应用场景
 */
public class MainFrame extends Frame {
    public static void main(String[] args) {
        new MainFrame().view();
    }

    private void view() {
        Button button = new Button("press");
        // 把按钮添加到窗口中
        this.add(button);
        // 内部元素多大窗口就多大
        this.pack();
        // 展示
        this.setVisible(true);
        // 窗口位于屏幕何处
        this.setLocation(100, 100);

        button.addActionListener(new ButtonActionListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * Observer
     */
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getSource().toString() + " " + e.getActionCommand());
        }
    }
}
