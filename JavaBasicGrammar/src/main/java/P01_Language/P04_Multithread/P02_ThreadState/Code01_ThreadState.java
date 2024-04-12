package P01_Language.P04_Multithread.P02_ThreadState;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * @author : ZWH
 * @date : 2024/04/09
 * @Description : 线程生命周期：6种线程状态
 */
public class Code01_ThreadState {

    public static void main(String[] args) throws Exception {
        // 先看下状态，3回合同一行-睡1s打印i，换行
        Thread t1 = new Thread(() -> {
            System.out.println("2: " + Thread.currentThread().getState());
            for (int i = 0; i < 3; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print(i + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        });

        System.out.println("1: " + t1.getState());
        t1.start();
        t1.join();
        System.out.println("3: " + t1.getState());
        /*
         * 1: NEW
         *      刚new出来没start
         * 2: RUNNABLE
         *      start开始执行
         * 3: TERMINATED
         *      join起作用让t1执行完成
         */

        // 阻塞，打印，睡眠
        Thread t2 = new Thread(() -> {
            try {
                LockSupport.park();
                System.out.println("t2 continue");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("4: " + t2.getState());
        LockSupport.unpark(t2);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("5: " + t2.getState());
        /*
         * 4: WAITING
         *      LockSupport.park()
         * 5: TIMED_WAITING
         *      t2睡眠中
         */

        final Object o = new Object();
        // 获取锁，打印
        Thread t3 = new Thread(() -> {
            synchronized (o) {
                System.out.println("t3 get object lock");
            }
        });
        // 获取锁，持有
        Thread t4 = new Thread(() -> {
            synchronized (o) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 比t3先获取锁，持有
        t4.start();
        TimeUnit.SECONDS.sleep(1);
        // 拿不到锁
        t3.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("6: " + t3.getState());
        /*
         * 6: BLOCKED
         *      只拿不到synchronized的锁
         */

        final Lock lock = new ReentrantLock();
        // 获取锁，打印，释放锁
        Thread t5 = new Thread(() -> {
            // 省略try finally
            lock.lock();
            System.out.println("t5 get lock");
            lock.unlock();
        });
        // 获取锁，睡眠，释放锁
        Thread t6 = new Thread(() -> {
            try {
                lock.lock();
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        // 比t5先获取锁，持有
        t6.start();
        TimeUnit.SECONDS.sleep(1);
        // 拿不到锁
        t5.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("7: " + t5.getState());
        /*
         * 7: WAITING
         *      拿不到非synchronized的锁
         *      JUC包的Lock用CAS实现，拿不到就忙等待WAITING
         *      不会进BLOCKED状态
         */
    }

}
