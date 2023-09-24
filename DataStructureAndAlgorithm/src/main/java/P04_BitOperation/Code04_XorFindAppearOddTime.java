package P04_BitOperation;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description : 异或运算：找到出现奇数次的数
 */
public class Code04_XorFindAppearOddTime {

    /**
     * 数组中只有一种数出现了奇数次，其他数都出现了偶数次，找到并打印这个数
     * 所有数异或一遍，留下的值就是了
     */
    public void xorFindAppearOddTime(int[] arr) {
        int oddNum = 0;
        for (int value : arr) {
            oddNum ^= value;
        }
        System.out.println(oddNum);
    }

    public void xorFindAppearOddTime2(int[] arr) {
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