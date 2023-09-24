package P04_BitOperation;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description : 异或运算：交换两数，不用额外变量
 */
public class Code03_XorSwap {
    public void xorSwap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}