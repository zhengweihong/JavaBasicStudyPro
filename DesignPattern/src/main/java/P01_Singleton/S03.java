package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：饿汉式，公有域，《Effective Java》第3条
 */
public class S03 {
    public static final S03 INSTANCE = new S03();

    private S03() {
    }
}
