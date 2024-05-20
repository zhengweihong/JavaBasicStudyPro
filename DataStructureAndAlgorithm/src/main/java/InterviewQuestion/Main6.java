package InterviewQuestion;

/**
 * @author : ZWH
 * @Description : 链表操作：反转，从第m个结点反转到第n个结点，1<=m<=n<=几个元素
 * @date : 2024/04/29
 */
public class Main6 {
    public static void main(String[] args) {
        // 1，8，5，4，6
        ListNode head = new ListNode(1, new ListNode(8, new ListNode(5, new ListNode(4, new ListNode(6, null)))));
        // 1，4，5，8，6
        head = reverseBetween(head, 3, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        // 第一段：[result～reserveStartPre]
        ListNode result = null;
        ListNode reserveStartPre = null;
        ListNode newTail = head;
        if (m > 1) {
            result = head;
            reserveStartPre = head;
            for (int i = 2; i < m; i++) {
                reserveStartPre = reserveStartPre.next;
            }
            newTail = reserveStartPre.next;
        }

        // 第二段：[pre～newTail]
        // 第三段：[next～]
        ListNode newHead = newTail;
        ListNode next = null;
        ListNode pre = null;
        for (int i = m; i <= n; i++) {
            next = newHead.next;
            newHead.next = pre;
            pre = newHead;
            newHead = next;
        }

        // 第三段接到第二段
        newTail.next = next;

        if (result == null) {
            return pre;
        }

        // 第二段接到第一段
        reserveStartPre.next = pre;
        return result;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}