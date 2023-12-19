package P09_MergeSort;

/**
 * @author : ZWH
 * @date : 2023/11/09
 * @Description : 归并排序递归版
 */
public class Code01_MergeSortOnRecursion {

    public void mergeSortOnRecursion(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeProcess(arr, 0, arr.length - 1);
    }

    /**
     * 把arr中下标l到r排有序
     */
    private void mergeProcess(int[] arr, int l, int r) {
        // 停止条件
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeProcess(arr, l, mid);
        mergeProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int hPoint = 0;

        int lPoint = l;
        int rPoint = mid + 1;
        // 指针没越界：比较两指针放小/相等先用左 到help数组
        while (lPoint <= mid && rPoint <= r) {
            /* 替代写法
            help[hPoint++] = arr[lPoint] <= arr[rPoint] ? arr[lPoint++] : arr[rPoint++];
             */
            if (arr[lPoint] <= arr[rPoint]) {
                help[hPoint] = arr[lPoint];
                lPoint++;
            } else {
                help[hPoint] = arr[rPoint];
                rPoint++;
            }
            hPoint++;
        }
        // 指针越界：把另一数组剩下的全放 到help数组
        // 俩循环只会触发一个
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
    }

}
