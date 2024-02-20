package P17_Prototype.ShallowCopy;

/**
 * @author : ZWH
 * @date : 2024/02/20
 * @Description : 要拷贝的类
 */
public class Cat implements Cloneable {
    String name;
    int age;
    Location location;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
