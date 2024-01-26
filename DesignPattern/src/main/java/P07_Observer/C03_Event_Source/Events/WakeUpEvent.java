package P07_Observer.C03_Event_Source.Events;

import P07_Observer.C03_Event_Source.Child;
import P07_Observer.C03_Event_Source.Event;

/**
 * @author : ZWH
 * @date : 2024/01/26
 * @Description : 事件类：发出事件的瞬时记录，Fire Event
 */
public class WakeUpEvent extends Event<Child> {
    private long timeStamp;
    private String location;
    private Child source;

    public WakeUpEvent(long timeStamp, String location, Child source) {
        this.timeStamp = timeStamp;
        this.location = location;
        this.source = source;
    }

    @Override
    public Child getSource() {
        return source;
    }
}
