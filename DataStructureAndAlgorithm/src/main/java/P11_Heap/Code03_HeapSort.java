package P11_Heap;

/**
 * @author : ZWH
 * @date : 2024/03/27
 * @Description : sort from small to big 堆排序
 */
public class Code03_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // O(N*logN) 从上到下建堆
//        for (int i = 0; i < arr.length; i++) {
//            // O(logN)
//            heapInsert(arr, i);
//        }

        // O(N) 从下到上建堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // O(N*logN)
        for (int index = arr.length - 1; index > 0; index--) {
            swap(arr, 0, index);
            // O(logN)
            heapify(arr, 0, index);
        }
    }

    /**
     * 向大根堆添加元素
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 从大根堆删除元素
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        while (index * 2 + 1 < heapSize) {
            int largest = index * 2 + 2 < heapSize && arr[index * 2 + 2] > arr[index * 2 + 1]
                    ? index * 2 + 2 : index * 2 + 1;
            if (arr[largest] <= arr[index]) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
