package P01_Language.P04_Multithread.Code05_PaC_JUCDemo;

import java.util.concurrent.*;

public class ConsumerQueue implements Runnable{
	
	private BlockingQueue<Goods> bq;
	
	public ConsumerQueue(BlockingQueue<Goods> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {//模拟不断消费的过程
			try {
				Goods good = bq.take();
				System.out.println("消费者消费了"+good.toString());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
