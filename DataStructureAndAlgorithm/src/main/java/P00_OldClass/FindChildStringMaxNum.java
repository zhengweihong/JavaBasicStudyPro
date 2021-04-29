package P00_OldClass;
import java.util.*;

/**
 * @Link : https://blog.csdn.net/RealCoder/article/details/108566720
 */
public class FindChildStringMaxNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        int aLen = a.length();
        if (aLen == 0) {
            System.out.println(0);
            return;
        }

        //temp[i]=到i处的无重复字符的最长字串
        int[] temp = new int[aLen];
        Map<Character, Integer> lastIndex = new HashMap<>();
        int maxNum = 1;

        temp[0] = 1;
        lastIndex.put(a.charAt(0), 0);
        for (int i = 1; i < aLen; i++) {
            //a的第i个字符，是否在前一个的最长字串里出现了
            char ai = a.charAt(i);
            if (!lastIndex.containsKey(ai) || lastIndex.get(ai) < i - temp[i - 1]) {
                //没出现过 / 不在上一个最长字串中
                temp[i] = temp[i - 1] + 1;
            } else {
                //aiIndex:i-1 to i-temp[i-1]+1
                temp[i] = i - lastIndex.get(ai);
            }

            if (maxNum < temp[i]) {
                maxNum = temp[i];
            }
            lastIndex.put(ai, i);
        }

        System.out.println(maxNum);
    }
}
