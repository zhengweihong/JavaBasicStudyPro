package P06_Stack_Queue;

import java.util.Stack;

/**
 * @author : ZWH 2021/5/26
 * @version : 1.0
 */
public class Code01_StackDemo {
    public static void main(String[] args) {
        //Stack extends Vector，Vector implements List
        Stack stack = new Stack();

        Object o1 = stack.push(1);
        Object o2 = stack.push(2);
        Object o3 = stack.push(3);
        System.out.println(o1);
        System.out.println(o2);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());//java.util.EmptyStackException

        stack.isEmpty();
        stack.empty();
        stack.size();

        System.out.println("======");
        stack.push(1);
        stack.push(2);
        for (Object o : stack) {
            System.out.println(o);//打印的是数组顺序
        }
    }
}
