package P01_2021042680.Q01;

import javax.swing.*;

/**
 * @author : ZWH 2021/4/26
 * @version : 1.0
 */
public class DialogBox {
    public static void main(String[] args) {
        DialogBox dialogBox = new DialogBox();
        dialogBox.checkSGDAmount();
    }

    public void checkSGDAmount() {
        double SGDAmount;
        while (true) {
            SGDAmount = inputSGDAmount();
            if (SGDAmount < 0.0) {
                JOptionPane.showMessageDialog(null,"The SGD amount should be greater than zero");
            } else {
                return;
            }
        }
    }

    private double inputSGDAmount() {
        String result = JOptionPane.showInputDialog("Input the SGD Amount");

        if (result != null && result.length() > 0) {
            int input = JOptionPane.showConfirmDialog(null, "The input is: " + result + ", is it correct?");
            if (0 == input) {
                return Double.parseDouble(result);
            }
        }
        return 0.0;
    }
}