package P11_Iterator.C01_Simple;

/**
 * @author : ZWH
 * @date : 2024/02/05
 * @Description : 数组实现的容器，能动态扩展
 */
public class MyArrayList {
    /**
     * java.util.ArrayList：DEFAULT_CAPACITY
     */
    private Object[] objects = new Object[10];
    /**
     * 有多少元素，下一个元素放在哪
     */
    private int size = 0;

    public void add(Object o) {
        if (size == objects.length) {
            objects = grow();
        }

        objects[size] = o;
        size++;
    }

    private Object[] grow() {
        // java.util.ArrayList：newCapacity()：oldCapacity + (oldCapacity >> 1)
        Object[] arr = new Object[(int) (this.objects.length * 1.5)];
        System.arraycopy(objects, 0, arr, 0, objects.length);
        return arr;
    }

    public int getSize() {
        return size;
    }
}
