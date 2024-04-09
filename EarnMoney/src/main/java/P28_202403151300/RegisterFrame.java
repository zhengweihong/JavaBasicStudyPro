package P28_202403151300;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        int registerFrameWidth = 600;
        int registerFrameHeight = 400;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - registerFrameWidth) / 2, (screenSize.height - registerFrameHeight) / 2, registerFrameWidth, registerFrameHeight);
        this.setTitle("YorkU Library Management - Register");

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setBounds(130, 80, 75, 35);
        JTextField emailField = new JTextField(35);
        emailField.setBounds(220, 80, 215, 35);
        JLabel passwordLabel = new JLabel("Password :");
        passwordLabel.setBounds(130, 150, 75, 35);
        JPasswordField passwordField = new JPasswordField(35);
        passwordField.setBounds(220, 150, 215, 35);
        JLabel roleLabel = new JLabel("Role :");
        roleLabel.setBounds(130, 220, 75, 35);
        JComboBox<String> roleComboBox = new JComboBox<>();
        roleComboBox.addItem("student");
        roleComboBox.addItem("faculty");
        roleComboBox.addItem("non-faculty");
        roleComboBox.addItem("visitor");
        roleComboBox.setBounds(220, 220, 215, 35);
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(270, 270, 75, 37);

        contentPane.add(emailLabel);
        contentPane.add(emailField);
        contentPane.add(passwordLabel);
        contentPane.add(passwordField);
        contentPane.add(roleLabel);
        contentPane.add(roleComboBox);
        contentPane.add(registerButton);

        // Observer
        registerButton.addActionListener(event -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String role = roleComboBox.getSelectedItem().toString();
            if (email == null || "".equals(email) || "".equals(password)) {
                JOptionPane.showMessageDialog(this, "email or password is null", "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!Utils.isStrongPassword(password)) {
                JOptionPane.showMessageDialog(this, "password is not strong", "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            User user = Utils.getUserByEmail(email);
            if (user == null) {
                Utils.insertUser(new User.UserBuilder().email(email).password(password).role(role).using(false).build());
                JOptionPane.showMessageDialog(this, "Register Success");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Duplicate Email", "", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
