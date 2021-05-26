package P05_1_List;

/**
 * @author : ZWH 2021/5/26
 * @version : 1.0
 */
public class MyNode<T> {
    public T data;
    public MyNode next;

    public MyNode(T data) {
        this.data = data;
    }

    public MyNode(T data, MyNode next) {
        this.data = data;
        this.next = next;
    }
}
