package P05_Stack;

import java.util.Stack;

/**
 * @author : ZWH
 * @date : 2021/05/26
 * @Description : 栈的使用
 */
public class Code01_StackDemo {
    public static void main(String[] args) {
        // Stack extends Vector，Vector implements List
        Stack stack = new Stack();
        Object o1 = stack.push(1);
        Object o2 = stack.push(2);
        Object o3 = stack.push(3);

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);

        // java.util.EmptyStackException
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack.isEmpty());
        System.out.println(stack.empty());
        System.out.println(stack.size());

        System.out.println();
        System.out.println();

        stack.push(1);
        stack.push(2);
        for (Object o : stack) {
            // 打印的是数组顺序
            System.out.println(o);
        }
    }
}