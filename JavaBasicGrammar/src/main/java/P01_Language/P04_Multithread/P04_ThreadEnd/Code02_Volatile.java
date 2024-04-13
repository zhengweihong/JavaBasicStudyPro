package P01_Language.P04_Multithread.P04_ThreadEnd;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZWH
 * @date : 2024/04/13
 * @Description : 线程优雅结束：volatile
 */
public class Code02_Volatile {

    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            long count = 0;
            while (running) {
                count++;
            }
            // 每次停止的输出都不一样，量级差不多
            System.out.println("t end count = " + count);
        });

        t.start();
        TimeUnit.SECONDS.sleep(1);
        running = false;
    }

}
