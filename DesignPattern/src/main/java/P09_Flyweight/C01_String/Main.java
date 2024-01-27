package P09_Flyweight.C01_String;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : 享元模式：测试
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        String s3 = new String("a");
        String s4 = new String("a");

        // true
        System.out.println(s1 == s2);
        // false
        System.out.println(s1 == s3);
        // false
        System.out.println(s3 == s4);
        // true
        System.out.println(s1 == s3.intern());
        // true
        System.out.println(s3.intern() == s4.intern());
    }
}
