package P06_Queue;

import P04_LinkedList.Structure.DoubleLinkedList;

/**
 * @author : ZWH
 * @date : 2023/11/06
 * @Description : 双向链表实现队列
 */
public class Code02_QueueByDoubleLinkedList {
    public class QueueByDoubleLinkedList<T> {
        private DoubleLinkedList<T> list;
        private int size;

        public QueueByDoubleLinkedList() {
            list = new DoubleLinkedList<>();
            size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 入队
        public void add(T data) {
            list.addAtHead(data);
        }

        // 出队
        public T poll() {
            if (size <= 0) {
                size = 0;
                return null;
            }
            size--;
            return list.popFromTail();
        }

        // 看
        public T peek() {
            if (size == 0) {
                return null;
            }
            return list.lookAtTail();
        }
    }
}