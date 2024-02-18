package P15_Bridge;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 桥接模式，测试
 */
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.attack(player2);
    }
}
