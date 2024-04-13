package P01_Language.P04_Multithread.Z.Code06_ThreadPool;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutor {

	public static void main(String[] args) {
		//Scheduled	可调度
		
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
		
		//相当于execute提交任务，延迟时间+延迟参数的时间单位
		ses.schedule(new Task(), 3, TimeUnit.SECONDS);
		//匿名内部类
		ses.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}, 3, TimeUnit.SECONDS);
		
		ses.shutdown();
	}

}
