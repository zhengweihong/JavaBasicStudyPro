package P00_OldClass;

public class Code06_RandomMapping {

	public static void main(String[] args) {
		
	}
	
	//假定一个黑盒函数，返回等概率的int的1-5
	public static int f() {
		return ((int)Math.random() * 5) + 1;//+1!!!
	}

}
