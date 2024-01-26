package P07_Observer.C03_Event_Source.Observers;

import P07_Observer.C03_Event_Source.Observer;
import P07_Observer.C03_Event_Source.Events.WakeUpEvent;

/**
 * @author : ZWH
 * @date : 2024/01/26
 * @Description : 观察者
 */
public class Mum implements Observer {
    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        hug();
    }

    public void hug() {
        System.out.println("mum hug");
    }
}
