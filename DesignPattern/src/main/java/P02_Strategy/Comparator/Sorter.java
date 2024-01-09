package P02_Strategy.Comparator;

/**
 * @author : ZWH
 * @date : 2024/01/09
 * @Description : 排序器（选择排序）
 */
public class Sorter<T> {
    public void sort(T[] arr, Comparator<T> comparator) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // arr[j] < arr[minIndex]
                if (comparator.compare(arr[j], arr[minIndex]) == -1) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
