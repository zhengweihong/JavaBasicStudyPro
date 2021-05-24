package P15_2021052480;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class Q2 {
    /*
        思路：
        从1～10000找4个数，首先写个for循环，如果循环到的数满足条件就打印
        接下来判断一个数i是否是perfect number：
            先找到i的所有因子，如果i==所有因子的和，i是，打印
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 10000 ; i++) {
            //开始判断i是不是perfect number
            int sum = 0;
            for (int j = 1; j < i ; j++) {//判断j是否是i的因子
                if (i % j == 0)
                    sum += j;//j是i的因子，加到sum中
            }
            if (i == sum)
                System.out.println(i);
        }
    }
}