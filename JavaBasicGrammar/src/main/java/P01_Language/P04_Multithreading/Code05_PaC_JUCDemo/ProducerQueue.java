package P01_Language.P04_Multithreading.Code05_PaC_JUCDemo;

import java.util.concurrent.*;

public class ProducerQueue implements Runnable{
	
	private BlockingQueue<Goods> bq;
	
	public ProducerQueue(BlockingQueue<Goods> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {//模拟不断生产的过程
			Goods good = null;
			if(i%2==0) {
				good = new Goods("哇哈哈"+i,"矿泉水");
			} else {
				good = new Goods("康师傅"+i,"冰红茶");
			}
			System.out.println("生产者生产了"+good.toString());
			try {
				bq.put(good);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
