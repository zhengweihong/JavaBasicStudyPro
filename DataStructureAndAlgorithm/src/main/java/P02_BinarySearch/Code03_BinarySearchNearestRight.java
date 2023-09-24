package P02_BinarySearch;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description : 二分法：有序数组，找<=某个数，最右的位置
 */
public class Code03_BinarySearchNearestRight {
    //L...mid...R
    //L..R
    //       L..R
    //找<=num最右的index
    public int nearestRightIndex(int[] sortedArr, int num) {
        int index = -1;
        if (sortedArr == null || sortedArr.length == 0) return index;

        int L = 0;
        int R = sortedArr.length - 1;
        int mid;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] <= num) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return index;
    }

    public int rightTest(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) return -1;
        for (int i = sortedArr.length - 1; i >= 0; i--) {
            if (sortedArr[i] <= num)
                return i;
        }
        return -1;
    }
}