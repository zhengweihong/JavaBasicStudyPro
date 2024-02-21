package P20_State.State;

/**
 * @author : ZWH
 * @date : 2024/02/22
 * @Description : 和状态类结合
 */
public class Person {
    private String name;
    private PersonState state;

    public Person(String name, PersonState state) {
        this.name = name;
        this.state = state;
    }

    public void say() {
        state.say();
    }

    public void learn() {
        state.learn();
    }

    public void sing() {
        state.sing();
    }
}
