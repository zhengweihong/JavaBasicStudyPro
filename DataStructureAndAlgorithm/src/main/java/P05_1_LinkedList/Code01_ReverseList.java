package P05_1_LinkedList;

/**
 * @author : ZWH 2021/5/26
 * @version : 1.0
 */
public class Code01_ReverseList {
    /*
                  head
                   a  ->  b  ->  c  ->  null
         null  <-  a  <-  b  <-  c
            pre    cur
              2<-       1next
                  1pre   2cur
     */
    public MyNode reverseList (MyNode head) {
        MyNode pre = null;
        MyNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public MyDoubleNode reverseDoubleList (MyDoubleNode head) {
        MyDoubleNode pre = null;
        MyDoubleNode next = null;
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