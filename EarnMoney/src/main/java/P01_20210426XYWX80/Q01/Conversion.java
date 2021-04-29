package P01_20210426XYWX80.Q01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : ZWH 2021/4/28
 * @version : 1.0
 */
public class Conversion extends JFrame implements ActionListener {
    private JTextField SGDAmountTextField;
    private JLabel HKDAmountLabel;
    private JButton calButton;

    public Conversion() throws HeadlessException {
        SGDAmountTextField = new JTextField();
        HKDAmountLabel = new JLabel("          ");
        calButton = new JButton("Calculate");
        calButton.addActionListener(this);

        JPanel panel = new JPanel();
        BoxLayout layout=new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(layout);
        panel.add(SGDAmountTextField);
        panel.add(HKDAmountLabel);

        this.add(panel, BorderLayout.NORTH);
        this.add(calButton, BorderLayout.SOUTH);

        this.setSize(200,80);
        this.setLocation(350,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = SGDAmountTextField.getText();
        if (input != null && input.length() > 0) {
            double inputCount = Double.parseDouble(input)*5.7;
            HKDAmountLabel.setText(String.valueOf(inputCount));
        }
    }

    public static void main(String[] args) {
        Conversion conversion = new Conversion();
    }
}
