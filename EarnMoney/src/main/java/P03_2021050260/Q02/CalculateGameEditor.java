package P03_2021050260.Q02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : ZWH 2021/5/2
 * @version : 1.0
 */
public class CalculateGameEditor extends JFrame implements ActionListener {
    private String suanshi;
    private double result;
    private JTextField textField;

    public CalculateGameEditor() throws HeadlessException {
        setRandomEquation();

        textField = new JTextField();
        JLabel label = new JLabel(suanshi);
        JButton button = new JButton("Calculate");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.add(label);
        panel.add(textField);

        this.add(panel, BorderLayout.NORTH);
        this.add(button, BorderLayout.SOUTH);

        this.setSize(350, 150);
        this.setLocation(350, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setRandomEquation() {
        //自动生成算式
        int a = getRandomInt(100);
        int b = getRandomInt(100);
        int operator = getRandomInt(4);
        char operatorChar = '+';
        result = 0;
        switch (operator) {
            case 1:operatorChar = '+';result = a + b;break;
            case 2:operatorChar = '-';result = a - b;break;
            case 3:operatorChar = '*';result = a * b;break;
            case 4:operatorChar = '/';result = a / b;break;
        }
        System.out.println(a +" "+ operatorChar +" "+ b +"="+ result);
        suanshi = a +" "+ operatorChar +" "+ b +"=";
    }

    public static int getRandomInt(int a) {
        return (int) (Math.random() * a + 1);//[1,101)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double input = Double.parseDouble(textField.getText());
        if (result == input) {
            JOptionPane.showMessageDialog(null, "正确！");
        } else {
            JOptionPane.showMessageDialog(null, "错误！");
        }
    }
}
