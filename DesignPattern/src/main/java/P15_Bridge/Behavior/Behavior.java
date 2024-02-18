package P15_Bridge.Behavior;

import P15_Bridge.Behavior.Impl.BehaviorImpl;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 角色行为的抽象类
 */
public abstract class Behavior {
    BehaviorImpl impl;

    public BehaviorImpl getImpl() {
        return impl;
    }
}
