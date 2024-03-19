package P09_MergeSort;

/**
 * @author : ZWH
 * @date : 2023/11/30
 * @Description : 归并排序-区间和的个数
 */
public class Code06_MergeSort4CountOfRangeSum {

    public int countOfRangeSum(int[] arr, int lower, int upper) {
        // 和前边归并排序有区别，有元素就需要求和判断
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 前缀和辅助数组
        long[] preSum = new long[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        return mergeProcess(preSum, 0, arr.length - 1, lower, upper);
    }

    /**
     * 把前缀和数组中下标l到r排有序，同时返回符合区间的个数
     */
    private int mergeProcess(long[] preSum, int l, int r, int lower, int upper) {
        if (l == r) {
            // sum[0,l]是否在区间内
            if (preSum[l] >= lower && preSum[l] <= upper) {
                return 1;
            } else {
                return 0;
            }
        }
        int mid = l + ((r - l) >> 1);
        return mergeProcess(preSum, l, mid, lower, upper)
                + mergeProcess(preSum, mid + 1, r, lower, upper)
                + merge(preSum, l, mid, r, lower, upper);
    }

    private int merge(long[] preSum, int l, int mid, int r, int lower, int upper) {
        // O(N)不回退（单调性）判断 左组滑动窗口在[x-upper,x-lower]范围内的元素个数 的过程
        int result = 0;
        // [windowPointL, windowPointR)
        int windowPointL = l;
        int windowPointR = l;
        // 右组遍历
        for (int i = mid + 1; i <= r; i++) {
            long min = preSum[i] - upper;
            long max = preSum[i] - lower;
            // 左组滑动窗口边界推进
            while (windowPointL <= mid && preSum[windowPointL] < min) {
                windowPointL++;
            }
            while (windowPointR <= mid && preSum[windowPointR] <= max) {
                windowPointR++;
            }
            result += windowPointR - windowPointL;
        }

        long[] help = new long[r - l + 1];
        int hPoint = 0;
        int lPoint = l;
        int rPoint = mid + 1;
        // 指针没越界：比较两指针放小/相等先用左 到help数组
        while (lPoint <= mid && rPoint <= r) {
            help[hPoint++] = preSum[lPoint] <= preSum[rPoint] ? preSum[lPoint++] : preSum[rPoint++];
        }
        // 指针越界：把另一数组剩下的全放 到help数组
        while (lPoint <= mid) {
            help[hPoint++] = preSum[lPoint++];
        }
        while (rPoint <= r) {
            help[hPoint++] = preSum[rPoint++];
        }
        // 拷贝help回arr对应范围
        for (int i = 0; i < help.length; i++) {
            preSum[l + i] = help[i];
        }

        return result;
    }

}
