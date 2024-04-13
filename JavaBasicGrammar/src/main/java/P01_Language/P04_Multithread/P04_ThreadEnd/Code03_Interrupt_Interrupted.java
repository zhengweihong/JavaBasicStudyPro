package P01_Language.P04_Multithread.P04_ThreadEnd;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZWH
 * @date : 2024/04/13
 * @Description : 线程优雅结束：interrupt
 */
public class Code03_Interrupt_Interrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.interrupted()) {
                // 没被interrupt就继续原地循环
            }
            System.out.println("t end");
        });

        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }

}
