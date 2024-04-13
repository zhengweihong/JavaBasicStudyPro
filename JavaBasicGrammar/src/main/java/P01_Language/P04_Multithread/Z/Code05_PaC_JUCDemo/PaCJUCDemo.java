package P01_Language.P04_Multithread.Z.Code05_PaC_JUCDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PaCJUCDemo {

	public static void main(String[] args) {
		BlockingQueue<Goods> bq = new ArrayBlockingQueue<Goods>(2);
		ProducerQueue pq = new ProducerQueue(bq);
		ConsumerQueue cq = new ConsumerQueue(bq);
		Thread t1 = new Thread(pq);
		Thread t2 = new Thread(cq);
		t1.start();
		t2.start();
		//另一种写法
		//new Thread(pq).start();
        //new Thread(cq).start();
	}

}
