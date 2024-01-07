package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：懒汉式，加锁后想减少同步代码块提高效率，但又线程不安全
 */
public class S06 {
    private static S06 INSTANCE;

    private S06() {
    }

    public static S06 getInstance() {
        if (INSTANCE == null) {
            // 多线程访问执行到此行会有歧义
            // ThreadA：判断INSTANCE为空，没加锁时
            // ThreadB：也判断INSTANCE为空，先获取到锁，new出实例
            // ThreadA：后获取到锁，也new出实例
            synchronized (S06.class) {
                INSTANCE = new S06();
            }
        }
        return INSTANCE;
    }
}
