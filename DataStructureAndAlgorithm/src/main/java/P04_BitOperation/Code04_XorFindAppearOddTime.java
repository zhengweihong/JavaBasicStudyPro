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
    public void xorFindAppearOnceOddTime(int[] arr) {
        int oddNum = 0;
        for (int value : arr) {
            oddNum ^= value;
        }
        System.out.println(oddNum);
    }

    /**
     * 数组中有两种数出现了奇数次，其他数都出现了偶数次，找到并打印这两个数
     * 思路：
     * 全部异或一遍，得到oddNumXOR = a ^ b
     * 因为a、b不等，oddNumXOR != 0
     * 用a & (-a)得到oddNumXOR二进制最右边的1，即a、b二进制在这个位置数值不同一个0一个1
     * 通过这个最右边的1，可以把数组分成2类，从而分开了a和b，分开异或就行了
     */
    public void xorFindAppearSecondOddTime(int[] arr) {
        int oddNumXor = 0;
        for (int value : arr) {
            oddNumXor ^= value;
        }

        int rightOne = oddNumXor & (-oddNumXor);

        int oddNum1 = 0;
        for (int value : arr) {
            if ((value & rightOne) != 0) {
                oddNum1 ^= value;
            }
        }

        System.out.println(oddNum1 + " " + (oddNumXor ^ oddNum1));
    }

}