package P04_BitOperation;

/**
 * @author : ZWH 2021/5/25
 * @version : 1.0
 */
public class Code03_XORSwap {
    public void XORSwap (int[] arr,int i,int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
