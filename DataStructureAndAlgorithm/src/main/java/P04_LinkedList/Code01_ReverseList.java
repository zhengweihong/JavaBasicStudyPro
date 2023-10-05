package P04_LinkedList;

import P04_LinkedList.Structure.DoubleNode;
import P04_LinkedList.Structure.Node;

/**
 * @author : ZWH
 * @date : 2021/05/26
 * @Description : 链表操作：反转
 */
public class Code01_ReverseList {
    /**
     * next指下一个不丢
     * 指下一个的指针换node
     * 挪pre
     * 挪锚点
     */
    /*
                  head
                   a  ->  b  ->  c  ->  null
         null  <-  a  <-  b  <-  c
            pre    cur
              2<-       1next
                  1pre   2cur
     */
    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * next指下一个不丢
     * 指双向的指针换node
     * 挪pre
     * 挪锚点
     */
    public DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}