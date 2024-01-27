package P09_Flyweight.C02_Pool;

/**
 * @author : ZWH
 * @date : 2024/01/27
 * @Description : 享元模式：测试
 */
public class Main {
    public static void main(String[] args) {
        SocketLinkPool pool = new SocketLinkPool();
        for (int i = 0; i < 20; i++) {
            System.out.println(pool.getSocketLink());
        }
    }
}
