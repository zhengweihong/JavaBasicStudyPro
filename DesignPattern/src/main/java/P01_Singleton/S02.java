package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：饿汉式，使用静态语句块
 */
public class S02 {
    private static final S02 INSTANCE;

    static {
        INSTANCE = new S02();
    }

    private S02() {
    }

    public static S02 getInstance() {
        return INSTANCE;
    }
}
