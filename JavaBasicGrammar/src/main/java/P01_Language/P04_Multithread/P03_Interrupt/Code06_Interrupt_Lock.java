package P01_Language.P04_Multithread.P03_Interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ZWH
 * @date : 2024/04/12
 * @Description : 标志位：不能干扰正在锁竞争的线程，JUC中新型锁
 */
public class Code06_Interrupt_Lock {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("t1 end");
        });
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
            } finally {
                lock.unlock();
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
