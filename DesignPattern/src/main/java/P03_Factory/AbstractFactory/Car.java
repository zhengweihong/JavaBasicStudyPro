package P03_Factory.AbstractFactory;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 车
 */
public class Car extends Vehicle {
    @Override
    public void go() {
        System.out.println("car go");
    }
}
