package P04_Multithreading.Code05_PaC;

public class Consumer implements Runnable{
	
	private Goods goods;
	
	public Consumer(Goods goods) {
		this.goods = goods;
	}

	@Override
	public void run() {
		for(int i=0;i<5;i++) {//模拟不断消费的过程
			goods.get();
		}
	}
	
}
