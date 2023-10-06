package P06_Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : ZWH
 * @date : 2021/05/26
 * @Description : 队列的使用
 */
public class Code01_QueueDemo {
    public static void main(String[] args) {
        // LinkedList implements Deque Deque extends Queue，interface Queue extends Collection
        Queue queue = new LinkedList();

        // add
        queue.add(1);
        queue.add(2);
        queue.offer(3);

        // delete
        System.out.println(queue.poll());
        // look
        System.out.println(queue.element());
        System.out.println(queue.peek());

        System.out.println(queue.isEmpty());

        System.out.println();

        for (Object o : queue) {
            System.out.println(o);
        }
    }
}