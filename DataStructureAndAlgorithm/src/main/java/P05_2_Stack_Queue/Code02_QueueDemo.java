package P05_2_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : ZWH 2021/5/26
 * @version : 1.0
 */
public class Code02_QueueDemo {
    public static void main(String[] args) {
        //LinkedList implements Queue，Queue implements Collection
        Queue queue = new LinkedList();

        queue.add(1);
        queue.add(2);
        queue.offer(3);

        System.out.println(queue.poll());//delete
        System.out.println(queue.peek());
        System.out.println(queue.element());

        queue.isEmpty();

        System.out.println("======");
        for (Object o : queue) {
            System.out.println(o);
        }
    }
}
