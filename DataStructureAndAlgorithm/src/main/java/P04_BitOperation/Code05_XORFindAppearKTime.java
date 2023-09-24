package P04_BitOperation;

import java.util.HashMap;

/**
 * @author : ZWH
 * @date : 2021/05/25
 * @Description : 异或运算：
 */
public class Code05_XORFindAppearKTime {
    public int XORFindAppearKTime(int[] arr, int k, int m) {
        int[] t = new int[32];//0位～31位
        for (int arri : arr) {
            for (int i = 0; i < 32; i++) {
                //t[i] += ((arri>>i) & 1);
                if (((arri >> i) & 1) != 0) {
                    t[i]++;
                }
            }
        }

        int num = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0)
                continue;
            if (t[i] % m == k) {//出现k次的数，第i位有1
                num |= (1 << i);
            } else {
                return -1;//出现的次数不是k，有问题！
            }
            //出现k次的数，第i位有1
            //if (t[i] % m != 0) {num |= (1 << i);}
        }

        //当出现K次的是0时，此时num是0，需要判断0是否真的出现了K次
        if (num == 0) {
            int count = 0;
            for (int arri : arr) {
                if (arri == 0)
                    count++;
            }
            if (count != k)
                return -1;
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
        int a = new Code05_XORFindAppearKTime().XORFindAppearKTime(arr, 2, 3);
        System.out.println(a);
    }
}