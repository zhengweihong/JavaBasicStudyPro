package P09_HashTable_SortedList;

import P04_LinkedList.Structure.Node;

import java.util.HashMap;

/**
 * @author : ZWH
 * @date : 2021/5/27
 * @Description : 哈希表的使用
 */
public class Code01_HashTableDemo {

    public static void main(String[] args) {
        // 所有操作都O(1)
        // HashMap：put、remove、get、containsKey、containsValue
        // HashSet：add、remove、contains

        // 基础类型的包装比较 Integer常量池的范围是[-128,127]
        Integer a = 1900;
        Integer b = 1900;
        // false，比地址
        System.out.println(a == b);
        // true，比值
        System.out.println(a.equals(b));

        // 哈希表中基础类型 按值传递
        HashMap<Integer, String> map = new HashMap<>();
        map.put(a, a.toString());
        // true，key比值
        System.out.println(map.containsKey(b));
        // true，value比值
        System.out.println(map.containsValue(b + ""));

        HashMap<Node, String> map2 = new HashMap<>();
        map2.put(new Node(1), "1");
        // false，key比地址
        System.out.println(map2.containsKey(new Node(1)));
        // true，value比值
        System.out.println(map2.containsValue("1"));
    }

}