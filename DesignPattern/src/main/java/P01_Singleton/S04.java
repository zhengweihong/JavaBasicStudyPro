package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：懒汉式Lazy，按需初始化，但线程不安全
 */
public class S04 {
    private static S04 INSTANCE;

    private S04() {
    }

    public static S04 getInstance() {
        if (INSTANCE == null) {
            // 多线程访问执行到此行会有歧义
            // ThreadA：判断INSTANCE为空，没new出实例时
            // ThreadB：也判断INSTANCE为空
            // 俩线程最后都各自new出实例
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            INSTANCE = new S04();
        }
        return INSTANCE;
    }

    /**
     * 顺便复习线程 & lamda
     */
    public static void main(String[] args) {
        // 匿名内部类：new Thread().start();传入Runnable接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        }).start();

        // lamda简化掉：只有一个run方法接口的匿名内部类写法
        new Thread(() -> {
            System.out.println("lamda简化");
        }).start();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(
                    // 相同类 不同对象的hash码不同
                    S04.getInstance().hashCode()
            )).start();
        }
    }
}
