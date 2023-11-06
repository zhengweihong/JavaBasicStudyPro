package P04_LinkedList.Structure;

/**
 * @author : ZWH
 * @date : 2021/05/26
 * @Description : 双向链表结点
 */
public class DoubleNode<T> {
    public T data;
    public DoubleNode<T> pre;
    public DoubleNode<T> next;

    public DoubleNode(T data, DoubleNode<T> pre, DoubleNode<T> next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }
}