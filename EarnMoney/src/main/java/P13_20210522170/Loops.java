package P13_20210522170;

/**
 * @author : ZWH 2021/5/22
 * @version : 1.0
 */
public class Loops {
    public static void main(String[] args) {
        int i=0;
        System.out.println("int:"+i);

        double f = 9.2312312;
        System.out.printf("%.2f",f);//format
        System.out.println();

        double tuition = 10000.0;
        int year = 0;
        for (; tuition < 20000 ; year++) {
            tuition *= 1.07;
        }
        System.out.println(year +" "+tuition);

        //封装、继承extends+implements、多态
        //public、private、default、protected

        int sum = sumFunc(3,4);
        System.out.println(sum);

        int x = 2;
        int y = 3;
        System.out.println(x+" & "+y+" max value is "+maxFunc(x,y));

        String c1 = "c";
        char c2 = 'c';

        int[] x1 = {1,1,1}, y1 = {1,1,1};
        for(int item: x1)
            item++;
        for(int j = 0; j < y1.length; j++)
            y1[j]++;

        for (int i1 : x1) {
            System.out.println(i1);
        }
        for (int i1 : y1) {
            System.out.println(i1);
        }
    }

    public static int sumFunc(int a, int b) {
        return a+b;
    }

    public static int maxFunc(int a, int b) {
        return a > b ? a : b;
    }
}
