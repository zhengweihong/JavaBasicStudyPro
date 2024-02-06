package P11_Iterator.C04_Generic;

/**
 * @author : ZWH
 * @date : 2024/02/06
 * @Description : 链表实现的容器，能动态扩展
 */
public class MyLinkedList<E> implements MyCollection<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override
    public void add(E o) {
        Node<E> node = new Node<>(o, null);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public MyIterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements MyIterator<E> {
        private Node<E> cur = head;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public E next() {
            E o = cur.data;
            cur = cur.next;
            return o;
        }
    }
}
