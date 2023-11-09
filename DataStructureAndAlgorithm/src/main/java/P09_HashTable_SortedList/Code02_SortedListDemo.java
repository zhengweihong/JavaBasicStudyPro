package P09_HashTable_SortedList;

import java.util.TreeMap;

/**
 * @author : ZWH
 * @date : 2021/5/27
 * @Description : 有序表的使用
 */
public class Code02_SortedListDemo {

    public static void main(String[] args) {
        // 所有操作都O(logN)
        // TreeMap
        // put、remove、get、containsKey、containsValue
        // firstKey、lastKey、floorKey、ceilingKey
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(0, "0");
        map.remove(0);
        // 1
        System.out.println(map.get(1));

        map.put(1, "1");
        map.put(2, "2");
        map.put(4, "4");
        map.put(5, "5");

        // 1  最小key
        System.out.println(map.firstKey());
        // 5  最大key
        System.out.println(map.lastKey());
        // 2  <=3 Max Key
        System.out.println(map.floorKey(3));
        // 4  >=3 Min Key
        System.out.println(map.ceilingKey(3));

        /* 有序表中基础类型 按值传递 */
        // true
        System.out.println(map.containsKey(1));
        // true
        System.out.println(map.containsValue("1"));
    }

}