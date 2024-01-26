package P07_Observer.C03_Event_Source;

/**
 * @author : ZWH
 * @date : 2024/01/26
 * @Description : 事件抽象类
 */
public abstract class Event<T> {
    public abstract T getSource();
}
