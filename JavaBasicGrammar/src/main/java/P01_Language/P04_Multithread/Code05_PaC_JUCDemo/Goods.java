package P01_Language.P04_Multithread.Code05_PaC_JUCDemo;

public class Goods {

	private String brand;
	private String name;
	
	public Goods(String brand, String name) {
		this.brand = brand;
		this.name = name;
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
