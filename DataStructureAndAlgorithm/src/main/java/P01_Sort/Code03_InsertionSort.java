package P01_Sort;

/**
 * @author : ZWH
 * @date : 2021/05/17
 * @Description : sort from small to big 插入排序
 */
public class Code03_InsertionSort {

    public void insertionSort(int[] arr) {
        // 判空 0或1个元素
        if (arr == null || arr.length < 2) {
            return;
        }

        // 目的0~0；0~1、0~i、0~N-1有序 i是要排的数开始的位置，然后此数向左滑动
        for (int i = 1; i < arr.length; i++) {
            // stop=at 0/left smaller
            // 从右往左比较 左边数大就可以交换
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}