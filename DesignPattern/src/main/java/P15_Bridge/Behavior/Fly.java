package P15_Bridge.Behavior;

import P15_Bridge.Behavior.Impl.BehaviorImpl;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 飞行
 */
public class Fly extends Behavior {
    public Fly(BehaviorImpl impl) {
        this.impl = impl;
    }
}
