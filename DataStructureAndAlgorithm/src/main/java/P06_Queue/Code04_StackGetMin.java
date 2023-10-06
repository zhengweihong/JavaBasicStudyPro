package P06_Queue;

import java.util.Stack;

/**
 * @author : ZWH 2021/5/26
 * @version : 1.0
 */
public class Code04_StackGetMin {
    public class MinStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MinStack() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int value) {//Vector Len Auto Grown
            stackData.push(value);
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (value < stackMin.peek()) {
                stackMin.push(value);
            } else {
                stackMin.push(stackMin.peek());
            }
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new IndexOutOfBoundsException("Empty Stack!");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new IndexOutOfBoundsException("Empty Stack!");
            }
            return stackMin.peek();
        }
    }
}
