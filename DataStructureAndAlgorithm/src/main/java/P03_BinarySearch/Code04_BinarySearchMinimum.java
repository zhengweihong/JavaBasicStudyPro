package P03_BinarySearch;

/**
 * @author : ZWH 2021/5/25
 * @version : 1.0
 */
public class Code04_BinarySearchMinimum {
    public int firstMinimumIndex (int[] arr) {
        if (arr == null || arr.length == 0) return -1;//no exist

        if (arr.length == 1 || arr[0] < arr[1])
            return 0;
        if (arr[arr.length - 1] <arr[arr.length - 2])
            return arr.length - 1;

        int L = 1;
        int R = arr.length - 2;
        int mid;
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
        return -1;
    }
}
