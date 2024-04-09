package P28_202403151300;

import javax.swing.*;
import java.awt.*;

public class FacultyUserPaneFactory extends AbstractUserPaneFactory {
    @Override
    JPanel drawView() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(30, 400, 730, 150);
        panel.setLayout(null);

        JTextArea coursesArea = new JTextArea();
        coursesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(coursesArea);
        scrollPane.setBounds(10, 15, 700, 70);
        panel.add(scrollPane);

        coursesArea.append("Course ID\tCourse Name\t\tNotice\n");
        coursesArea.append("C01\ta teaching course name\ta new edition of the textbook is available\n");

        return panel;
    }
}
