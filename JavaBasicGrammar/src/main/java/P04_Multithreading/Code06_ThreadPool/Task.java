package P04_Multithreading.Code06_ThreadPool;

public class Task implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

}
