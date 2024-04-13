package P01_Language.P04_Multithread.Z;

public class Code04_SyncroDemo1_BuyTicket implements Runnable{
	
	private int ticket = 5;

	@Override
	public void run() {
		//模拟不断抢票过程
		for(int i=0;i<100;i++) {
			synchronized(this) {
				if(ticket>0) {
					System.out.println(Thread.currentThread().getName()+"正在抢第"+(ticket--)+"张票");
				}
			}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Code04_SyncroDemo1_BuyTicket sbt = new Code04_SyncroDemo1_BuyTicket();
		Thread t1 = new Thread(sbt,"t1");
		Thread t2 = new Thread(sbt,"t2");
		Thread t3 = new Thread(sbt,"t3");

		t1.start();
		t2.start();
		t3.start();
	}
}
