package P01_Language.P04_Multithreading.Code06_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorDemo {
	public static void main(String[] args) {
		//都继承Executor接口，线程池来start线程
		
		//可以线程重用，最多线程数 Integer.MAX_VALUE
		ExecutorService es1 = Executors.newCachedThreadPool();
		es1.execute(new Task());//提交任务，可以多次执行创建多个线程
		es1.shutdown();
		
		//最多容纳的线程数=参数
		ExecutorService es2 = Executors.newFixedThreadPool(5);
		es2.execute(new Task());//提交任务，可以多次执行创建多个线程
		es2.shutdown();
		
		//只一个线程
		ExecutorService es3 = Executors.newSingleThreadExecutor();
		es3.execute(new Task());//提交任务，可以多次执行创建多个线程
		es3.shutdown();
	}
}
