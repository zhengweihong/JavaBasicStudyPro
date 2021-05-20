package P01_AlgorithmTool;

import java.util.HashMap;

/**
 * @author : ZWH 2021/5/17
 * @version : 1.0
 */
public class Code01_ComparatorDemo {
    /*
        对数器/比较器
        Math.random()：return double [0,1) 等概率！

        [0,1)的一个小数，[0,x)的数出现概率是x
        用两次独立行为+max，得到x出现概率是 x平方
            2次独立行为都保证在[0,x)，结果才能在[0,x)
            ==  第一次选x概率x/1；
                第二次若想max结果是x，必须随机出<x的数，这个概率也是x/1
        若变成min：[0,x)概率是x*（1-x），因为：
            ==  第一次选x概率x/1；
                第二次若想min结果是x，必须随机出>x的数，这个概率是（1-x）/1
     */
    public static void main(String[] args) {
        //返回等概率的整数：1-9
        int a = (int) (Math.random() * 9 + 1);//+1!!!
        System.out.println("Math.random():"+a);

        //返回等概率的整数：0-9
        int a0 = (int) (Math.random() * (9 + 1));//(+1)
        System.out.println("Math.random():"+a0);

        double test = Math.random() * 8;    //[0,8)
        int testInt = (int) test;           //[0,7]

        //验证取值区间+等概率
        int testTimes = 10000;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < testTimes ; i++) {
            int b = (int) (Math.random() * 9 + 1);
            if (map.containsKey(b)) {
                map.put(b,map.get(b)+1);
            } else {
                map.put(b,1);
            }
        }
        map.keySet().forEach(x ->
            System.out.printf("%d\t%d\t%.2f%%\n",
                x, map.get(x), (map.get(x) * 1.00 / testTimes) * 100
            )
        );

        //验证x^2概率
        for (int i = 0; i < testTimes ; i++) {
            int b = (int) (xToXPower2() * 9 + 1);
            if (map.containsKey(b)) {
                map.put(b,map.get(b)+1);
            } else {
                map.put(b,1);
            }
        }
        map.keySet().forEach(x ->
                System.out.printf("%d\t%d\t%.2f%%\t%.2f%%\n",
                        x, map.get(x), (map.get(x) * 1.00 / testTimes) * 100,
                        Math.sqrt((map.get(x) * 1.00 / testTimes) * 100)
                )
        );
    }

    //随机出x^2概率的x
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }
}
