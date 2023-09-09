package P100_NeedClassify;
import java.util.*;

public class Code04_FibonacciSequence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要打印的斐波那契数列的元素个数：");
		int count = scan.nextInt();
		
		//前两位是1，每个元素是前两位的和：1 1 2 3 5 8 13 21
		int x = 1;
		int y = 1;
		int z = 0;
		for(int i = 1;i <= count;i++) {
			if(i==1 || i==2) {
				System.out.print("1\t");
			}else {
				z = x + y;
				System.out.print(z+"\t");
				x = y;
				y = z;
			}
		}
		
		System.out.println();
		
		//递归写法
		for(int i = 1;i <= count;i++) {
			System.out.print(getNumber(i)+"\t");
		}
	}
	
	public static int getNumber(int i) {
		if(i==1 || i==2) {
			return 1;
		}else {
			return getNumber(i - 1) + getNumber(i - 2);
		}
	}

}
