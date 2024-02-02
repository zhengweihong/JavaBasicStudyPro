package P10_Proxy.C03_Proxy;

/**
 * @author : ZWH
 * @date : 2024/02/02
 * @Description : 时间代理
 */
public class CarTimeProxy implements Movable {

    private Car car;

    public CarTimeProxy(Car car) {
        this.car = car;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        car.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
