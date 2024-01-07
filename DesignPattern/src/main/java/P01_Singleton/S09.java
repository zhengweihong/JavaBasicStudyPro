package P01_Singleton;

/**
 * @author : ZWH
 * @date : 2024/01/06
 * @Description : 单例模式：枚举式，懒加载，线程安全，防止反射、防止反序列化破坏单例
 */
public enum S09 {

    INSTANCE;

    private Boolean field = true;

    public Boolean getField() {
        return field;
    }

}
