package P01_Language.P01_BasicGrammar.C05_TimeFunction;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class TimeFunction {
    public static void main(String[] args) {
        long curTime = System.currentTimeMillis();//ms毫秒
        System.out.println(curTime);

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        System.out.println("所用时间：" + (endTime - startTime) + "ms");
    }
}
