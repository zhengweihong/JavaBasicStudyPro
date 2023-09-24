package P00_AlgorithmUtils;

import P04_BitOperation.Code05_XorFindAppearKTime;

import java.util.HashSet;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description :
 */
public class Code03_ArrAppearTimeComparator {
    public static void main(String[] args) {
        int testTime = 50000;

        int arrMaxKinds = 20;
        int arrMaxValue = 100;
        int appearMaxTime = 9;
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * appearMaxTime) + 1;//a 1-9
            int b = (int) (Math.random() * appearMaxTime) + 1;//b 1-9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (k == m) m++;//k < m

            int[] arr = generateRandomArray(arrMaxKinds, arrMaxValue, k, m);
            int answer1 = new Code05_XorFindAppearKTime().hashMapBuildFrequency(arr, k, m);
            int answer2 = new Code05_XorFindAppearKTime().XORFindAppearKTime(arr, k, m);
            if (answer1 != answer2)
                System.out.println("Error!!!");
        }
        System.out.println("Finished...");
    }

    public static int[] generateRandomArray(int arrMaxKinds, int arrMaxValue, int k, int m) {
        int trueK = Math.random() < 0.5 ? k : (int) ((Math.random() * (m - 1)) + 1);//实际可能出现的不是K次，1～m-1

        int arrKinds = (int) (Math.random() * arrMaxKinds) + 2;//至少2种
        int[] arr = new int[trueK + (arrKinds - 1) * m];

        //range : [-maxV,+maxV]=[0,maxV]-[0,maxV]=[0,maxV]+[-maxV,0]=[-maxV,maxV]
        int kTimeNum = (int) (Math.random() * (arrMaxValue + 1)) - (int) (Math.random() * (arrMaxValue + 1));

        int index = 0;
        for (; index < trueK; index++) {
            arr[index] = kTimeNum;
        }
        arrKinds--;//还差几种数没放arr

        HashSet<Integer> set = new HashSet<>();
        set.add(kTimeNum);
        for (int i = 0; i < arrKinds; i++) {
            int curNum = 0;
            do {
                curNum = (int) (Math.random() * (arrMaxValue + 1)) - (int) (Math.random() * (arrMaxValue + 1));
            } while (set.contains(curNum));//包含就换一个
            set.add(curNum);
            for (int j = 0; j < m; j++) {
                arr[index++] = curNum;
            }
        }

        //随机打乱arr，i位置和随机的位置交换
        for (int i = 0; i < arr.length / 2; i++) {
            int j = (int) (Math.random() * arr.length);//0 ~ N-1
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }
}