package P04_BitOperation;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description : 异或运算：
 */
public class Code04_XORFindAppearOddTime {
    public void XORFindAppearOddTime1(int[] arr) {
        int oddNum = 0;
        for (int i = 0; i < arr.length; i++) {
            oddNum ^= arr[i];
        }
        System.out.println(oddNum);
    }

    public void XORFindAppearOddTime2(int[] arr) {
        int oddNumXOR = 0;
        for (int i = 0; i < arr.length; i++) {
            oddNumXOR ^= arr[i];
        }

        int rightOne = oddNumXOR & (-oddNumXOR);

        int oddNum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                oddNum1 ^= arr[i];
            }
        }
        System.out.println(oddNum1 + " " + (oddNumXOR ^ oddNum1));
    }
}