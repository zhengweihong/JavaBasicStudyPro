package P20_State.Thread.States;

import P20_State.Thread.Action;
import P20_State.Thread.Thread;
import P20_State.Thread.ThreadState;

/**
 * @author : ZWH
 * @date : 2024/02/22
 * @Description : 创建
 */
public class NewState extends ThreadState {
    private Thread t;

    public NewState(Thread t) {
        this.t = t;
    }

    @Override
    public void move(Action action) {
        if (action.msg == "start") {
            t.state = new RunningState(t);
        }
    }

    @Override
    public void run() {

    }
}
