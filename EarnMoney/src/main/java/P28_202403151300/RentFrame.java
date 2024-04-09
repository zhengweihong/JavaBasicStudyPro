package P28_202403151300;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RentFrame extends JFrame {
    public RentFrame(User user, UserFrame rentingItemsArea) {
        int rentFrameWidth = 800;
        int rentFrameHeight = 600;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - rentFrameWidth) / 2, (screenSize.height - rentFrameHeight) / 2, rentFrameWidth, rentFrameHeight);
        this.setTitle("YorkU Library Management - Rent Items");

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        JTextField searchField = new JTextField(55);
        searchField.setBounds(80, 20, 225, 32);
        contentPane.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(320, 20, 65, 33);
        contentPane.add(searchButton);

        JComboBox<String> itemIdComboBox = new JComboBox<>();
        itemIdComboBox.setBounds(80, 70, 225, 35);
        contentPane.add(itemIdComboBox);

        JButton rentButton = new JButton("Rent");
        rentButton.setBounds(320, 70, 65, 33);
        contentPane.add(rentButton);

        JTextArea itemsArea = new JTextArea();
        itemsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemsArea);
        scrollPane.setBounds(30, 120, 730, 300);
        contentPane.add(scrollPane);

        itemsArea.append("Id\tName\tLocation\tNumbers\n");
        List<Item> items = Utils.getAllItem();
        for (Item item : items) {
            if (!item.getCanRent() || item.getNumbers() <= 0) {
                continue;
            }
            itemIdComboBox.addItem(item.getId());

            itemsArea.append(item.getId() + "\t");
            itemsArea.append(item.getName() + "\t");
            itemsArea.append(item.getLocation() + "\t");
            itemsArea.append(item.getNumbers() + "\t");
            itemsArea.append("\n");
        }

        searchButton.addActionListener(event -> {
            String str = searchField.getText();
            if (str == null || "".equals(str)) {
                return;
            }
            itemsArea.setText("Id\tName\tLocation\tNumbers\n");
            for (Item item : items) {
                if (!item.getCanRent() || item.getNumbers() <= 0 || !item.getName().toLowerCase().contains(str.toLowerCase())) {
                    continue;
                }
                itemsArea.append(item.getId() + "\t");
                itemsArea.append(item.getName() + "\t");
                itemsArea.append(item.getLocation() + "\t");
                itemsArea.append(item.getNumbers() + "\t");
                itemsArea.append("\n");
            }
        });

        rentButton.addActionListener(event -> {
            if (rentingItemsArea.getRentRecords() != null && rentingItemsArea.getRentRecords().size() >= 10) {
                JOptionPane.showMessageDialog(this, "cannot borrow", "", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Map<String, Item> id2ItemMap = items.stream()
                    .collect(Collectors.toMap(Item::getId, Function.identity()));
            String str = itemIdComboBox.getSelectedItem().toString();
            if (id2ItemMap.containsKey(str)) {
                Item item = id2ItemMap.get(str);
                item.setNumbers(item.getNumbers() - 1);
                Utils.rewriteItemInfo(items);
                Utils.insertRentRecord(new RentRecord(user.getEmail(), item.getId(), item.getName(), LocalDate.now().plusMonths(1).toString()));
                JOptionPane.showMessageDialog(this, "Rent Success");
                rentingItemsArea.refreshRentingItemsArea();
                this.dispose();
            }
        });
    }
}
