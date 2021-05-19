package P11_20210519110.Code01;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : ZWH 2021/5/19
 * @version : 1.0
 */
public class DictionaryAndEssay {
    public static void main(String[] args) {
        ArrayList<String> essayArr = getWords();

        long startTime = System.currentTimeMillis();
        int compareTimes = mergeSort(essayArr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序所用总时间：" + (endTime - startTime) + "ms");
        System.out.println("排序总移动/比较次数：" + compareTimes);

        essayArr.forEach(System.out::println);
    }

    public static ArrayList getWords() {
        String dictionaryFile = "EarnMoney/src/main/java/P11_20210519110/Code01/字典1.txt";
        String essayFile = "EarnMoney/src/main/java/P11_20210519110/Code01/文章1.txt";

        HashSet<String> dicItems = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dictionaryFile));) {
            String aLine = null;
            while ((aLine = bufferedReader.readLine()) != null) {
                dicItems.add(aLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> essayArr = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(essayFile));) {
            String aLine = null;
            while ((aLine = bufferedReader.readLine()) != null) {
                Matcher m = Pattern.compile("\\w+").matcher(aLine);
                while (m.find()) {
                    String word = m.group().toLowerCase();
                    if (dicItems.contains(word)) {
                        essayArr.add(word);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return essayArr;
    }

    public static int mergeSort(ArrayList<String> arr) {
        if (arr == null || arr.size() < 2) return 0;

        int compareTimes = 0;
        int N = arr.size();
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) break;

                int R = Math.min(M + mergeSize, N - 1);
                compareTimes += merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) break;
            mergeSize <<= 1;
        }

        return compareTimes;
    }

    public static int merge(ArrayList<String> arr, int L, int M, int R) {
        String[] help = new String[R - L + 1];

        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int compareTimes = 0;

        while (p1 <= M && p2 <= R) {
            int tmp = arr.get(p1).compareToIgnoreCase(arr.get(p2));
            help[i++] = arr.get(p1).compareToIgnoreCase(arr.get(p2)) <= 0 ? arr.get(p1++) : arr.get(p2++);
            compareTimes++;
        }
        while (p1 <= M) help[i++] = arr.get(p1++);
        while (p2 <= R) help[i++] = arr.get(p2++);

        for (i = 0; i < help.length; i++) {
            arr.set(L + i, help[i]);
        }

        return compareTimes;
    }
}
