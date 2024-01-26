package P07_Observer.C03_Event_Source;

import P07_Observer.C03_Event_Source.Events.WakeUpEvent;
import P07_Observer.C03_Event_Source.Observers.Dad;
import P07_Observer.C03_Event_Source.Observers.Mum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZWH
 * @date : 2024/01/25
 * @Description : 会哭的孩子
 */
public class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
    }

    public void wakeUp() {
        System.out.println("Wake up! wa wa wa...");
        this.cry = true;

        WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(), "bed", this);
        for (Observer observer : observers) {
            observer.actionOnWakeUp(wakeUpEvent);
        }
    }
}
