package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：饿汉式，静态工厂方法，《Effective Java》第3条
 */
public class S01 {
    private static final S01 INSTANCE = new S01();

    private S01() {
    }

    public static S01 getInstance() {
        return INSTANCE;
    }
}
