package P00_OldClass;

public class Code05_RandomDemo {

	public static void main(String[] args) {
		//对数器
		//Math.random()返回：double [0,1) 等概率！
		double test = Math.random() * 8;	//[0,8)
		int testInt = (int)test;			//[0,7]
		System.out.println(testInt);
	}
	
	/**
	 * @return
	 * 		[0,1)的一个小数，[0,x)的数原本出现概率是x，变为x平方
	 * 		2次独立行为都保证在[0,x)，结果才能在[0,x)
	 * 
	 * 		若变成min：[0,x)概率是（1-x）平方，因为出现>x的概率是x
	 */
	public static double xToXPower2() {
		return Math.max(Math.random(),Math.random());
	}

}