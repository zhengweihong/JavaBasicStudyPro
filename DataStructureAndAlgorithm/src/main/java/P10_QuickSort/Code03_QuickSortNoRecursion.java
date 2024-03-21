package P10_QuickSort;

import java.util.Stack;

/**
 * @author : ZWH
 * @date : 2024/03/21
 * @Description : 快速排序非递归版
 */
public class Code03_QuickSortNoRecursion {

    class Op {
        int l;
        int r;

        public Op(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public void quickSortNoRecursion(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        // [0,1) -> [0,N) -> [0,N-1]
        int random = (int) (Math.random() * N);
        swap(arr, random, N - 1);
        int[] equalArea = new Code01_NetherlandsFlagProblem().netherlandsFlagProblem(arr, 0, N - 1);

        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0, equalArea[0] - 1));
        stack.push(new Op(equalArea[1] + 1, N - 1));

        while (!stack.isEmpty()) {
            Op op = stack.pop();
            if (op.l < op.r) {
                // [0,1) -> [0,几个元素) -> [0,r]
                random = (int) (Math.random() * (op.r - op.l + 1));
                swap(arr, op.l + random, op.r);
                equalArea = new Code01_NetherlandsFlagProblem().netherlandsFlagProblem(arr, op.l, op.r);
                stack.push(new Op(op.l, equalArea[0] - 1));
                stack.push(new Op(equalArea[1] + 1, op.r));
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
