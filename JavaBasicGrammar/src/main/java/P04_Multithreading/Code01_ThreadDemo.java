package P04_Multithreading;

public class Code01_ThreadDemo {
	
	private static class T1 extends Thread {
		@Override
		public void run() {
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+"---"+i);
			}
		}
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//new T1.run();//方法调用不能开启线程
		
		//new创建新的线程，之后就是个不能回头的过程了
		T1 t = new T1();t.start();//等价下边
		new T1().start();
		
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+"==="+i);
		}
	}
}
