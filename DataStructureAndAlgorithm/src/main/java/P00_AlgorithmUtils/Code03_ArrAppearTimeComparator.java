package P00_AlgorithmUtils;

import P03_BitOperation.Code05_XorFindAppearKTime;

import java.util.HashSet;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description : 异或运算：找到出现K次的数的对数器/比较器
 */
public class Code03_ArrAppearTimeComparator {

    public static void main(String[] args) {
        int testTime = 50000;
        int arrMaxKinds = 20;
        int arrMaxValue = 100;
        int appearMaxTime = 9;

        for (int i = 0; i < testTime; i++) {
            // 1-9
            int a = (int) (Math.random() * appearMaxTime) + 1;
            // 1-9
            int b = (int) (Math.random() * appearMaxTime) + 1;
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }

            int[] arr = generateRandomArray(arrMaxKinds, arrMaxValue, k, m);
            int answer1 = new Code05_XorFindAppearKTime().hashMapBuildFrequency(arr, k, m);
            int answer2 = new Code05_XorFindAppearKTime().xorFindAppearKTime(arr, k, m);
            if (answer1 != answer2) {
                System.out.println("Error!!!");
            }
        }
        System.out.println("Finished...");
    }

    public static int[] generateRandomArray(int arrMaxKinds, int arrMaxValue, int k, int m) {
        // 实际可能出现的不是K次，[1,m-1]
        int trueK = Math.random() < 0.5 ? k : (int) ((Math.random() * (m - 1)) + 1);

        // 至少2种数
        int arrKinds = (int) (Math.random() * arrMaxKinds) + 2;
        int[] arr = new int[trueK + (arrKinds - 1) * m];

        // range : [-maxV,+maxV]=[0,maxV]-[0,maxV]=[0,maxV]+[-maxV,0]=[-maxV,maxV]
        int kTimeNum = getRandomInRange(arrMaxValue);

        int index = 0;
        for (; index < trueK; index++) {
            arr[index] = kTimeNum;
        }
        // 还差几种数没放arr
        arrKinds--;

        // 保证创造的数没有重复
        HashSet<Integer> set = new HashSet<>();
        set.add(kTimeNum);
        for (int i = 0; i < arrKinds; i++) {
            int curNum = 0;
            do {
                // range : [-maxV,+maxV]=[0,maxV]-[0,maxV]=[0,maxV]+[-maxV,0]=[-maxV,maxV]
                curNum = getRandomInRange(arrMaxValue);
            }
            // 包含就换一个
            while (set.contains(curNum));
            set.add(curNum);
            for (int j = 0; j < m; j++) {
                arr[index++] = curNum;
            }
        }

        // 随机打乱arr，i位置和随机的位置交换
        for (int i = 0; i < arr.length / 2; i++) {
            // [0,N-1]
            int j = (int) (Math.random() * arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }

    /**
     * @return range : [-maxV,+maxV]=[0,maxV]-[0,maxV]=[0,maxV]+[-maxV,0]=[-maxV,maxV]
     */
    private static int getRandomInRange(int arrMaxValue) {
        return (int) (Math.random() * (arrMaxValue + 1)) - (int) (Math.random() * (arrMaxValue + 1));
    }

}