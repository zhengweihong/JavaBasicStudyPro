package P20_State.Thread;

/**
 * @author : ZWH
 * @date : 2024/02/22
 * @Description : 线程
 */
public class Thread {
    public ThreadState state;

    public void move(Action action) {
        state.move(action);
    }

    public void run() {
        state.run();
    }
}
