package P07_HashTable_SortedList;

import java.util.TreeMap;

/**
 * @author : ZWH 2021/5/27
 * @version : 1.0
 */
public class Code02_TreeMapDemo {
    /*
        put、remove、get、containsKey、containsValue
        firstKey、lastKey、floorKey、ceilingKey
     */
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(0,"0");
        map.put(1,"1");
        map.remove(0);
        System.out.println(map.get(1));             //1
        System.out.println(map.containsKey(1));     //true
        System.out.println(map.containsValue("1")); //true

        map.put(2,"2");
        map.put(4,"4");
        map.put(5,"5");
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.floorKey(3));    //2,<=3 Max Key
        System.out.println(map.ceilingKey(3));  //4,>=3 Min Key
    }
}
