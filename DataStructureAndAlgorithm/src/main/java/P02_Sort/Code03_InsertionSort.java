package P02_Sort;

/**
 * @author : ZWH 2021/5/17
 * @version : 1.0
 * from small to big
 */
public class Code03_InsertionSort {
    public void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        //0~0；0~1、0~i、0~N-1内部有序，i要排的数开始的位置
        for (int i = 1; i < arr.length; i++) {
            //stop=at 0/left small
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
