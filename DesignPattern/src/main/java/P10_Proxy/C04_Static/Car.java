package P10_Proxy.C04_Static;

/**
 * @author : ZWH
 * @date : 2024/02/02
 * @Description : 车
 */
public class Car implements Movable {
    @Override
    public void move() {
        System.out.println("car move");
        try {
            // 模拟车子移动时间 [1000,2000) ms
            int time = 1000 + (int) (Math.random() * 1000);
            System.out.println(time);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
