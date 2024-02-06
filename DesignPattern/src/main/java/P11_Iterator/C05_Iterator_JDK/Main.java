package P11_Iterator.C05_Iterator_JDK;

import java.util.*;

/**
 * @author : ZWH
 * @date : 2024/02/06
 * @Description : 迭代器模式：测试，JDK容器的迭代器
 */
public class Main {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            c.add("element" + i);
        }

        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
