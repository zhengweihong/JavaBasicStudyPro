package P06_Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : ZWH 2021/5/27
 * @version : 1.0
 */
public class Code05_StackByQueue {
    public class StackByQueue<T> {
        private Queue<T> queue;
        private Queue<T> helpQ;

        public StackByQueue() {
            queue = new LinkedList<>();
            helpQ = new LinkedList<>();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T pop() {
            if (queue.isEmpty())
                throw new IndexOutOfBoundsException("Empty Stack!");
            while (queue.size() > 1) {
                helpQ.offer(queue.poll());
            }
            T value = queue.poll();

            Queue<T> tempQ = queue;
            queue = helpQ;
            helpQ = tempQ;

            return value;
        }

        public T peek() {
            if (queue.isEmpty())
                throw new IndexOutOfBoundsException("Empty Stack!");
            while (queue.size() > 1) {
                helpQ.offer(queue.poll());
            }
            T value = queue.poll();
            helpQ.offer(value);
            Queue<T> tempQ = queue;
            queue = helpQ;
            helpQ = tempQ;
            return value;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
