package P01_Language.P04_Multithread.P03_Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZWH
 * @date : 2024/04/12
 * @Description : 标志位：sleep中被唤醒
 */
public class Code03_Interrupt_Sleep {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread InterruptedException");
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });

        t.start();
        TimeUnit.SECONDS.sleep(3);
        t.interrupt();
    }

}
