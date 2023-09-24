package P03_BinarySearch;

/**
 * @author : ZWH
 * @date : 2021/05/17
 * @Description : 二分法：有序数组，找某个数是否存在
 */
public class Code01_BinarySearchExist {

    public static boolean binarySearchExist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int L = 0;
        int R = sortedArr.length - 1;
        int mid;

        // 停止条件：L～R至少1个数
        while (L <= R) {
            // 直接加除会溢出：mid = (L + R)/2;
            // 优化除法：     L + (R - L)/2
            mid = L + ((R - L) >> 1);

            // L...mid...R
            // L..R
            //        L..R
            if (sortedArr[mid] == num) {
                // 直接找到
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        // 如果while(L<R)，L～R至少2个数，L==R的时候停止循环，需要单独判断最后一个数是否是num
        // return sortedArr[L] == num;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(binarySearchExist(new int[]{1, 2, 3, 4, 5, 6}, 0));
    }

}