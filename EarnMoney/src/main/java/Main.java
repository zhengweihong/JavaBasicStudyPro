import java.util.*;

/**
 * @author : ZWH 8/22/21
 * @version : 1.0
 */
public class Main {
    public static void main(String[] args) {
        //源代码文件 编译器 字节码文件 操作系统 二进制文件
        //.java          .class

        //int\long\byte\short
        //float\double
        //char
        //boolean

        int aInt = 8;//8位 最大2^7-1 01111111
        Integer aInteger = 5;
        System.out.println(aInteger.MAX_VALUE);

        //class\interface\数组
        //泛型
        List<Integer> aList = new ArrayList();//constructor
        aList.add(3);
        aList.add(5);
        aList.add(6);
        aList.add(2,1);
        System.out.println(aList);

        List<Person> bList = new ArrayList();
        bList.add(new Person());
        bList.add(new Person("zhangsan",20));
        System.out.println(bList);

        List<Integer> cList = new ArrayList();
        cList.add(999);

        aList.addAll(cList);
        System.out.println(aList);

        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }
        for (Integer e : aList) {
            System.out.println(e);
        }
        for (Person person : bList) {

        }

        for (Integer a :aList) {
            System.out.println(a*0.8);
            cList.add((int) (a*0.8));
        }
        System.out.println(cList);
    }
}
class Person {
    public String name;
    public int age;

    public Person() {
        this.name = "我没有名字";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}