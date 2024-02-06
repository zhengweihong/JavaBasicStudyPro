package P11_Iterator.C03_Iterator;

/**
 * @author : ZWH
 * @date : 2024/02/06
 * @Description : 链表实现的容器，能动态扩展
 */
public class MyLinkedList implements MyCollection {
    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public void add(Object o) {
        Node node = new Node(o, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements MyIterator {
        private Node cur = head;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Object next() {
            Object o = cur.data;
            cur = cur.next;
            return o;
        }
    }
}
