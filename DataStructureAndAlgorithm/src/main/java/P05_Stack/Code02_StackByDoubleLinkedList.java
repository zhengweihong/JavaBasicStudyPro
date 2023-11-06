package P05_Stack;

import P04_LinkedList.Structure.DoubleLinkedList;

/**
 * @author : ZWH
 * @date : 2023/10/08
 * @Description : 双向链表实现栈
 */
public class Code02_StackByDoubleLinkedList {
    public class StackByDoubleLinkedList<T> {
        private DoubleLinkedList<T> list;
        private int size;

        public StackByDoubleLinkedList() {
            list = new DoubleLinkedList<>();
            size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 压栈
        public void push(T data) {
            list.addAtHead(data);
            size++;
        }

        // 弹栈
        public T pop() {
            if (size <= 0) {
                size = 0;
                return null;
            }
            size--;
            return list.popFromHead();
        }

        // 看
        public T peek() {
            if (size == 0) {
                return null;
            }

            return list.lookAtHead();
        }
    }
}