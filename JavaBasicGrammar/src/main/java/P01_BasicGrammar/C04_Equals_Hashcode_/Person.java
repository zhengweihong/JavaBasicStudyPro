package P01_BasicGrammar.C04_Equals_Hashcode_;

import java.util.Objects;

/**
 * @author : ZWH 2021/4/26
 * @version : 1.0
 */
public class Person {
    //实验多属性hashcode方法写法
    private String name;
    private int age;
    private String agent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name) &&
                agent.equals(person.agent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, agent);
        //return Arrays.hashCode(values);
        //values==null return 0
        //int result = 1;result = 31 * result + (element == null ? 0 : element.hashCode());
        //public native int hashCode();
    }
}
