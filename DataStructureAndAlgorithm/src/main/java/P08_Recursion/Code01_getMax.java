package P08_Recursion;

/**
 * @author : ZWH
 * @date : 2021/5/27
 * @Description : 递归实现找最大值
 */
public class Code01_getMax {
    public int getMax(int[] arr) {
        return getMaxRange(arr, 0, arr.length - 1);
    }

    public int getMaxRange(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }

        int mid = l + ((r - l) >> 1);
        int leftMax = getMaxRange(arr, l, mid);
        int rightMax = getMaxRange(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
}