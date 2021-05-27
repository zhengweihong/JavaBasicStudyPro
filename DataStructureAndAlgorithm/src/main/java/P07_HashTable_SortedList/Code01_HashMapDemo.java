package P07_HashTable_SortedList;

import P05_1_LinkedList.MyNode;

import java.util.HashMap;

/**
 * @author : ZWH 2021/5/27
 * @version : 1.0
 */
public class Code01_HashMapDemo {
    /*
        put、remove、get、containsKey、containsValue
     */
    public static void main(String[] args) {
        Integer a = 1900;
        Integer b = 1900;
        System.out.println(a == b);//false，比地址
        System.out.println(a.equals(b));//true，比值
        //Integer常量池的范围是[-128,127]

        HashMap<Integer,String> map = new HashMap<>();
        map.put(a,""+a);
        System.out.println(map.containsKey(b));//true，比值
        System.out.println(map.containsValue(b+""));//true，比值

        HashMap<MyNode,String> map2 = new HashMap<>();
        map2.put(new MyNode(1),"1");
        System.out.println(map2.containsKey(new MyNode(1)));//false，比地址
        System.out.println(map2.containsValue("1"));//true，比值
    }
}
