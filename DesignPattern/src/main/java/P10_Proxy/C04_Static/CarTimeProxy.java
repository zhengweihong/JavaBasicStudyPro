package P10_Proxy.C04_Static;

/**
 * @author : ZWH
 * @date : 2024/02/02
 * @Description : 时间代理
 */
public class CarTimeProxy implements Movable {

    private Movable m;

    public CarTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
