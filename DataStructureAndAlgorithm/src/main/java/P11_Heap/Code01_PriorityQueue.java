package P11_Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : ZWH
 * @date : 2024/03/27
 * @Description : 优先级队列
 */
public class Code01_PriorityQueue {

    public static void main(String[] args) {
        // 默认小根堆，能加重复值
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 大根堆，传入比较器
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MaxHeap());
        heap.add(5);
        heap.add(3);

        // 3/5 看一眼
        System.out.println(heap.peek());

        heap.add(7);
        heap.add(0);

        // 0/7 看一眼
        System.out.println(heap.peek());

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }

    static class MaxHeap implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

}
