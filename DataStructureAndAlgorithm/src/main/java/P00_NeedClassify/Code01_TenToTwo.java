package P00_NeedClassify;
import java.util.*;

public class Code01_TenToTwo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个十进制整数");
		int num = scan.nextInt();
		
		String str = "";
		while(num!=0) {
			int i = num%2;
			str = i + str;
			num /= 2;
		}
		System.out.println(str);
	}

}
