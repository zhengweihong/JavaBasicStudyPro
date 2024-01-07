package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：懒汉式，加锁，线程安全
 */
public class S05 {
    private static S05 INSTANCE;

    private S05() {
    }

    /**
     * 锁this
     * 若非静态，此类实例本身
     * 因有static，锁S05.class
     */
    public static synchronized S05 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new S05();
        }
        return INSTANCE;
    }
}
