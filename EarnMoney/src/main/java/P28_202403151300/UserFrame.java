package P28_202403151300;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class UserFrame extends JFrame {
    private User user;
    private JTextArea rentingItemsArea;
    private List<RentRecord> rentRecords;

    public UserFrame(User user) {
        this.user = user;

        int registerFrameWidth = 800;
        int registerFrameHeight = 800;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - registerFrameWidth) / 2, (screenSize.height - registerFrameHeight) / 2, registerFrameWidth, registerFrameHeight);
        this.setTitle("YorkU Library Management - " + user.getEmail());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        rentingItemsArea = new JTextArea();
        rentingItemsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(rentingItemsArea);
        scrollPane.setBounds(30, 20, 730, 300);
        contentPane.add(scrollPane);

        refreshRentingItemsArea();

        JButton rentButton = new JButton("Rent");
        rentButton.setBounds(40, 350, 55, 37);
        contentPane.add(rentButton);
        // Observer
        rentButton.addActionListener(event -> {
            try {
                JFrame rentFrame = new RentFrame(user, this);
                rentFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        JButton requestNewBookButton = new JButton("Request for a New Book");
        requestNewBookButton.setBounds(110, 350, 180, 37);
        contentPane.add(requestNewBookButton);
        // Observer
        requestNewBookButton.addActionListener(event -> {
            try {
                JFrame requestNewBookFrame = new RequestNewBookFrame();
                requestNewBookFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        JButton shoppingButton = new JButton("Shopping");
        shoppingButton.setBounds(305, 350, 75, 37);
        contentPane.add(shoppingButton);
        // Observer
        shoppingButton.addActionListener(event -> {
            try {
                JFrame shoppingFrame = new ShoppingFrame();
                shoppingFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // State
        JPanel factoryView = user.getFactoryView();
        if (factoryView != null) {
            contentPane.add(factoryView);
        }
    }

    public void refreshRentingItemsArea() {
        rentingItemsArea.setText("Item\tDue Date\tNotice\n");
        rentRecords = Utils.getRentRecordByUserEmail(user.getEmail());
        for (RentRecord rentRecord : rentRecords) {
            String dueDate = rentRecord.getDueDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dueDate, formatter);

            rentingItemsArea.append(rentRecord.getItemName() + "\t");
            rentingItemsArea.append(dueDate + "\t");
            if (LocalDate.now().isEqual(date)) {
                rentingItemsArea.append("less than 24 hours\t");
            } else if (LocalDate.now().isAfter(date)) {
                rentingItemsArea.append("past the due date");
                long daysBetween = ChronoUnit.DAYS.between(date, LocalDate.now());
                if (daysBetween <= 15) {
                    rentingItemsArea.append("  $" + 0.5 * daysBetween);
                } else {
                    rentingItemsArea.append("  lost");
                }
                rentingItemsArea.append("\t");
            }
            rentingItemsArea.append("\n");
        }
    }

    public List<RentRecord> getRentRecords() {
        return rentRecords;
    }
}
