package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：静态内部类方式，懒加载，线程安全
 */
public class S08 {
    private static class S08Holder {
        private static final S08 INSTANCE = new S08();
    }

    private S08() {
    }

    public static S08 getInstance() {
        return S08Holder.INSTANCE;
    }
}
