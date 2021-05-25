package P04_BitOperation;

/**
 * @author : ZWH 2021/5/25
 * @version : 1.0
 */
public class Code04_XORFindAppearOddTime {
    public void XORFindAppearOddTime1 (int[] arr) {
        int oddNum = 0;
        for (int i = 0; i < arr.length ; i++) {
            oddNum ^= arr[i];
        }
        System.out.println(oddNum);
    }

    public void XORFindAppearOddTime2 (int[] arr) {

    }
}
