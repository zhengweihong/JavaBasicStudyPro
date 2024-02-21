package P20_State.Thread.States;

import P20_State.Thread.*;
import P20_State.Thread.Thread;

/**
 * @author : ZWH
 * @date : 2024/02/22
 * @Description : 结束
 */
public class TerminatedState extends ThreadState {
    private Thread t;

    public TerminatedState(Thread t) {
        this.t = t;
    }

    @Override
    public void move(Action action) {

    }

    @Override
    public void run() {

    }
}
