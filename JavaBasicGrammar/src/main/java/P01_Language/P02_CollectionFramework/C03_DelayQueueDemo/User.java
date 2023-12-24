package P01_Language.P02_CollectionFramework.C03_DelayQueueDemo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author : ZWH 6/3/21
 * @version : 1.0
 */
public class User implements Delayed {
    private int id;
    private String name;
    private long endTime;

    public User(int id, String name, long endTime) {
        this.id = id;
        this.name = name;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public long getDelay(TimeUnit unit) {//take
        return endTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {//put
        //compare endTime
        return Long.compare(endTime, ((User) o).endTime);
    }
}
