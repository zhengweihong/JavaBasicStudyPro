package P07_Observer.C03_Event_Source;

import P07_Observer.C03_Event_Source.Events.WakeUpEvent;

/**
 * @author : ZWH
 * @date : 2024/01/26
 * @Description : 观察者抽象接口
 */
public interface Observer {
    void actionOnWakeUp(WakeUpEvent wakeUpEvent);
}
