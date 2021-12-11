package P100_20211209_130;

/**
 * @author : ZWH 12/9/21
 * @version : 1.0
 */
public class SortAlgorithm {
    /*
    在zwh.main下新建类SortAlgorithm
    在类中为每一种要实现的算法写静态函数

    简单插入、简单选择、冒泡排序、快排必须实现
    希尔排序，堆排，归并排序可以选一个实现

    在DSMain中增加一个case
    输入样例为"sort 10000 2000"
    表示随机构建一个长度为10000的数据，每种实现的排序算法执行2000次
    最后输出各种排序算法的平均耗时，时间单位为ms
    注意生成序列的耗时不要算进去
    各种排序算法处理的序列要一样
    可以通过控制随机数生成器的种子控制随机序列

    序列统一为double类型

    输出样例:
    Insert:100
    Selection:100
    Bubble:100
    Shell:0
    Merge:0
    Qsort:50
    Heap:50
     */

    /**
     * 简单插入排序-每一步将一个待排序数据按照关键字的大小，插入到已经排好序的一组数据中
     */
    public static void insertionSort(double[] arr) {
        if (arr == null || arr.length < 2) return;

        //0~0；0~1、0~i、0~N-1内部有序，i要排的数开始的位置，然后此数向左滑动
        for (int i = 1; i < arr.length; i++) {
            //stop=at 0/left small
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 简单选择排序-每一步从待排序数据中选出最小(大)的数据，放到一个有序的序列中
     */
    public static void selectionSort(double[] arr) {
        if (arr == null || arr.length < 2) {//0\1
            return;
        }

        int N = arr.length;
        //0~n-1、1~n-1、2~n-1...find min
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;//arr[i]是min
            for (int j = i + 1; j < N; j++) {
                if (arr[minValueIndex] > arr[j])
                    minValueIndex = j;
            }
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(double[] arr) {
        if (arr == null || arr.length < 2) return;

        //0~N-1、0～N-2、...、0～1
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(double[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(double[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 希尔排序
     */
    public static void shellSort(double[] arr) {
        int length = arr.length;
        double temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}