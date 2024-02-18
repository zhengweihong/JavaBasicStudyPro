package P15_Bridge;

import P15_Bridge.Behavior.*;
import P15_Bridge.Behavior.Impl.Attack;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 游戏玩家的角色
 */
public class Player {
    public void attack(Player other) {
        Behavior behavior = new Walk(new Attack());
        calculate(other, behavior);
    }

    private void calculate(Player other, Behavior behavior) {
        System.out.println(this);
        System.out.println(behavior);
        System.out.println(behavior.getImpl());
        System.out.println(other);
    }
}
