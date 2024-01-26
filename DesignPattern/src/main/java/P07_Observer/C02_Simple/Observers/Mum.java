package P07_Observer.C02_Simple.Observers;

import P07_Observer.C02_Simple.Observer;

/**
 * @author : ZWH
 * @date : 2024/01/26
 * @Description : 观察者
 */
public class Mum implements Observer {
    @Override
    public void actionOnWakeUp() {
        hug();
    }

    public void hug() {
        System.out.println("mum hug");
    }
}
