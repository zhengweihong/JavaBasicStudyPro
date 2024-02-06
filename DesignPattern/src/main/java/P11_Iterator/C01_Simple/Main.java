package P11_Iterator.C01_Simple;

/**
 * @author : ZWH
 * @date : 2024/02/05
 * @Description : 迭代器模式：测试，数组实现能添加对象的容器
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        for (int i = 0; i < 12; i++) {
            arrayList.add("element" + i);
        }
        System.out.println(arrayList.getSize());

        MyLinkedList linkedList = new MyLinkedList();
        for (int i = 0; i < 12; i++) {
            linkedList.add("element" + i);
        }
        System.out.println(linkedList.getSize());
    }
}
