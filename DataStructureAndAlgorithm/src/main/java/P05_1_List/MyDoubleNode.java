package P05_1_List;

/**
 * @author : ZWH 2021/5/26
 * @version : 1.0
 */
public class MyDoubleNode<T> {
    public T data;
    public MyDoubleNode pre;
    public MyDoubleNode next;

    public MyDoubleNode(T data) {
        this.data = data;
    }
}
