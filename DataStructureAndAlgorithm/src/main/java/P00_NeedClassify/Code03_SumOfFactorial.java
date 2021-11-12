package P00_NeedClassify;

import java.util.Scanner;

public class Code03_SumOfFactorial {

	public static void main(String[] args) {
		//阶乘累加和：算好一个阶乘可以存一下，然后下次不用再乘一遍=预处理
		
		System.out.println("累加到x的阶乘");
		Scanner scan = new Scanner(System.in);
		int N = 0;
		if(scan.hasNextInt()) {
			N = scan.nextInt();
		}
		
		long sum = 0;
		long curFactorial = 1;//的阶乘
		for(int i=0;i<N;i++) {
			curFactorial *= (i+1);
			sum += curFactorial;
			//System.out.println(curFactorial);
		}
		System.out.println(sum);
	}

}
