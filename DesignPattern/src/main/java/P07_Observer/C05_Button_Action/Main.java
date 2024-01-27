package P07_Observer.C05_Button_Action;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : 观察者模式：测试，模拟Button事件监听
 */
public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(new ButtonPressActionListener());
        button.press();
    }
}
