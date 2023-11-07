package P05_Stack;

import java.util.Stack;

/**
 * @author : ZWH
 * @date : 2021/5/26
 * @Description : O(1)获取栈最小值
 */
public class Code04_StackGetMin {
    public class MinStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MinStack() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        // Vector Len Auto Grown
        public void push(int data) {
            stackData.push(data);
            if (stackMin.isEmpty()) {
                stackMin.push(data);
            }
            if (data < stackMin.peek()) {
                stackMin.push(data);
            }
            stackMin.push(stackMin.peek());
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Empty Stack!");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Empty Stack!");
            }
            return stackMin.peek();
        }
    }
}