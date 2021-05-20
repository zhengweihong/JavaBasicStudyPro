package P02_Sort;

/**
 * @author : ZWH 2021/5/17
 * @version : 1.0
 * Sort : from small to big
 */
public class Code01_SelectionSort {
    public void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {//0\1
            return;
        }

        int N = arr.length;
        //0~n-1、1~n-1、2~n-1...find min
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;//arr[i]是min
            for (int j = i + 1; j < N; j++) {
                //minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
                if (arr[minValueIndex] > arr[j])
                    minValueIndex = j;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
