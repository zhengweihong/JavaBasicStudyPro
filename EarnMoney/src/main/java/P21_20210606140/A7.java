package P21_20210606140;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : ZWH 6/6/21
 * @version : 1.0
 */
public class A7 {
    static double maxNum;

    public static void main(String[] args) {
        String s1 = "Enter number of students: ";
        String s2 = "Enter student grades: ";
        double[] numbers = getNumsFromUser(s1, s2);
        System.out.println(Arrays.toString(numbers));
        showLetterGrades(numbers);
        if (isSorted(numbers)) {
            System.out.println("sorted");
        } else {
            System.out.println("is not sorted");
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

    public static void showLetterGrades(double[] grades) {
        for (int i = 0; i < grades.length ; i++) {
            System.out.print("Student "+(i+1)+" score is "+grades[i]+" and grade is ");
            if (grades[i] >= maxNum - 10) {
                System.out.println("A");
            } else if (grades[i] >= maxNum - 20) {
                System.out.println("B");
            } else if (grades[i] >= maxNum - 30) {
                System.out.println("C");
            } else if (grades[i] >= maxNum - 40) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }
        }
    }

    public static double[] getNumsFromUser(String msg1, String msg2) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg1);
        int x = in.nextInt();
        double[] m = new double[x];

        System.out.println(msg2);
        for (int i = 0; i < x; i++) {
            m[i] = in.nextDouble();
            maxNum = maxNum<m[i] ? m[i] : maxNum;
        }
        in.close();
        return m;
    }
}
