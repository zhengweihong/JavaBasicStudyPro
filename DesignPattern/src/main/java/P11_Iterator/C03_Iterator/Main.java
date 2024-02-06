package P11_Iterator.C03_Iterator;

/**
 * @author : ZWH
 * @date : 2024/02/05
 * @Description : 迭代器模式：测试，定义迭代器接口，具体实现类各自实现遍历逻辑
 */
public class Main {
    public static void main(String[] args) {
        MyCollection arrayList = new MyArrayList();
        for (int i = 0; i < 12; i++) {
            arrayList.add("element" + i);
        }
        System.out.println(arrayList.getSize());

        MyIterator arrIt = arrayList.iterator();
        while (arrIt.hasNext()) {
            System.out.println(arrIt.next());
        }


        MyCollection linkedList = new MyLinkedList();
        for (int i = 0; i < 12; i++) {
            linkedList.add("element" + i);
        }
        System.out.println(linkedList.getSize());

        MyIterator linkIt = linkedList.iterator();
        while (linkIt.hasNext()) {
            System.out.println(linkIt.next());
        }
    }
}
