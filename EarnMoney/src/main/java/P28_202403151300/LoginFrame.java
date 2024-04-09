package P28_202403151300;

import javax.swing.*;
import java.awt.*;

/**
 * Singleton
 */
public class LoginFrame extends JFrame {
    private static final LoginFrame INSTANCE = new LoginFrame();

    public static LoginFrame getInstance() {
        return INSTANCE;
    }

    private LoginFrame() {
        int loginFrameWidth = 600;
        int loginFrameHeight = 400;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - loginFrameWidth) / 2, (screenSize.height - loginFrameHeight) / 2, loginFrameWidth, loginFrameHeight);
        this.setTitle("YorkU Library Management - Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        contentPane.add(emailLabel);
        contentPane.add(emailField);
        contentPane.add(passwordLabel);
        contentPane.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(220, 230, 55, 37);
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(320, 230, 75, 37);

        contentPane.add(loginButton);
        contentPane.add(registerButton);

        // Observer
        loginButton.addActionListener(event -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            if (email == null || "".equals(email) || "".equals(password)) {
                JOptionPane.showMessageDialog(this, "email or password is null", "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            User user = Utils.getUserByEmail(email);
            if (user == null) {
                JOptionPane.showMessageDialog(this, "email or password Error", "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!user.getUsing()) {
                JOptionPane.showMessageDialog(this, "user Locked", "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                JFrame userFrame = new UserFrame(user);
                userFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.dispose();
        });
        // Observer
        registerButton.addActionListener(event -> {
            try {
                JFrame registerFrame = new RegisterFrame();
                registerFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
