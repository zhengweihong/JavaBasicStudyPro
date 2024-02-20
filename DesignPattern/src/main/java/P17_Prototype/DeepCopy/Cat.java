package P17_Prototype.DeepCopy;

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
        Cat c = (Cat) super.clone();
        c.location = (Location) location.clone();
        return c;
    }
}

class Location implements Cloneable {
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
