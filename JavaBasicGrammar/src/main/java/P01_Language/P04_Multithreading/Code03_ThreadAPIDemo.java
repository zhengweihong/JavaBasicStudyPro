package P01_Language.P04_Multithreading;

public class Code03_ThreadAPIDemo {

	public static void main(String[] args) {
		//获取当前主线程对象
		Thread thread = Thread.currentThread();
		
		//线程名称
		System.out.println( thread.getName() );
		//线程ID
		System.out.println( thread.getId() );
		//线程优先级(一般系统0-10，未设置为默认值5)
		System.out.println( thread.getPriority() );
		//设置线程优先级
		thread.setPriority(10);
		System.out.println( thread.getPriority() );
		/*
		 * 优先级越高，不是一定会先执行，只是先执行的概率大一些
		 */
		//判断线程是否在活动
		System.out.println( thread.isAlive() );
	}

}
