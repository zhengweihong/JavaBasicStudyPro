package P100_20211209_130;

import java.util.Scanner;

/**
 * @author : ZWH 12/9/21
 * @version : 1.0
 */
public class DSMain {
    public static void main(String[] args) {
//        String input = "sort 10000 2000";
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Integer arrLength = Integer.valueOf(input.split(" ")[1]);
        Integer sortTimes = Integer.valueOf(input.split(" ")[2]);

        // 记录每种算法的执行总时间：简单插入、简单选择、冒泡排序、快排；希尔排序，堆排，归并排序
        long[] sumTime = new long[5];
        // 每种实现的排序算法执行sortTimes次
        for (int i = 0; i < sortTimes; i++) {
            System.out.println("Sort Time:" + (i + 1));
            // 随机构建一个长度为10000的数据
            double[] arr = generateRandomArray(arrLength);
            for (int j = 0; j < sumTime.length; j++) {
                sumTime[j] += sortAlgorithm(arr.clone(), j);
            }
        }

        System.out.println();

        // 输出: 时间单位为ms
        System.out.println("Insert:" + (sumTime[0] / sortTimes));
        System.out.println("Selection:" + (sumTime[1] / sortTimes));
        System.out.println("Bubble:" + (sumTime[2] / sortTimes));
        System.out.println("Qsort:" + (sumTime[3] / sortTimes));
        System.out.println("Shell:" + (sumTime[4] / sortTimes));
    }

    public static double[] generateRandomArray(int arrLength) {
        double[] arr = new double[arrLength];
        for (int i = 0; i < arr.length; i++) {
            //range : (-maxV,+maxV) = [0,maxV)-[0,maxV)
            arr[i] = (Math.random() * Integer.MAX_VALUE) - (Math.random() * Integer.MAX_VALUE);
        }
        return arr;
    }

    public static long sortAlgorithm(double[] arr, int sortAlgorithmType) {
        long startTime = System.currentTimeMillis();
        switch (sortAlgorithmType) {
            // 简单插入排序
            case 0:
                SortAlgorithm.insertionSort(arr);
                break;
            // 简单选择排序
            case 1:
                SortAlgorithm.selectionSort(arr);
                break;
            // 冒泡排序
            case 2:
                SortAlgorithm.bubbleSort(arr);
                break;
            // 快速排序
            case 3:
                SortAlgorithm.quickSort(arr, 0, arr.length - 1);
                break;
            // 希尔排序
            case 4:
                SortAlgorithm.shellSort(arr);
                break;
            default:
                break;
        }
        return (System.currentTimeMillis() - startTime);// 时间单位为ms
    }
}