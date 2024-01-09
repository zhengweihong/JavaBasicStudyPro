package P03_Factory.SimpleFactory;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 车
 */
public class Car implements Movable {
    @Override
    public void go() {
        System.out.println("car go");
    }
}
