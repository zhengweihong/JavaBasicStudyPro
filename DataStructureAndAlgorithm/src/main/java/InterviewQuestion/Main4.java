package InterviewQuestion;

/**
 * @author : ZWH
 * @date : 2024/04/24
 * @Description : 多抓鱼笔试题目：输入等腰直角三角形边长N，输出阅读顺序的元素编号数组。元素编号从第一列开始往下，逆时针转圈
 * <p>
 * 输入：5
 * 1    12  11  10  9
 * 2    13  15  8
 * 3    14  7
 * 4    6
 * 5
 * 输出：[1,12,11,10,9,2,13,15,8,3,14,7,4,6,5]
 */
public class Main4 {
    public static void main(String[] args) {
        int[] arr = functioin(5);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    private static int[] functioin(int N) {
        if (N < 1) {
            return new int[0];
        }

        int[] result = new int[((N + 1) * N) / 2];

        // 0下 1斜 2横
        int flag = 0;
        // 行
        int a = 1;
        // 列
        int b = 1;
        for (int i = 1; i <= result.length; i++) {
            // result下标
            result[sumBeforeRow(N, a) + b - 1] = i;
            // flag是否变；a、b变
            if (flag == 0) {
                if (a < N - (b - 1) * 2) {
                    a++;
                } else {
                    flag = 1;
                    a--;
                    b++;
                }
            } else if (flag == 1) {
                int count = N + 2 - a - b;
                if (b < N - (count - 1) * 2) {
                    a--;
                    b++;
                } else {
                    flag = 2;
                    b--;
                }
            } else if (flag == 2) {
                if (b > a + 1) {
                    b--;
                } else {
                    flag = 0;
                    a++;
                }
            }
        }

        return result;
    }

    private static int sumBeforeRow(int N, int a) {
        int sum = 0;
        for (int i = 1; i < a; i++) {
            sum += N - i + 1;
        }
        return sum;
    }
}
