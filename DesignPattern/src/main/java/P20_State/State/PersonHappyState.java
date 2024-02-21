package P20_State.State;

/**
 * @author : ZWH
 * @date : 2024/02/22
 * @Description : 开心
 */
public class PersonHappyState extends PersonState {
    @Override
    void say() {
        System.out.println("Happy say");
    }

    @Override
    void learn() {
        System.out.println("Happy learn");
    }

    @Override
    void sing() {
        System.out.println("Happy sing");
    }
}
