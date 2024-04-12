package P01_Language.P04_Multithread.P03_Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZWH
 * @date : 2024/04/12
 * @Description : 标志位：不能干扰正在锁竞争的线程，synchronized
 */
public class Code05_Interrupt_Sync {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 end");
        });
        Thread t2 = new Thread(() -> {
            synchronized (o) {
            }
            System.out.println("t2 end");
        });

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        // t2会一直在抢锁，直到t1释放锁后才抢到
        t2.interrupt();
    }

}
