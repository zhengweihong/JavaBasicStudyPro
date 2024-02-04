package P10_Proxy.C07_SpringAOP_XmlConfig;

/**
 * @author : ZWH
 * @date : 2024/02/03
 * @Description : 车
 */
public class Car {
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
