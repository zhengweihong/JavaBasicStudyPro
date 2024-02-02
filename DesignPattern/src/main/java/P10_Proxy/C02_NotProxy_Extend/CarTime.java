package P10_Proxy.C02_NotProxy_Extend;

/**
 * @author : ZWH
 * @date : 2024/02/02
 * @Description : 日志记录执行时间
 */
public class CarTime extends Car {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
