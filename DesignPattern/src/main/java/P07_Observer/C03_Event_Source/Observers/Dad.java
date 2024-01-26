package P07_Observer.C03_Event_Source.Observers;

import P07_Observer.C03_Event_Source.Observer;
import P07_Observer.C03_Event_Source.Events.WakeUpEvent;

/**
 * @author : ZWH
 * @date : 2024/01/26
 * @Description : 观察者
 */
public class Dad implements Observer {
    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        feed();
    }

    public void feed() {
        System.out.println("dad feed");
    }
}
