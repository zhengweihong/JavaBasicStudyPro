package P01_Language.P04_Multithread.P03_Interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ZWH
 * @date : 2024/04/12
 * @Description : 标志位：不能干扰正在锁竞争的线程，JUC中新型锁
 */
public class Code07_Interrupt_LockInterruptibly {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("t1 InterruptedException");
            } finally {
                lock.unlock();
            }
            System.out.println("t1 end");
        });
        Thread t2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("t2 InterruptedException");
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
            System.out.println("t2 end");
        });

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        // 打断t2抢锁，t2执行结束，t1执行结束。t2没抢到过锁
        t2.interrupt();
    }

}
