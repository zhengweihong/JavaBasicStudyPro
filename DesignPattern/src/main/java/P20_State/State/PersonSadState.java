package P20_State.State;

/**
 * @author : ZWH
 * @date : 2024/02/22
 * @Description : 伤心
 */
public class PersonSadState extends PersonState {
    @Override
    void say() {
        System.out.println("Sad say");
    }

    @Override
    void learn() {
        System.out.println("Sad learn");
    }

    @Override
    void sing() {
        System.out.println("Sad sing");
    }
}
