package P02_Strategy.Comparable;

/**
 * @author : ZWH
 * @date : 2024/01/08
 * @Description : 排序器（选择排序）
 */
public class Sorter {
    public void sort(Comparable[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // arr[j] < arr[minIndex]
                if (arr[j].compareTo(arr[minIndex]) == -1) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
