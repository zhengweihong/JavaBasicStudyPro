package P01_Language.P01_BasicGrammar.C08_ExceptionDemo;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        int i = -1;
        if (i < 0 || i > 10) {
            throw new IndexOutOfBoundsException();
        }
        if (i > 3 && i < 8) {
            throw new RuntimeException("可以加String");
        }
    }
}
