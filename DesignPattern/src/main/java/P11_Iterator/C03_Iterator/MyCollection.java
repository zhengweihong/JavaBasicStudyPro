package P11_Iterator.C03_Iterator;

/**
 * @author : ZWH
 * @date : 2024/02/06
 * @Description : 容器共同接口
 */
public interface MyCollection {
    void add(Object o);
    int getSize();
    MyIterator iterator();
}
