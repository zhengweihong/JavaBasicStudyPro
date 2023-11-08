package P05_Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : ZWH
 * @date : 2021/5/27
 * @Description : 队列实现栈
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
            if (queue.isEmpty()) {
                throw new RuntimeException("Empty Stack!");
            }

            while (queue.size() > 1) {
                helpQ.offer(queue.poll());
            }

            T data = queue.poll();
            Queue<T> tempQ = queue;
            queue = helpQ;
            helpQ = tempQ;
            return data;
        }

        public T peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Empty Stack!");
            }

            while (queue.size() > 1) {
                helpQ.offer(queue.poll());
            }

            T data = queue.poll();
            helpQ.offer(data);
            Queue<T> tempQ = queue;
            queue = helpQ;
            helpQ = tempQ;
            return data;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}