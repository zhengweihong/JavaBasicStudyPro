package P17_Prototype.DeepCopy;

/**
 * @author : ZWH
 * @date : 2024/02/20
 * @Description : 原型模式，测试
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Cat c1 = new Cat();
        c1.name = "miaomiao";
        c1.age = 1;
        c1.location = new Location(4, 5);

        Cat c2 = (Cat) c1.clone();

        // false 深拷贝，所以引用不同
        System.out.println(c1.location == c2.location);

        c1.location.x = 77;
        // 复制出来的4
        System.out.println(c2.location.x);
    }
}
