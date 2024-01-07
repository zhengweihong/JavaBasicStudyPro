package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：测试
 */
public class Main {

    private S09 s09;

    public static void main(String[] args) {
        /**
         * 饿汉式
         *
         * 如何保证单例/实例唯一性：
         * 构造方法private，类外部不能new
         *      new S01();
         *      编译器报错'S01()' has private access in 'P01_Singleton.S01'
         * JVM保证每一个class只会load到内存一次
         *      static静态的变量当类到内存时会立刻初始化，INSTANCE只在此时初始化一次
         *      final保证初始化后不被修改
         *
         * 如何保证线程安全、防止反射：final
         *
         * 缺点：类加载时就生成实例了，不管用没用到，可能浪费资源（非懒加载）
         */
        // 方便的用于流API
        Runnable getInstance = S01::getInstance;
        S01 s01 = S01.getInstance();
        // 证明内存中的确只一个实例 输出true
        S01 s01Compare = S01.getInstance();
        System.out.println(s01 == s01Compare);
        /**
         * 饿汉式1 & 3区别
         * 1：getInstance()是static，能直接被其他类调用
         * 3：INSTANCE虽然是public，但final不能被改
         */
        S03 s03 = S03.INSTANCE;

        // 懒汉式加锁
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(
                    S05.getInstance().hashCode()
            )).start();
        }

        // 懒汉式加锁二次判空
        S07 s07 = S07.getInstance();

        /**
         * 静态内部类方式
         *
         * 单例：
         * 构造方法private，类外部不能new
         * JVM保证每一个class只会load到内存一次
         *      静态内部类的静态变量当getInstance()调用时初始化一次
         *
         * 懒加载：
         * 类load时，静态内部类不会被load，当getInstance()调用时静态内部类的静态变量才会加载
         *
         * 线程安全、防止反射：final
         */
        S08 s08 = S08.getInstance();

        /**
         * 枚举式
         *
         * 单例：
         * 一个枚举类
         *      枚举类没有构造方法
         *
         * 懒加载：？
         *
         * 线程安全、防止反射、防止反序列化：
         * 反射反编译后abstract class，枚举类没有构造方法
         */
        S09 s09 = S09.INSTANCE;
        System.out.println(s09.getField());
    }

}
