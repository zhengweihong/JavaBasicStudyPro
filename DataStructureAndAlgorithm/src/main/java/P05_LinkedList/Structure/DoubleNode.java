package P05_LinkedList.Structure;

/**
 * @author : ZWH
 * @date : 2021/05/26
 * @Description : 双向链表结点
 */
public class DoubleNode<T> {
    public T data;
    public DoubleNode pre;
    public DoubleNode next;

    public DoubleNode(T data) {
        this.data = data;
    }
}