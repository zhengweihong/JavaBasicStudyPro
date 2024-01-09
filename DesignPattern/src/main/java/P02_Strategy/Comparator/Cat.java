package P02_Strategy.Comparator;

import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 猫
 */
@Getter
@Setter
public class Cat {
    @Description("年龄")
    private int age;
    @Description("重量")
    private int weight;

    public Cat(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{age=" + age + ", weight=" + weight + '}';
    }
}
