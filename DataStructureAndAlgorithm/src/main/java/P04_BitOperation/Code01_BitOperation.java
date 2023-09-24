package P04_BitOperation;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description :
 */
public class Code01_BitOperation {
    public static void main(String[] args) {
        //2^31=2,147,483,648
        int a = Integer.MAX_VALUE;//2^31-1
        System.out.println(a);
        new Code02_PrintBit32().printBit32(a);//最高位符号位
        int b = Integer.MIN_VALUE;//-2^31
        System.out.println(b);
        new Code02_PrintBit32().printBit32(b);

        System.out.println();

        //>>\>>>
        new Code02_PrintBit32().printBit32(b >> 1);
        new Code02_PrintBit32().printBit32(b >> 2);
        new Code02_PrintBit32().printBit32(b >> 3);
        new Code02_PrintBit32().printBit32(b >>> 3);//经过位置置0

        System.out.println();


        //与& 或| 非~ 异或^
        System.out.println(~1);//-2
        new Code02_PrintBit32().printBit32(~1);//符号位也变

        //原 反~ 补~+1；补码原因：模
        System.out.println(~1 + 1);//-1：~a+1 == -a
        new Code02_PrintBit32().printBit32(~1 + 1);
        new Code02_PrintBit32().printBit32((~1 + 1) + 1);//得到模

        //~a+1 == -a
        System.out.println(-1);
        new Code02_PrintBit32().printBit32(-1);

        System.out.println();

        //提取int类型整数：二进制形式的最右侧的1
        int num = 88;
        new Code02_PrintBit32().printBit32(num);
        new Code02_PrintBit32().printBit32(num & (-num));
        new Code02_PrintBit32().printBit32(num & (~num + 1));
    }
}