package InterviewQuestion;

/**
 * @author : ZWH
 * @date : 2024/03/14
 * @Description : 笔试题目: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度
 * 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(function(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4}));
    }

    public static int function(int[] arr) {
        if (arr == null) {
            return 0;
        }
        if (arr.length < 2) {
            return arr.length;
        }

        int result = 2;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > arr[result - 2]) {
                arr[result] = arr[i];
                result++;
            }
        }

        return result;
    }
}
