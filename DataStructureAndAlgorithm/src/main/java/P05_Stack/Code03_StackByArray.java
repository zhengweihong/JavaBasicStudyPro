package P05_Stack;

/**
 * @author : ZWH
 * @date : 2023/11/06
 * @Description : 数组实现栈
 */
public class Code03_StackByArray {
    public static class StackByArray {
        private int[] arr;
        private int size;

        public StackByArray(int capacity) {
            arr = new int[capacity];
            size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 压栈
        public void push(int data) {
            if (size >= arr.length) {
                throw new RuntimeException("满了");
            }
            arr[size] = data;
            size++;
        }

        // 弹栈
        public int pop() {
            if (size <= 0) {
                size = 0;
                throw new RuntimeException("空了");
            }
            size--;
            return arr[size];
        }

        // 看
        public int peek() {
            if (size == 0) {
                throw new RuntimeException("空了");
            }

            return arr[size - 1];
        }
    }
}