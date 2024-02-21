package P20_State.State;

/**
 * @author : ZWH
 * @date : 2024/02/21
 * @Description : 状态模式，测试
 */
public class Main {
    public static void main(String[] args) {
        PersonState state = new PersonHappyState();
        Person person = new Person("zhangsan", state);
        person.say();
        person.learn();
        person.sing();
    }
}
