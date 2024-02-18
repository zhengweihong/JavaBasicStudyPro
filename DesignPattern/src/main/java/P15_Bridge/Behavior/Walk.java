package P15_Bridge.Behavior;

import P15_Bridge.Behavior.Impl.BehaviorImpl;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 走路
 */
public class Walk extends Behavior {
    public Walk(BehaviorImpl impl) {
        this.impl = impl;
    }
}
