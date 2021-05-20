package P01_AlgorithmTool;

import P02_Sort.*;

/**
 * @author : ZWH 2021/5/17
 * @version : 1.0
 * Sort : from small to big
 */
public class Code02_SortsComparator {
    public static void main(String[] args) {
        int testTime = 500;
        boolean success = true;

        int arrMaxLen = 50;
        int arrMaxValue = 100;
        for (int i = 0; i < testTime ; i++) {
            //int[] arr = {22,3,4,11,4,35,555,40,33};
            int[] arr0 = generateRandomArray(arrMaxLen,arrMaxValue);
            int[] arr1 = arr0.clone();

            new Code01_SelectionSort().selectionSort(arr0);//As Comparator  //选择排序-直接
            new Code02_BubbleSort().bubbleSort(arr1);//Test                 //冒泡排序
            //new Code03_InsertionSort().insertionSort(arr1);//Test         //插入排序-直接
            if (!arrIsEqual(arr0,arr1)) {
                success = false;
                printArray(arr0);
                printArray(arr1);
                System.out.println();
            }
        }

        if (success) System.out.println("All Passed!!!");
    }

    public static void printArray(int[] arr) {
        for(int a:arr) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }

    public static int[] generateRandomArray(int arrMaxLen, int arrMaxValue) {
        int[] arr = new int[(int) (Math.random() * (arrMaxLen + 1))];//[0,arrMaxLen]
        for (int i = 0; i < arr.length ; i++) {
            //range : [-maxV,+maxV]=[0,maxV]-[0,maxV]=[0,maxV]+[-maxV,0]=[-maxV,maxV]
            arr[i] = (int) (Math.random() * (arrMaxValue + 1))  -  (int) (Math.random() * (arrMaxValue + 1));
        }
        return arr;
    }

    public static boolean arrIsEqual(int[] arr0, int[] arr1) {
        if (arr0 == null && arr1 == null) return true;
        if (arr0 == null && arr1 != null) return false;
        if (arr0 != null && arr1 == null) return false;
        if (arr0.length != arr1.length) return false;
        for (int i = 0; i < arr0.length; i++) {
            if (arr0[i] != arr1[i]) return false;
        }
        return true;
    }
}
