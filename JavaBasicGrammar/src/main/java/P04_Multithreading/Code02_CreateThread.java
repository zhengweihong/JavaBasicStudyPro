package P04_Multithreading;

public class Code02_CreateThread {
	
	static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("extends Thread");
		}
	}
	
	static class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("implements Runnable");
		}
	}

	
	public static void main(String[] args) {
		new MyThread().start();
		new Thread(new MyRunnable()).start();
		new Thread(()->{
			System.out.println("Lambda-Anonymous Inner Class");
		}).start();
	}

}
