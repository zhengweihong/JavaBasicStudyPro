package P07_Observer.C02_Simple.Observers;

import P07_Observer.C02_Simple.Observer;

/**
 * @author : ZWH
 * @date : 2024/01/26
 * @Description : 观察者
 */
public class Dad implements Observer {
    @Override
    public void actionOnWakeUp() {
        feed();
    }

    public void feed() {
        System.out.println("dad feed");
    }
}
