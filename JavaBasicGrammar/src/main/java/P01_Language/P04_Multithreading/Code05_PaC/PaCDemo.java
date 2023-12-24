package P01_Language.P04_Multithreading.Code05_PaC;

public class PaCDemo {

	public static void main(String[] args) {
		Goods good = new Goods();
		//P和C必须有同一个good
		Producer p1 = new Producer(good);
		Consumer c1 = new Consumer(good);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(c1);
		t1.start();
		t2.start();
	}

}
