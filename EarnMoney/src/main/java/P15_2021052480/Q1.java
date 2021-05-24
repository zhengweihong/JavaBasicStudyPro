package P15_2021052480;

import java.util.Scanner;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        //先创建一些后边会用到的变量
        int input = 0;//暂存输入的数字
        int count = 0;//输入了几次非0的整数
        //下边这6个都是为了打印做准备的
        int positives = 0;
        int negatives = 0;
        int evens = 0;
        int odds = 0;
        double total = 0.0;

        System.out.println("Enter the first integer (0 to terminate):");
        Scanner in = new Scanner(System.in);

        /*
            用while来循环输入
            while()中的意思是：input = in.nextInt()、while(input!=0)
         */
        while ((input = in.nextInt()) != 0) {
            //如果输入的不是0，count++，再做其他的判断，平均数最后算
            count++;
            total += input;
            if (input > 0)
                positives++;
            if (input < 0)
                negatives++;
            if (input % 2 == 0)
                evens++;
            else
                odds++;
            System.out.println("Enter the next integer (0 to terminate):");
        }

        if (count > 0) {//输入过非0的整数
            System.out.println("The number of positives is " + positives);
            System.out.println("The number of negatives is " + negatives);
            System.out.println("The number of evens is " + evens);
            System.out.println("The number of odds is " + odds);
            System.out.println("The total is " + (int)total);
            System.out.printf("The average is %.2f", total / count);
        } else {//只输入了0，直接结束了，while循环里的代码都没走
            System.out.println("no numbers are entered except 0");
        }
    }
}
