package P01_BasicGrammar.C07_StringDemo;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "string demo";
        String s2 = "string demo";

        int i = s1.compareToIgnoreCase(s2);
        System.out.println(i);
    }
}
