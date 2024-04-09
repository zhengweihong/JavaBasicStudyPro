package P28_202403151300;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ShoppingFrame extends JFrame {
    public ShoppingFrame() {
        int shoppingFrameWidth = 800;
        int shoppingFrameHeight = 600;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - shoppingFrameWidth) / 2, (screenSize.height - shoppingFrameHeight) / 2, shoppingFrameWidth, shoppingFrameHeight);
        this.setTitle("YorkU Library Management - Shopping");

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        JLabel productLabel = new JLabel("Discounted Purchases :");
        productLabel.setBounds(30, 60, 155, 35);
        contentPane.add(productLabel);

        JComboBox<String> productComboBox = new JComboBox<>();
        productComboBox.setBounds(180, 60, 215, 35);
        contentPane.add(productComboBox);

        Map<String, DiscountedPurchase> discountedPurchases = Utils.getAllDiscountedPurchaseMap();
        for (Map.Entry<String, DiscountedPurchase> entry : discountedPurchases.entrySet()) {
            productComboBox.addItem(entry.getValue().getName());
        }

        JLabel paymentMethodLabel = new JLabel("Payment Method :");
        paymentMethodLabel.setBounds(30, 100, 155, 35);
        contentPane.add(paymentMethodLabel);

        JComboBox<String> paymentMethodComboBox = new JComboBox<>();
        paymentMethodComboBox.setBounds(180, 100, 215, 35);
        paymentMethodComboBox.addItem("Debit");
        paymentMethodComboBox.addItem("Credit");
        paymentMethodComboBox.addItem("Mobile Wallet");
        contentPane.add(paymentMethodComboBox);

        JButton paymentButton = new JButton("Payment");
        paymentButton.setBounds(120, 150, 65, 35);
        contentPane.add(paymentButton);
        paymentButton.addActionListener(event -> {
            String name = productComboBox.getSelectedItem().toString();
            if (discountedPurchases.containsKey(name)) {
                DiscountedPurchase discountedPurchase = discountedPurchases.get(name);
                JOptionPane.showMessageDialog(this, "$" + discountedPurchase.getDiscount() * discountedPurchase.getPrice() + " Payment Success");
                this.dispose();
            }
        });
    }
}
