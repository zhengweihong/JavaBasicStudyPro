package P11_Iterator.C04_Generic;

/**
 * @author : ZWH
 * @date : 2024/02/06
 * @Description : 迭代器接口
 */
public interface MyIterator<E> {
    boolean hasNext();
    E next();
}
