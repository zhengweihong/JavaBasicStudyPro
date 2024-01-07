package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：懒汉式，加锁+减少同步代码块提高效率+锁内二次判空，线程安全
 */
public class S07 {
    /**
     * 是否需要volatile：说是因为JIT的指令重排导致不加会多线程调用有问题
     */
    private static S07 INSTANCE;

    private S07() {
    }

    public static S07 getInstance() {
        if (INSTANCE == null) {
            synchronized (S07.class) {
                if (INSTANCE == null) {
                    INSTANCE = new S07();
                }
            }
        }
        return INSTANCE;
    }
}
