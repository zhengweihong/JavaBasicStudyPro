package P11_Heap;

/**
 * @author : ZWH
 * @date : 2024/03/27
 * @Description : 对大根堆的操作
 */
public class Code02_HeapOperates {

    public static void main(String[] args) {
    }

    /**
     * 向小根堆添加元素
     *
     * @param arr   数组存储
     * @param index 新增元素的下标
     */
    private void heapInsert(int[] arr, int index) {
        // 停止条件：不比父结点小，包含index=0
        while (arr[index] < arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 从小根堆删除元素
     *
     * @param arr      数组存储
     * @param index    删除元素的下标
     * @param heapSize 堆元素个数
     */
    private void heapify(int[] arr, int index, int heapSize) {
        // 停止条件：左孩子越界
        while (index * 2 + 1 < heapSize) {
            // 选右孩子：没越界，比左孩子小
            int smallest = index * 2 + 2 < heapSize && arr[index * 2 + 2] < arr[index * 2 + 1]
                    ? index * 2 + 2 : index * 2 + 1;
            // 停止条件：不比子结点大
            if (arr[smallest] >= arr[index]) {
                break;
            }
            // index和较小孩子交换
            swap(arr, index, smallest);
            index = smallest;
        }
    }

}
