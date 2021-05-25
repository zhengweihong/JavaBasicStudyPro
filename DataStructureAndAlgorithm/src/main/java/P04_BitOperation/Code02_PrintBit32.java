package P04_BitOperation;

/**
 * @author : ZWH 2021/5/25
 * @version : 1.0
 */
public class Code02_PrintBit32 {
    public void printBit32 (int num) {
        for (int i = 31; i >=0 ; i--) {
            System.out.print((num >> i) & 1);
            //System.out.print( (num&(1<<i)) == 0 ? "0" : "1" );//1从最高位开始与运算
        }
        System.out.println();
    }
}
