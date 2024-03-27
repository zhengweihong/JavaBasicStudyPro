package P11_Heap;

import java.util.PriorityQueue;

/**
 * @author : ZWH
 * @date : 2024/03/27
 * @Description : 几乎有序数组 堆排序
 */
public class Code04_HeapSortDistanceLessK {

    public void heapSortDistanceLessK(int[] arr, int k) {
        if (arr == null || arr.length < 2 || k == 0) {
            return;
        }

        int index, i;
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 滑动窗口K+1 0~K
        for (index = 0; index <= Math.min(arr.length - 1, k); index++) {
            heap.add(arr[index]);
        }

        for (i = 0; index < arr.length; i++, index++) {
            arr[i] = heap.poll();
            heap.add(arr[index]);
        }
        while (!heap.isEmpty()) {
            arr[i] = heap.poll();
            i++;
        }
    }

}
