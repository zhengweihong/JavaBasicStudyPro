package P28_202403151300;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentUserPaneFactory extends AbstractUserPaneFactory {
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

        String courseDueDate = "2024-03-18";
        coursesArea.append("Course ID\tCourse Name\tDue Date\n");
        coursesArea.append("C01\ta course name\t" + courseDueDate + "\n");

        JButton resourceButton = new JButton("Resources");
        resourceButton.setBounds(10, 95, 75, 35);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(courseDueDate, formatter);
        if (LocalDate.now().isBefore(date) || LocalDate.now().isEqual(date)) {
            panel.add(resourceButton);
        }
        resourceButton.addActionListener(event -> {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    URI uri = new URI("https://www.google.com");
                    Desktop.getDesktop().browse(uri);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Desktop or BROWSE action not supported.");
            }
        });

        return panel;
    }
}
