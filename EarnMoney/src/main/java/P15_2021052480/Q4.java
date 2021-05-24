package P15_2021052480;

import java.util.Scanner;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class Q4 {
    /*
        思路：
        先问下有n个学生，确定接下来for循环要循环n次
        每次循环知道学生名字和成绩，顺便和目前成绩前两名比较：
        如果新输入的学生成绩比第一名好，他变成第一名，原来的第一名变成第二名
        如果新输入的学生成绩只比第二名好，他变成第二名
        如果新输入的学生成绩没有第二名高，啥都不干
     */
    public static void main(String[] args) {
        System.out.println("Enter the number of students:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        //存一下第一名和第二名的信息
        String highestStudentName = null;
        double highestStudentScore = 0.0;
        String secondHighestStudentName = null;
        double secondHighestStudentScore = 0.0;

        for (int i = 0; i < n ; i++) {
            System.out.println("Enter a student name:");
            String name = in.next();
            System.out.println("Enter a student score:");
            double score = in.nextDouble();

            if (score > highestStudentScore) {//新输入的成绩比原来第一名高
                secondHighestStudentName = highestStudentName;//先把原来的第一名，变成第二名
                secondHighestStudentScore = highestStudentScore;
                highestStudentName = name;//成为第一名
                highestStudentScore = score;
            } else if (score > secondHighestStudentScore) {//新输入的成绩比原来第二名高，第一名不变
                secondHighestStudentName = name;//成为第二名
                secondHighestStudentScore = score;
            }
        }

        //所有学生信息都输入完了，打印第一名和第二名
        System.out.println("Top two students:");
        System.out.println(highestStudentName+"'s score is "+highestStudentScore);
        System.out.println(secondHighestStudentName+"'s score is "+secondHighestStudentScore);
    }
}
