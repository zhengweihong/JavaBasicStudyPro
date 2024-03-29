package P00_AlgorithmUtils;

import P01_Sort.*;

import java.util.Arrays;

/**
 * @author : ZWH
 * @date : 2021/05/17
 * @Description : 排序算法的对数器/比较器
 */
public class Code02_SortsComparator {

    public static void comparator(int[] arr) {
        if (arr == null) {
            return;
        }
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        // 总测试次数
        int testTime = 500;
        // 随机数组长度[0,50]
        int arrMaxLen = 50;
        // 随机数组元素值[-100,100]
        int arrMaxValue = 100;

        boolean success = true;

        // 数组创建方式
        // int[] arr = new int[i];
        // int[] arr = {22,3,4,11,4,35,555,40,33};

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(arrMaxLen, arrMaxValue);
            int[] arr2 = arr1.clone();

            comparator(arr1);
            new Code01_SelectionSort().selectionSort(arr2);

            if (!arrIsEqual(arr1, arr2)) {
                success = false;
                System.out.println("error");
                printArray(arr1);
                printArray(arr2);
            }
        }

        System.out.println(success ? "All Passed!!!" : "Sorry~");
    }

    public static int[] generateRandomArray(int arrMaxLen, int arrMaxValue) {
        // 设置数组长度随机 [0,arrMaxLen]
        int[] arr = new int[(int) (Math.random() * (arrMaxLen + 1))];

        for (int i = 0; i < arr.length; i++) {
            // range [-maxV,+maxV] : [0,maxV]-[0,maxV] = [0,maxV]+[-maxV,0] = [-maxV,maxV]
            arr[i] = (int) (Math.random() * (arrMaxValue + 1)) -
                    (int) (Math.random() * (arrMaxValue + 1));
        }

        return arr;
    }

    public static boolean arrIsEqual(int[] arr0, int[] arr1) {
        if (arr0 == null && arr1 == null) {
            return true;
        } else if (arr0 == null || arr1 == null) {
            return false;
        }
        if (arr0.length != arr1.length) {
            return false;
        }

        for (int i = 0; i < arr0.length; i++) {
            if (arr0[i] != arr1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (arr != null) {
            for (int a : arr) {
                System.out.print(a + "\t");
            }
        }
        System.out.println();
    }

}