package InterviewQuestion;

/**
 * @author : ZWH
 * @Description : 滴滴一面：删除链表倒数第n个结点
 * @date : 2024/04/26
 */
public class Main5 {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node node = function(head, 2);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static Node function(Node head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        Node pre = head;
        for (int i = 1; i < n; i++) {
            pre = pre.next;
        }

        Node del = null;
        while (pre.next != null) {
            pre = pre.next;
            if (del == null) {
                del = head;
            } else {
                del = del.next;
            }
        }

        if (del == null) {
            return head;
        } else if (del == head) {
            return head.next;
        } else {
            del.next = del.next.next;
        }

        return head;
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}