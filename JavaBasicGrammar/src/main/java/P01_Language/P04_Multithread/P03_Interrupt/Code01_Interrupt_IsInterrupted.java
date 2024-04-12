package P01_Language.P04_Multithread.P03_Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZWH
 * @date : 2024/04/12
 * @Description : 标志位：设置+查询
 */
public class Code01_Interrupt_IsInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (; ; ) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread isInterrupted");
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });

        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }

}
