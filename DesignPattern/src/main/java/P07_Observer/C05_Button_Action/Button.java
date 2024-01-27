package P07_Observer.C05_Button_Action;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : 模拟AWT中Button
 */
public class Button {
    private List<ActionListener> actionListeners = new ArrayList<>();

    public void addActionListener(ActionListener actionListener) {
        actionListeners.add(actionListener);
    }

    public void press() {
        ActionEvent actionEvent = new ActionEvent(System.currentTimeMillis(), this);
        for (ActionListener actionListener : actionListeners) {
            actionListener.actionPerformed(actionEvent);
        }
    }
}
