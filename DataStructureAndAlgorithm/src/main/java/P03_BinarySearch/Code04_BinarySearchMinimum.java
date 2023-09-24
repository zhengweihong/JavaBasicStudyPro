package P03_BinarySearch;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description : 二分法：局部最小值问题=找极值
 */
public class Code04_BinarySearchMinimum {

    public int firstFindMinimumIndex(int[] arr) {
        // 无元素
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 边界
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int L = 1;
        int R = arr.length - 2;
        int mid;
        // 停止条件：L～R至少1个数
        while (L <= R) {
            mid = L + ((R - L) >> 1);

            if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            } else {
                return mid;
            }
        }

        // 如果while(L<R)，L～R至少2个数，L==R的时候停止循环，最后一个数就是局部最小
        // return L;
        return -1;
    }

}