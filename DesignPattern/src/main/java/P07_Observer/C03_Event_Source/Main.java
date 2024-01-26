package P07_Observer.C03_Event_Source;

/**
 * @author : ZWH
 * @date : 2024/01/25
 * @Description : 观察者模式：测试，加入事件快照，并在处理事件时传入有事件源对象的快照，抽象出事件族
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
