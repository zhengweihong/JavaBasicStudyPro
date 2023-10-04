package P03_BitOperation;

import java.util.HashMap;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description : 异或运算：找到出现K次的数
 */
public class Code05_XorFindAppearKTime {

    /**
     * 数组中只有一种数出现了K次，其他数都出现了M次，找到并打印出现K次的数
     * 要求：K < M，M > 1，时间复杂度O(N)，额外空间复杂度O(1)
     * 思路：
     * （因为K < M，所以k没必要知道）因为空间复杂度不让用map计数
     * 准备一个32位的数组：int[0位～31位]（按照int类型的二进制长度，符合额外空间复杂度）
     * arr遍历所有数，把二进制的1累加到数组对应位置上
     * 最后查看arr中：第i个位置不是M的整数倍，可推出：出现K次的数，第i位有1
     * 把找到的1，或到答案num上
     */
    public int xorFindAppearKTime(int[] arr, int k, int m) {
        // 0位～31位
        int[] t = new int[32];
        /* 虽然2层for循环，但时间复杂度为O(n)，因为内层每次都只循环32次不会因数据规模发生变化 */
        for (int value : arr) {
            for (int i = 0; i < 32; i++) {
                // 查看i位置是否为1
                // t[i] += ((value>>i) & 1);
                if (((value >> i) & 1) != 0) {
                    t[i]++;
                }
            }
        }

        int num = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0) {
                continue;
            }
            // 出现K次的数，第i位有1
            // if (t[i] % m != 0) {num |= (1 << i);}
            if (t[i] % m == k) {
                num |= (1 << i);
            }
            // 出现的次数不是k，有问题！
            else {
                return -1;
            }
        }

        // 当出现K次的是0时，此时num是0，需要判断0是否真的出现了K次，可能根本就没有出现K次的数
        if (num == 0) {
            int count = 0;
            for (int arri : arr) {
                if (arri == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }

        return num;
    }

    public int hashMapBuildFrequency(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int arri : arr) {
            if (map.containsKey(arri)) {
                map.put(arri, map.get(arri) + 1);
            } else {
                map.put(arri, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;//wrong answer 有问题
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        int a = new Code05_XorFindAppearKTime().xorFindAppearKTime(arr, 2, 3);
        System.out.println(a);
    }

}