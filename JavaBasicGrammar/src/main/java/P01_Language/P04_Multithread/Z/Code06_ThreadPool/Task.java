package P01_Language.P04_Multithread.Z.Code06_ThreadPool;

public class Task implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

}
