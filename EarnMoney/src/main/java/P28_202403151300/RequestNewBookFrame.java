package P28_202403151300;

import javax.swing.*;
import java.awt.*;

public class RequestNewBookFrame extends JFrame {
    public RequestNewBookFrame() {
        int registerFrameWidth = 800;
        int registerFrameHeight = 600;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - registerFrameWidth) / 2, (screenSize.height - registerFrameHeight) / 2, registerFrameWidth, registerFrameHeight);
        this.setTitle("YorkU Library Management - Request New Book");

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setBounds(30, 60, 75, 35);
        contentPane.add(nameLabel);

        JTextField nameField = new JTextField(35);
        nameField.setBounds(180, 60, 215, 35);
        contentPane.add(nameField);

        JLabel typeLabel = new JLabel("Type :");
        typeLabel.setBounds(30, 100, 75, 35);
        contentPane.add(typeLabel);

        JRadioButton textbookRadioButton = new JRadioButton("textbook");
        textbookRadioButton.setBounds(180, 100, 215, 35);
        contentPane.add(textbookRadioButton);

        JRadioButton selfImprovementRadioButton = new JRadioButton("self-improvement");
        selfImprovementRadioButton.setBounds(180, 140, 215, 35);
        contentPane.add(selfImprovementRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(textbookRadioButton);
        buttonGroup.add(selfImprovementRadioButton);

        JButton requestButton = new JButton("Request");
        requestButton.setBounds(120, 210, 75, 35);
        contentPane.add(requestButton);
        requestButton.addActionListener(event -> {
            String name = nameField.getText();
            if (name == null || "".equals(name)) {
                JOptionPane.showMessageDialog(this, "request null", "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String type = textbookRadioButton.isSelected() ? "textbook" : "self-improvement";
            Utils.insertRequestRecord(name + "," + type);
            JOptionPane.showMessageDialog(this, "Request Success");
            this.dispose();
        });
    }
}
