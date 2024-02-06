package P11_Iterator.C04_Generic;

/**
 * @author : ZWH
 * @date : 2024/02/06
 * @Description : 容器共同接口
 */
public interface MyCollection<E> {
    void add(E o);
    int getSize();
    MyIterator<E> iterator();
}
