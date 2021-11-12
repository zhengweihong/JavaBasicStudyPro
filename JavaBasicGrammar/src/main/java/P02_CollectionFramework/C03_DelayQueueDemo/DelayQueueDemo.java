package P02_CollectionFramework.C03_DelayQueueDemo;

import java.util.concurrent.DelayQueue;

/**
 * @author : ZWH 6/3/21
 * @version : 1.0
 */
public class DelayQueueDemo {
    DelayQueue<User> dq = new DelayQueue<>();

    public void login(User user) {
        dq.put(user);
        System.out.println(user+" login");
    }

    public void logout() {
        System.out.println(dq);
        try {
            User u = dq.take();
            System.out.println(u+" logout");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int onlineUser() {
        return dq.size();
    }

    public static void main(String[] args) {
        DelayQueueDemo test = new DelayQueueDemo();
        test.login(new User(1,"张三",System.currentTimeMillis() + 3000));
        test.login(new User(2,"李四",System.currentTimeMillis() + 5000));
        test.login(new User(3,"王五",System.currentTimeMillis() + 2000));
        while (true) {//一直监控
            test.logout();
            if (test.onlineUser() == 0) {
                break;//dq没有元素了，停止监控
            }
        }
    }
}
