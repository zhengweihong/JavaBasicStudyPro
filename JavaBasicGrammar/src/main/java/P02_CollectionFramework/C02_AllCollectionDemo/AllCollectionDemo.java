package P02_CollectionFramework.C02_AllCollectionDemo;

import java.util.*;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class AllCollectionDemo {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        Map<Integer,String> hashMap = new HashMap<>();

        arrList.add(1);
        arrList.set(1,2);
        hashSet.add(1);
        hashMap.put(1,"add");

        arrList.remove(0);
        hashSet.remove(1);
        hashMap.remove(1);
        hashMap.remove(1,"add");

        arrList.get(0);
        hashSet.contains(1);
        hashMap.get(1);
        hashMap.containsKey(1);
        hashMap.keySet();
        hashMap.entrySet();

        arrList.size();
        hashSet.size();
        hashMap.size();
    }
}
