package P20_State.Thread.States;

import P20_State.Thread.*;
import P20_State.Thread.Thread;

/**
 * @author : ZWH
 * @date : 2024/02/22
 * @Description : 运行
 */
public class RunningState extends ThreadState {
    private Thread t;

    public RunningState(Thread t) {
        this.t = t;
    }

    @Override
    public void move(Action action) {
        if (action.msg == "end") {
            t.state = new TerminatedState(t);
        }
    }

    @Override
    public void run() {

    }
}
