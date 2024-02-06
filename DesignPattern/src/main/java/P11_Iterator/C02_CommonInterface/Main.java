package P11_Iterator.C02_CommonInterface;

/**
 * @author : ZWH
 * @date : 2024/02/05
 * @Description : 迭代器模式：测试，让容器有共同接口，实现容器替换，多态
 */
public class Main {
    public static void main(String[] args) {
        MyCollection arrayList = new MyArrayList();
        for (int i = 0; i < 12; i++) {
            arrayList.add("element" + i);
        }
        System.out.println(arrayList.getSize());

        MyCollection linkedList = new MyLinkedList();
        for (int i = 0; i < 12; i++) {
            linkedList.add("element" + i);
        }
        System.out.println(linkedList.getSize());
    }
}
