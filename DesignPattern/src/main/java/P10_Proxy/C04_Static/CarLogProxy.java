package P10_Proxy.C04_Static;

/**
 * @author : ZWH
 * @date : 2024/02/02
 * @Description : 日志代理
 */
public class CarLogProxy implements Movable {

    private Movable m;

    public CarLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("car start move");
        m.move();
        System.out.println("car stop");
    }
}
