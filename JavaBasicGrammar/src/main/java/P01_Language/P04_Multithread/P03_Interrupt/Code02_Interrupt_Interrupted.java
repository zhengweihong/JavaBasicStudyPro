package P01_Language.P04_Multithread.P03_Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZWH
 * @date : 2024/04/12
 * @Description : 标志位：设置+查询+重置
 */
public class Code02_Interrupt_Interrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (; ; ) {
                if (Thread.interrupted()) {
                    System.out.println("Thread interrupted");
                    System.out.println(Thread.interrupted());
                }
            }
        });

        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();

        // Thread.interrupted()静态方法只会查看当前线程
        System.out.println("main线程标志位：" + t.interrupted());
    }

}
