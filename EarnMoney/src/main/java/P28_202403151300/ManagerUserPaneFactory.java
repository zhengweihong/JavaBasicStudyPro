package P28_202403151300;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ManagerUserPaneFactory extends AbstractUserPaneFactory {
    private JComboBox<String> needValidUserComboBox;
    private List<User> users;
    private JComboBox<String> itemIdComboBox_disable;
    private JComboBox<String> itemIdComboBox_enable;
    private List<Item> items;

    @Override
    JPanel drawView() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(30, 400, 730, 340);
        panel.setLayout(null);

        needValidUserComboBox = new JComboBox<>();
        needValidUserComboBox.setBounds(10, 10, 215, 35);
        panel.add(needValidUserComboBox);

        JButton approveButton = new JButton("Approve");
        approveButton.setBounds(250, 10, 75, 35);
        panel.add(approveButton);

        refreshNeedValidUserComboBox();
        approveButton.addActionListener(event -> {
            Map<String, User> email2UserMap = users.stream()
                    .collect(Collectors.toMap(User::getEmail, Function.identity()));
            if (needValidUserComboBox.getSelectedItem() == null) {
                return;
            }
            String str = needValidUserComboBox.getSelectedItem().toString();
            if (email2UserMap.containsKey(str)) {
                User user = email2UserMap.get(str);
                user.setUsing(true);
                Utils.rewriteUserInfo(users);
                JOptionPane.showMessageDialog(null, "Approve Success");
                refreshNeedValidUserComboBox();
            }
        });

        JLabel idLabel = new JLabel("ID :");
        idLabel.setBounds(50, 60, 75, 35);
        panel.add(idLabel);

        JTextField idField = new JTextField(35);
        idField.setBounds(160, 60, 215, 35);
        panel.add(idField);

        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setBounds(50, 105, 75, 35);
        panel.add(nameLabel);

        JTextField nameField = new JTextField(35);
        nameField.setBounds(160, 105, 215, 35);
        panel.add(nameField);

        JLabel locationLabel = new JLabel("Location :");
        locationLabel.setBounds(50, 150, 75, 35);
        panel.add(locationLabel);

        JTextField locationField = new JTextField(55);
        locationField.setBounds(160, 150, 215, 35);
        panel.add(locationField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(400, 105, 75, 35);
        panel.add(addButton);

        addButton.addActionListener(event -> {
            String id = idField.getText();
            String name = nameField.getText();
            String location = locationField.getText();
            Utils.insertItem(new Item(id, name, location, true, 20));
            JOptionPane.showMessageDialog(null, "Add Success");
        });

        itemIdComboBox_disable = new JComboBox<>();
        itemIdComboBox_disable.setBounds(45, 240, 215, 35);
        panel.add(itemIdComboBox_disable);

        JButton enableButton = new JButton("Enable");
        enableButton.setBounds(260, 240, 75, 32);
        panel.add(enableButton);

        itemIdComboBox_enable = new JComboBox<>();
        itemIdComboBox_enable.setBounds(45, 280, 215, 35);
        panel.add(itemIdComboBox_enable);

        JButton disableButton = new JButton("Disable");
        disableButton.setBounds(260, 280, 75, 32);
        panel.add(disableButton);

        refreshItemIdComboBoxes();
        enableButton.addActionListener(event -> {
            Map<String, Item> id2ItemMap = items.stream()
                    .collect(Collectors.toMap(Item::getId, Function.identity()));
            if (itemIdComboBox_disable.getSelectedItem() == null) {
                return;
            }
            String str = itemIdComboBox_disable.getSelectedItem().toString();
            if (id2ItemMap.containsKey(str)) {
                Item item = id2ItemMap.get(str);
                item.setCanRent(true);
                Utils.rewriteItemInfo(items);
                JOptionPane.showMessageDialog(null, "Success");
                refreshItemIdComboBoxes();
            }
        });
        disableButton.addActionListener(event -> {
            Map<String, Item> id2ItemMap = items.stream()
                    .collect(Collectors.toMap(Item::getId, Function.identity()));
            if (itemIdComboBox_enable.getSelectedItem() == null) {
                return;
            }
            String str = itemIdComboBox_enable.getSelectedItem().toString();
            if (id2ItemMap.containsKey(str)) {
                Item item = id2ItemMap.get(str);
                item.setCanRent(false);
                Utils.rewriteItemInfo(items);
                JOptionPane.showMessageDialog(null, "Success");
                refreshItemIdComboBoxes();
            }
        });

        JTextArea requestTextbookArea = new JTextArea();
        requestTextbookArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(requestTextbookArea);
        scrollPane.setBounds(355, 205, 360, 125);
        panel.add(scrollPane);

        requestTextbookArea.setText("\t-- Request Textbook --\nName\tType\n");
        List<RequestRecord> requestRecords = Utils.getAllRequest();
        for (RequestRecord requestRecord : requestRecords) {
            if (requestRecord != null && "textbook".equals(requestRecord.getType())) {
                requestTextbookArea.append(requestRecord.getName() + "\t" + requestRecord.getType() + "\n");
            }
        }

        return panel;
    }

    private void refreshItemIdComboBoxes() {
        items = Utils.getAllItem();
        itemIdComboBox_enable.removeAllItems();
        itemIdComboBox_disable.removeAllItems();
        for (Item item : items) {
            Boolean canRent = item.getCanRent();
            if (canRent == null) {
                continue;
            }
            if (canRent) {
                itemIdComboBox_enable.addItem(item.getId());
            } else {
                itemIdComboBox_disable.addItem(item.getId());
            }
        }
    }

    private void refreshNeedValidUserComboBox() {
        users = Utils.getAllUser();
        needValidUserComboBox.removeAllItems();
        for (User user : users) {
            if (!user.getUsing()) {
                needValidUserComboBox.addItem(user.getEmail());
            }
        }
    }
}
