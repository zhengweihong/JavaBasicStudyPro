package P04_LinkedList;

import P04_LinkedList.Structure.Node;

/**
 * @author : ZWH
 * @date : 2021/05/26
 * @Description : 链表操作：删除给定值
 */
public class Code02_DeleteGivenData {
    public <T> Node deleteGivenData(Node head, T data) {
        while (head != null && head.data == data) {
            head = head.next;
        }

        // head.date必!=data
        Node tmp = head;
        while (tmp.next != null) {
            if (tmp.next.data == data) {
                // pre不能向后走
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}