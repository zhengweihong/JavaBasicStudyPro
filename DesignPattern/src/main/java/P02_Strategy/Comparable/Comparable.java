package P02_Strategy.Comparable;

/**
 * @author : ZWH
 * @date : 2024/01/08
 * @Description : 比较能力，自定义的，泛型帮助类型检查
 */
public interface Comparable<T> {
    int compareTo(T o);
}
