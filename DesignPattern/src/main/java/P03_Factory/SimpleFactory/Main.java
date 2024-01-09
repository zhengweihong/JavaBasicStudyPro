package P03_Factory.SimpleFactory;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 工厂模式：测试
 */
public class Main {
    public static void main(String[] args) {
        Movable m = new SimpleVehicleFactory().createCar();
        m.go();
    }
}
