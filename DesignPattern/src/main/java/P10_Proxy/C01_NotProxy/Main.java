package P10_Proxy.C01_NotProxy;

/**
 * @author : ZWH
 * @date : 2024/02/02
 * @Description : 代理模式：测试，最简单的方法就是面向过程加逻辑
 */
public class Main {
    public static void main(String[] args) {
        // 日志记录执行时间
        long start = System.currentTimeMillis();
        new Car().move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
