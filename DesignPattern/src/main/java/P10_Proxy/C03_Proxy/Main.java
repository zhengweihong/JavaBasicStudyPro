package P10_Proxy.C03_Proxy;

/**
 * @author : ZWH
 * @date : 2024/02/02
 * @Description : 代理模式：测试，代理=聚合
 */
public class Main {
    public static void main(String[] args) {
        new CarTimeProxy(new Car()).move();
    }
}
