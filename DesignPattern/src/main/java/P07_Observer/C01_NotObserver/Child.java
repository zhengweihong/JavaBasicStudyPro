package P07_Observer.C01_NotObserver;

/**
 * @author : ZWH
 * @date : 2024/01/25
 * @Description : 会哭的孩子
 */
public class Child {
    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Wake up! wa wa wa...");
        this.cry = true;
    }
}
