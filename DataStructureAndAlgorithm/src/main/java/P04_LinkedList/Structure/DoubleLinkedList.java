package P04_LinkedList.Structure;

/**
 * @author : ZWH
 * @date : 2023/11/06
 * @Description : 双向链表
 */
public class DoubleLinkedList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public void addAtHead(T data) {
        // cur -> head -> tail
        DoubleNode<T> cur = new DoubleNode<>(data, null, head);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            head.pre = cur;
            head = cur;
        }
    }

    public T popFromHead() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = null;
        }
        return data;
    }

    public T lookAtHead() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public T popFromTail() {
        if (tail == null) {
            return null;
        }
        T data = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.pre;
            tail.next = null;
        }
        return data;
    }

    public T lookAtTail() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }
}