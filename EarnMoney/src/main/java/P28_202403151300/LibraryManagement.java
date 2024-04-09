package P28_202403151300;

import javax.swing.*;

public class LibraryManagement {
    public static void main(String[] args) {
        try {
            JFrame loginFrame = LoginFrame.getInstance();
            loginFrame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
