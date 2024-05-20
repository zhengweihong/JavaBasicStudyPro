package InterviewQuestion;

/**
 * @author : ZWH
 * @Description : 无序正整数数组，求数组中最长连续序列的长度，时间复杂度越小越好。
 * @date : 2024/05/20
 */
public class Main7 {
    public static void main(String[] args) {
        // output 4：2、3、4、5
        int[] arr = new int[]{100, 4, 200, 5, 3, 2};
        quickSort(arr);

        int result = 1;
        int start = 0;
        int end = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                end++;
            } else {
                start = i;
                end = i;
            }
            result = Math.max(result, end - start + 1);
        }
        System.out.println(result);
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int x = (int) (Math.random() * (r - l + 1));
        swap(arr, l + x, r);
        // <x =x >x
        int[] equalX = quickSortFenqu(arr, l, r);

        process(arr, l, equalX[0] - 1);
        process(arr, equalX[1] + 1, r);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 以r位置为标准
     *
     * @return =x
     */
    private static int[] quickSortFenqu(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }

        int lessX = l - 1;
        int moreX = r;
        int cur = l;
        while (cur < moreX) {
            if (arr[cur] == arr[r]) {
                cur++;
            } else if (arr[cur] < arr[r]) {
                lessX++;
                swap(arr, lessX, cur);
                cur++;
            } else {
                moreX--;
                swap(arr, moreX, cur);
            }
        }

        swap(arr, r, moreX);
        return new int[]{lessX + 1, moreX};
    }
}
