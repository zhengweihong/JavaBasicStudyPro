package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：懒汉式，加锁+减少同步代码块提高效率+锁内二次判空，线程安全
 */
public class S07 {
    /**
     * 需要volatile：防止new对象发生JIT指令重排，先建立引用后赋值对象内成员变量。超高并发可能发生
     */
    private static volatile S07 INSTANCE;

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
