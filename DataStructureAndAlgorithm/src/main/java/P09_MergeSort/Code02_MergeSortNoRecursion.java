package P09_MergeSort;

/**
 * @author : ZWH
 * @date : 2023/11/10
 * @Description : 归并排序非递归版
 */
public class Code02_MergeSortNoRecursion {

    public void mergeSortNoRecursion(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int mergeSize = 1;
        while (mergeSize < arr.length) {
            // 当前步长的每个左组第一个位置
            int lPoint = 0;
            // l...mid  mid+1...r
            while (lPoint < arr.length) {
                int mid = lPoint + mergeSize - 1;
                // 左组不够，不用左右组合并了
                if (mid >= arr.length) {
                    break;
                }
                int r = Math.min(mid + mergeSize, arr.length - 1);
                new Code01_MergeSortOnRecursion().merge(arr, lPoint, mid, r);
                lPoint = r + 1;
            }

            // 步长乘2，防溢出Integer.MAX_VALUE
            if (mergeSize > arr.length / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

}
