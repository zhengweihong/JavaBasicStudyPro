package P05_1_List;

/**
 * @author : ZWH 2021/5/26
 * @version : 1.0
 */
public class Code02_DeleteGivenData {
    public <T> MyNode deleteGivenData (MyNode head,T data) {
        while (head != null && head.data ==data)
            head = head.next;

        MyNode pre = head;//head.date必!=data
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
