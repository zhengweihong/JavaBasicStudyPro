package P03_Factory.SimpleFactory;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 飞机
 */
public class Plane implements Movable {
    @Override
    public void go() {
        System.out.println("plane fly");
    }
}
