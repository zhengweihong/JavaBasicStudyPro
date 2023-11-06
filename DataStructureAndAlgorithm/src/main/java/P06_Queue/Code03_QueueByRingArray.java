package P06_Queue;

/**
 * @author : ZWH
 * @date : 2021/5/26
 * @Description : 数组实现队列
 */
public class Code03_QueueByRingArray {
    public class QueueByArray {
        private int[] arr;
        private int size;
        // poll arri
        private int start;
        // add arri
        private int end;

        public QueueByArray(int capacity) {
            arr = new int[capacity];
            size = 0;
            start = 0;
            end = 0;
        }

        /**
         * 正常+1，到边界回到0
         */
        private int nextIndex(int index) {
            return index < arr.length - 1 ? index + 1 : 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 入队
        public void add(int data) {
            if (size >= arr.length) {
                throw new RuntimeException("Full Queue!");
            }
            size++;
            arr[end] = data;
            end = nextIndex(end);
        }

        // 出队
        public int poll() {
            if (size == 0) {
                throw new RuntimeException("Empty Queue!");
            }
            size--;
            int data = arr[start];
            start = nextIndex(start);
            return data;
        }

        // 看
        public int peek() {
            if (size == 0) {
                throw new RuntimeException("Empty Queue!");
            }
            return arr[start];
        }
    }
}