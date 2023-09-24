package P05_LinkedList.Structure;

/**
 * @author : ZWH
 * @date : 2021/05/26
 * @Description : 单链表结点
 */
public class Node<T> {
    public T data;
    public Node next;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}


class NodeIntValue {

    private int data;
    private NodeIntValue next;

    public NodeIntValue(int data) {
        this.data = data;
    }

    public NodeIntValue(int data, NodeIntValue next) {
        this.data = data;
        this.next = next;
    }

}