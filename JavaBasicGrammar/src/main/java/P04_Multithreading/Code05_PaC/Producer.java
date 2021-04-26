package P04_Multithreading.Code05_PaC;

public class Producer implements Runnable{
	
	private Goods goods;
	
	public Producer(Goods goods) {
		this.goods = goods;
	}

	@Override
	public void run() {
		for(int i=0;i<5;i++) {//模拟不断生产的过程
			if(i%2==0) {
				goods.set("哇哈哈","矿泉水");
			} else {
				goods.set("康师傅","冰红茶");
			}
		}
	}

}
