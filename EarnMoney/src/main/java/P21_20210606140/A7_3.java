package P21_20210606140;

import java.util.Scanner;

/**
 * @author : ZWH 6/6/21
 * @version : 1.0
 */
public class A7_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers in the list");
        int y = in.nextInt();
        double[] list = new double[y];
        System.out.println("Enter list");
        for (int i = 0; i < y ; i++) {
            list[i] = in.nextDouble();
        }

        if (isSorted(list)) {
            System.out.println("sorted");
        } else {
            System.out.println("not sorted");
        }
    }

    public static boolean isSorted(double[] list) {
        if (list == null || list.length == 1)
            return true;
        for (int i = 1; i < list.length; i++) {
            if (list[i] < list[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
