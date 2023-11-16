package P10_MergeSort;

/**
 * @author : ZWH
 * @date : 2023/11/16
 * @Description : 归并排序-大于两倍问题
 */
public class Code05_MergeSort4BiggerTwice {

    public int biggerTwice(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeProcess(arr, 0, arr.length - 1);
    }

    /**
     * 把arr中下标l到r排有序，同时返回...数对的个数
     */
    private int mergeProcess(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeProcess(arr, l, mid)
                + mergeProcess(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    private int merge(int[] arr, int l, int mid, int r) {
        // O(N)不回退（单调性）找 大于两倍的右组元素个数 的过程
        int result = 0;
        // 右组小于2倍的元素是[mid+1,windowPoint)
        int windowPoint = mid + 1;
        // 左组遍历
        for (int i = l; i <= mid; i++) {
            // 右组推进
            while (windowPoint <= r && (long) arr[i] > 2 * (long) arr[windowPoint]) {
                windowPoint++;
            }
            result += windowPoint - (mid + 1);
        }

        int[] help = new int[r - l + 1];
        int hPoint = 0;
        int lPoint = l;
        int rPoint = mid + 1;
        // 指针没越界：比较两指针放小/相等先用左 到help数组
        while (lPoint <= mid && rPoint <= r) {
            help[hPoint++] = arr[lPoint] <= arr[rPoint] ? arr[lPoint++] : arr[rPoint++];
        }
        // 指针越界：把另一数组剩下的全放 到help数组
        while (lPoint <= mid) {
            help[hPoint++] = arr[lPoint++];
        }
        while (rPoint <= r) {
            help[hPoint++] = arr[rPoint++];
        }
        // 拷贝help回arr对应范围
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

        return result;
    }

}
