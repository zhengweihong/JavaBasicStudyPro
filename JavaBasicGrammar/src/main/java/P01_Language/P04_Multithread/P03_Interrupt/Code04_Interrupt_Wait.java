package P01_Language.P04_Multithread.P03_Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZWH
 * @date : 2024/04/12
 * @Description : 标志位：wait中被唤醒
 */
public class Code04_Interrupt_Wait {

    public static void main(String[] args) throws InterruptedException {
        final Object o = new Object();
        Thread t = new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread InterruptedException");
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });

        t.start();
        TimeUnit.SECONDS.sleep(3);
        t.interrupt();
    }

}
