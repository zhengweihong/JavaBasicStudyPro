package P04_LinkedList.Structure;

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
}

class IntValueNode {
    private int data;
    private IntValueNode next;
}