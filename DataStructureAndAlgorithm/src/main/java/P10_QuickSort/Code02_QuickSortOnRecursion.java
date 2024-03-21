package P10_QuickSort;

/**
 * @author : ZWH
 * @date : 2024/03/21
 * @Description : 快速排序递归版
 */
public class Code02_QuickSortOnRecursion {

    public void quickSortOnRecursion(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 把arr中下标l到r排有序
     */
    private void process(int[] arr, int l, int r) {
        // 停止条件 >违法
        if (l >= r) {
            return;
        }
        // [0,1) -> [0,几个元素) -> [0,r]
        int random = (int) (Math.random() * (r - l + 1));
        swap(arr, l + random, r);
        int[] equalArea = new Code01_NetherlandsFlagProblem().netherlandsFlagProblem(arr, l, r);
        process(arr, l, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, r);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
