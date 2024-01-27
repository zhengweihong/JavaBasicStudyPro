package P07_Observer.C05_Button_Action;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : 观察者实现
 */
public class ButtonPressActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Button Pressed");
    }
}
