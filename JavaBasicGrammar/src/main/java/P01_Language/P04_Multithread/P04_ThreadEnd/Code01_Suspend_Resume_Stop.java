package P01_Language.P04_Multithread.P04_ThreadEnd;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZWH
 * @date : 2024/04/13
 * @Description : 线程的暂停、恢复、停止，已废弃
 */
public class Code01_Suspend_Resume_Stop {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("executing");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        TimeUnit.SECONDS.sleep(2);
        t.suspend();
        TimeUnit.SECONDS.sleep(2);
        t.resume();
        TimeUnit.SECONDS.sleep(2);
        t.stop();
    }

}
