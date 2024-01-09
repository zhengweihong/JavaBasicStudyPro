package P03_Factory.SimpleFactory;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 简单工厂
 */
public class SimpleVehicleFactory {
    public Car createCar() {
        // any process code
        return new Car();
    }

    public Plane createPlane() {
        // any process code
        return new Plane();
    }
}
