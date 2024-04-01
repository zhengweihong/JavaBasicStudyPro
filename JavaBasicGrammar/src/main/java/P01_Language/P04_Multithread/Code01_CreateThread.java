package P01_Language.P04_Multithread;

import java.util.concurrent.*;

/**
 * @author : ZWH
 * @date : 2024/03/31
 * @Description : 创建线程：5种方法
 */
public class Code01_CreateThread {

    public static void main(String[] args) {
        // 方法调用不能开启线程
        // new T1.run();

        // 继承Thread类，重写run
        new T1().start();

        // 实现Runnable接口，重写run
        new Thread(new T2()).start();

        // Lambda表达式
        new Thread(() -> System.out.println("Lambda:" + Thread.currentThread().getName()))
                .start();

        // 线程池
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(() -> System.out.println("Thread Pool:" + Thread.currentThread().getName()));

        // 实现Callable接口，重写call
        // 1、扔线程池
        Future<String> f = es.submit(new T3());
        try {
            String str = f.get();
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        es.shutdown();

        // 2、用继承Runnable的FutureTask包上后传入Thread类执行
        FutureTask<String> task = new FutureTask<>(new T3());
        new Thread(task).start();
        try {
            System.out.println(task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class T1 extends Thread {
        @Override
        public void run() {
            System.out.println("Extends Thread:" + Thread.currentThread().getName());
        }
    }

    static class T2 implements Runnable {
        @Override
        public void run() {
            System.out.println("Implements Runnable:" + Thread.currentThread().getName());
        }
    }

    static class T3 implements Callable<String> {
        @Override
        public String call() {
            System.out.println("Implements Callable:" + Thread.currentThread().getName());
            return "Success";
        }
    }

}
