package P02_Strategy.Comparable;

import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : ZWH
 * @date : 2024/01/08
 * @Description : 猫
 */
@Getter
@Setter
public class Cat implements Comparable<Cat> {
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

    @Override
    public int compareTo(Cat c) {
        if (this.weight > c.weight) {
            // this大
            return 1;
        } else if (this.weight < c.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
