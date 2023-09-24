package P04_LinkedList;

import P04_LinkedList.Structure.Node;

/**
 * @author : ZWH
 * @date : 2021/05/26
 * @Description : 链表操作：删除给定值
 */
public class Code02_DeleteGivenData {
    public <T> Node deleteGivenData(Node head, T data) {
        while (head != null && head.data == data)
            head = head.next;

        Node pre = head;//head.date必!=data
        while (pre.next != null) {
            if (pre.next.data == data) {
                pre.next = pre.next.next;//pre不能向后走
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
}