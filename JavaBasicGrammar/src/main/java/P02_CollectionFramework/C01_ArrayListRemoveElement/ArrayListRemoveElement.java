package P02_CollectionFramework.C01_ArrayListRemoveElement;

import java.util.*;

/**
 * @author : ZWH 2021/4/26
 * @version : 1.0
 */
public class ArrayListRemoveElement {
    public static void main(String[] args) {
        //List<String> list = Arrays.asList("a","b","c","d","e");
        ArrayList<Integer> array = new ArrayList();
        array.add(1);array.add(3);
        array.add(2);array.add(5);
        array.add(3);array.add(5);

        array.stream().forEach(System.out::println);

        //for(int a:array)
        //不可以用foreach迭代，如果要删的元素在最后一个出现，会报错
        //java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
        //删完元素后剩余的元素索引发生改变而遗漏元素
        //java.util.ConcurrentModificationException
        //迭代器的modCount和expectedModCount的值不一致

        int b = 3;
        for(Iterator<Integer> it = array.iterator(); it.hasNext();) {
            if(it.next()==b) {
                it.remove();
            }
        }
        System.out.println(array);

        int c = 5;
        array.removeIf((e)->{return e==c;});
        array.removeIf((e)-> e==c );
        System.out.println(array);
    }
}