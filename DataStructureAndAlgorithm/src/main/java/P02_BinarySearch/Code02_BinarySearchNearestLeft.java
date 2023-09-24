package P02_BinarySearch;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description : 二分法：有序数组，找>=某个数，最左的位置
 */
public class Code02_BinarySearchNearestLeft {
    //L...mid...R
    //L..R
    //       L..R
    //找>=num最左的index
    public int nearestLeftIndex(int[] sortedArr, int num) {
        int index = -1;
        if (sortedArr == null || sortedArr.length == 0) return index;

        int L = 0;
        int R = sortedArr.length - 1;
        int mid;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] >= num) {
                index = mid;
                R = mid - 1;//mid就不用再看了
            } else {
                L = mid + 1;
            }
        }

        return index;
    }

    public int leftTest(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) return -1;
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] >= num) return i;
        }
        return -1;//全数组没有>=num的
    }
}