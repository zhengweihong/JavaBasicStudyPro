package P07_Observer.C05_Button_Action;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : 事件类：发出事件的瞬时记录
 */
public class ActionEvent {
    private long timeStamp;
    private Object source;

    public ActionEvent(long timeStamp, Object source) {
        this.timeStamp = timeStamp;
        this.source = source;
    }
}
