package P100_NeedClassify;
import java.util.LinkedList;

/**
 * @author : ZWH 6/13/21
 * @version : 1.0
 */
public class MaxNumberInFixedWindow {
    public static void main(String[] args) {
        int windowLength = 3;
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        for (int a : getMaxInWindow(nums, windowLength)) {
            System.out.println(a);
        }
    }

    public static int[] getMaxInWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k)
            return null;

        LinkedList<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int index = 0;

        for (int R = 0; R < nums.length; R++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[R]) {
                queue.pollLast();
            }
            queue.offerLast(R);
            if (queue.peekFirst() == R - k) {
                queue.pollFirst();
            }
            if (R >= k - 1) {
                ans[index++] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }
}
