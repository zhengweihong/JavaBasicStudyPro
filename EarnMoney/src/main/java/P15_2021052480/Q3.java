package P15_2021052480;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class Q3 {
    /*
        思路：1、找到符合标准的数字；2、按照题目要求打印出来
        1、如何找到符合标准的数字：
            从100～200循环一遍，看看循环到的这个数，
            是否只能被5整除，或只能被6整除，满足条件就打印
        2、用一个count来计算打印数字之后，是要接着打印空格，还是换行
     */
    public static void main(String[] args) {
        int oneLineDisplay = 10;        //每行打印10个
        int count = 0;                  //已经打印了几个数字

        for (int i = 100; i <= 200 ; i++) {
            //判断i是否满足打印的条件
            if ((i%5==0 && i%6!=0) || (i%5!=0 && i%6==0)) {
                System.out.print(i);//打印i
                count++;
                if (count % oneLineDisplay != 0)//在一行中的位置不是第10个
                    System.out.print(" ");      //只打印一个空格
                else                            //在一行中的位置是第10个了
                    System.out.println();       //换行
            }
        }
    }
}
