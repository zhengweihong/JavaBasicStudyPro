package P07_Observer.C01_NotObserver;

/**
 * @author : ZWH
 * @date : 2024/01/25
 * @Description : 观察者模式：测试
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            child.wakeUp();
        }).start();

        while (!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing...");
        }
    }
}
