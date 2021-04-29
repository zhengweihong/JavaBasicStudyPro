package P00_OldClass;

public class Code01_PrintB {
	static void printB32(int num) {//static不用实例化对象就能用
		for(int i = 31;i >= 0;i--) {
			System.out.print( (num&(1<<i)) == 0 ? "0" : "1" );//1从最高位开始与运算
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//打印数的32位的2进制
		int num = 3;
		printB32(num);
		
		//补码原因：模
		//取反
		printB32(~ num);
		//取反+1：取相反数，处理负号
		printB32(~ num + 1);
		System.out.println(~ num + 1);//被补码表示
		printB32(~(~ num + 1)+ 1);
		
		//2^31=2 147 483 648
		int a = Integer.MAX_VALUE;
		System.out.println(a);//2^31-1
		printB32(a);//最高位符号位
		int b = Integer.MIN_VALUE;
		System.out.println(b);//-2^31
		printB32(b);
		
		//与&；或|；异或^同0不同1
		
		//>>\>>>
		printB32(b>>1);
		printB32(b>>2);
		printB32(b>>3);
		printB32(b>>>3);
	}

}
