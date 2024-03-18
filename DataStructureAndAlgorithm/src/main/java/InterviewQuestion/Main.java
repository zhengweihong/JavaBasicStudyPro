package InterviewQuestion;

/**
 * @author : ZWH
 * @date : 2024/03/14
 * @Description : 笔试题目: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(function(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4}));
    }

    public static int function(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int slow = 2;
        int quick = 2;
        for (; quick < arr.length; quick++) {
            if (arr[quick] != arr[quick - 2]) {
                slow++;
            }
        }
        return slow;
    }
}
