package P10_QuickSort;

/**
 * @author : ZWH
 * @date : 2024/03/20
 * @Description : 快速排序-荷兰国旗问题
 */
public class Code01_NetherlandsFlagProblem {

    public int[] netherlandsFlagProblem(int[] arr, int l, int r) {
        if (arr == null || arr.length < 2 || l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }

        // <x右边界
        int lessX = l - 1;
        // >x左边界 最后一个数作为基准数暂不参与
        int moreX = r;
        // 将要处理的位置
        int cur = l;

        while (cur < moreX) {
            // 当元素等于基准值，元素不动，向右遍历
            if (arr[cur] == arr[r]) {
                cur++;
            }
            // 当元素小于基准值，元素和左范围右的元素交换，左范围扩大，向右遍历
            else if (arr[cur] < arr[r]) {
//                swap(arr, cur, lessX + 1);
//                lessX++;
//                cur++;
                swap(arr, cur++, ++lessX);
            }
            // 当元素大于基准值，元素和右范围左的元素交换，右范围扩大，再次遍历当前位置
            // 因为交换后当前位置元素没遍历过
            else {
//                swap(arr, cur, moreX - 1);
//                moreX--;
                swap(arr, cur, --moreX);
            }
        }
        // 最后一个数和右范围内最左的元素交换
        swap(arr, r, moreX);
        // =x中间层的左右下标位置，moreX是刚换过来的基准数x
        return new int[]{lessX + 1, moreX};
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
