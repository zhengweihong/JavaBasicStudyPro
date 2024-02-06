package P11_Iterator.C04_Generic;

/**
 * @author : ZWH
 * @date : 2024/02/05
 * @Description : 迭代器模式：测试，泛型写法
 */
public class Main {
    public static void main(String[] args) {
        MyCollection<String> arrayList = new MyArrayList<>();
        for (int i = 0; i < 12; i++) {
            arrayList.add("element" + i);
        }
        System.out.println(arrayList.getSize());

        MyIterator<String> arrIt = arrayList.iterator();
        while (arrIt.hasNext()) {
            System.out.println(arrIt.next());
        }


        MyCollection<String> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 12; i++) {
            linkedList.add("element" + i);
        }
        System.out.println(linkedList.getSize());

        MyIterator<String> linkIt = linkedList.iterator();
        while (linkIt.hasNext()) {
            System.out.println(linkIt.next());
        }
    }
}
