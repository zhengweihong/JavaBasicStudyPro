package P01_AlgorithmTool;

import P02_Sort.Code02_BubbleSort;

/**
 * @author : ZWH 2021/5/17
 * @version : 1.0
 */
public class Code02_SortsComparator {

    static void printArray(int[] arr) {
        for(int a:arr) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {22,3,4,11,4,35,555,40,33};
        printArray(arr);

        new Code02_BubbleSort().bubbleSort(arr);
        //selectSort(arr);//选择排序-直接
        //bubbleSort(arr);//冒泡排序
        //insertSort(arr);//插入排序-直接

        printArray(arr);
    }
}
