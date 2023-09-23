package P01_Sort;

/**
 * @author : ZWH
 * @date : 2021/05/17
 * @Description : sort from small to big 选择排序
 */
public class Code01_SelectionSort {

    public void selectionSort(int[] arr) {
        // 判空 0或1个元素
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0~n-1、1~n-1、2~n-1... find min
        for (int i = 0; i < arr.length; i++) {
            // arr[i]是min 以第一个下标为锚点
            int minValueIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                // 谁小成为新的锚点
                // minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
                if (arr[j] < arr[minValueIndex]) {
                    minValueIndex = j;
                }
            }

            swap(arr, i, minValueIndex);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void swapNoTemp(int[] arr, int left, int right) {
        arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[left] ^ arr[right];
        arr[left] = arr[left] ^ arr[right];
    }

}