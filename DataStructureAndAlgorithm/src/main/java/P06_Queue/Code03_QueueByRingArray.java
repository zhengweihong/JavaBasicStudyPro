package P06_Queue;

/**
 * @author : ZWH 2021/5/26
 * @version : 1.0
 */
public class Code03_QueueByRingArray {
    public class MyQueue {
        private int[] arr;
        private int start;//pop
        private int end;//push
        private int size;
        private final int capacity;

        public MyQueue (int capacity) {
            arr = new int[capacity];
            start = 0;
            end = 0;
            size = 0;
            this.capacity = capacity;
        }

        private int nextIndex (int index) {
            return index < capacity-1 ? index+1 : 0;
        }

        public void push (int value) {
            if (size == capacity) throw new IndexOutOfBoundsException("Full Queue!");
            size++;
            arr[end] = value;
            end = nextIndex(end);
        }

        public int pop () {
            if (size == 0) throw new IndexOutOfBoundsException("Empty Queue!");
            size--;
            int popData = arr[start];
            start = nextIndex(start);
            return popData;
        }

        public boolean isEmpty () {
            return size == 0;
        }
    }
}
