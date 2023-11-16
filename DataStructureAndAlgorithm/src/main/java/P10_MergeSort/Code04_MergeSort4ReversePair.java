package P10_MergeSort;

/**
 * @author : ZWH
 * @date : 2023/11/16
 * @Description : 归并排序-逆序对问题
 */
public class Code04_MergeSort4ReversePair {

    public int reversePair(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeProcess(arr, 0, arr.length - 1);
    }

    /**
     * 把arr中下标l到r排有序，同时返回逆序对个数
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
        int[] help = new int[r - l + 1];
        int hPoint = help.length - 1;

        int lPoint = mid;
        int rPoint = r;
        int result = 0;

        // 指针没越界：比较两指针放大/相等先用右 到help数组 加逆序对个数
        while (lPoint >= l && rPoint >= (mid + 1)) {
            result += arr[lPoint] > arr[rPoint] ? (rPoint - mid) : 0;
            help[hPoint--] = arr[lPoint] > arr[rPoint] ? arr[lPoint--] : arr[rPoint--];
        }
        // 指针越界：把另一数组剩下的全放 到help数组
        while (lPoint >= l) {
            help[hPoint--] = arr[lPoint--];
        }
        while (rPoint >= (mid + 1)) {
            help[hPoint--] = arr[rPoint--];
        }

        // 拷贝help回arr对应范围
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return result;
    }

}
