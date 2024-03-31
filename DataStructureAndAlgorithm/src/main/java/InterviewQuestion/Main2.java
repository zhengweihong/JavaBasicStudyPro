package InterviewQuestion;

/**
 * @author : ZWH
 * @date : 2024/03/28
 * @Description : 笔试题目: 给你一个一维数组 nums，数值范围[1，N-1]，仅有一个数出现不只一次，请你 原地 找到这个数
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(function(new int[]{5, 2, 1, 6, 4, 3, 4}));
    }

    public static int function(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int index = 0;
        while (arr[index] != index && arr[index] != arr[arr[index]]) {
            swap(arr, arr[index], index);
        }
        return arr[index];
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
