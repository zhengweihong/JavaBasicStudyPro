package P01_Language.P01_BasicGrammar.C03_EnumDemo;

/**
 * @author : ZWH 2021/4/26
 * @version : 1.0
 */
public class EnumDemo {
    public static void main(String[] args) {
        //enum elements' index from 0
        Color c1 = Color.GREEN;

        System.out.println(c1.name());
        System.out.println(c1.ordinal());
        System.out.println(Color.RED.ordinal());
        System.out.println(c1.compareTo(Color.RED));
        System.out.println(c1.equals(Color.RED));
    }
}
