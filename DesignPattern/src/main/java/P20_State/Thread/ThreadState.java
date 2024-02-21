package P20_State.Thread;

/**
 * @author : ZWH
 * @date : 2024/02/22
 * @Description : 抽象状态类
 */
public abstract class ThreadState {
    public abstract void move(Action action);
    public abstract void run();
}
