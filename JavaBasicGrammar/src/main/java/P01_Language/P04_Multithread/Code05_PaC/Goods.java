package P01_Language.P04_Multithread.Code05_PaC;

public class Goods {
	//默认不存在商品
	private boolean flag = false;
	
	private String brand;//品牌
	private String name;
	
	//product good
	public synchronized void set(String brand,String name) {
		//抢占到资源发现有商品，需要提醒消费者消费，同时
		//当前线程进入阻塞状态，等待消费后再生产
		if(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.setBrand(brand);
		this.setName(name);
		System.out.println("生产者生产了"+this.toString());
		
		flag = true;
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		notify();
	}
	
	//consume good
	public synchronized void get() {
		if(!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("消费者消费了"+this.toString());
		
		flag = false;
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		notify();
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Goods [brand=" + brand + ", name=" + name + "]";
	}
}
