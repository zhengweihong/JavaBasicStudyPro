package P06_Queue;

import java.util.Stack;

/**
 * @author : ZWH 2021/5/27
 * @version : 1.0
 */
public class Code06_QueueByStack {
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

        public void offer(T value) {
            pushStack.push(value);
            pushToPop();
        }

        public T poll() {
            if (pushStack.isEmpty() && popStack.isEmpty())
                throw new IndexOutOfBoundsException("Empty Queue!");
            pushToPop();
            return popStack.pop();
        }

        public T peek() {
            if (pushStack.isEmpty() && popStack.isEmpty())
                throw new IndexOutOfBoundsException("Empty Queue!");
            pushToPop();
            return popStack.peek();
        }

        public boolean isEmpty() {
            if (pushStack.isEmpty() && popStack.isEmpty())
                return true;
            else
                return false;
        }
    }
}
