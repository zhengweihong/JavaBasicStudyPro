package P06_Queue;

import java.util.Stack;

/**
 * @author : ZWH
 * @date : 2021/5/27
 * @Description : 栈实现队列
 */
public class Code04_QueueByStack {
    public class QueueByStack<T> {
        private Stack<T> pushStack;
        private Stack<T> popStack;

        public QueueByStack() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        private void pushToPop() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }

        public void add(T data) {
            pushStack.push(data);
            pushToPop();
        }

        public T poll() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new RuntimeException("Empty Queue!");
            }
            pushToPop();
            return popStack.pop();
        }

        public T peek() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new RuntimeException("Empty Queue!");
            }
            pushToPop();
            return popStack.peek();
        }

        public boolean isEmpty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }
}