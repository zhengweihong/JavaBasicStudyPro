package P01_Language.P04_Multithread.P01_Thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : ZWH
 * @date : 2024/04/09
 * @Description : java.lang.Thread类：基本方法/常用API
 */
public class Code02_ThreadApi {

    public static void main(String[] args) throws InterruptedException {
        // 当前主线程对象
        Thread thread = Thread.currentThread();

        // 线程名称
        System.out.println(thread.getName());
        // 线程ID
        System.out.println(thread.getId());
        // 线程状态
        System.out.println(thread.getState());
        // 线程是否在活动
        System.out.println(thread.isAlive());

        // 线程优先级
        // 一般系统0-10，未设置默认5
        // 优先级越高，不一定会先执行，只是先执行的概率大一些
        System.out.println(thread.getPriority());
        thread.setPriority(10);
        System.out.println(thread.getPriority());

        // 线程睡眠
        // 同抛出InterruptedException
        // 时间单位不同：上边毫秒需要换算、下边枚举类单位可选
        Thread.sleep(1);
        TimeUnit.SECONDS.sleep(1);
    }

}
