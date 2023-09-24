package P01_Sort;

/**
 * @author : ZWH
 * @date : 2021/05/17
 * @Description : sort from small to big 冒泡排序
 */
public class Code02_BubbleSort {

    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0~N-1、0～N-2、...、0～1
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}