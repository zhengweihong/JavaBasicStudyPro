package P03_BitOperation;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description : 打印int类型整数的32位二进制
 */
public class Code01_PrintBit32 {

    public void printBit32(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num >> i) & 1);
            //System.out.print( (num&(1<<i)) == 0 ? "0" : "1" );//1从最高位开始与运算
        }
        System.out.println();
    }

}