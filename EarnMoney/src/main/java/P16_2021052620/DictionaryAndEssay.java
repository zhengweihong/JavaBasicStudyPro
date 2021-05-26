package P16_2021052620;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : ZWH 2021/5/19
 * @version : 2.0
 * P11_20210519110.Code01
 *
 * 打印每比较100次的时间，思路：
 * 1、把compareTimes变成类的全局变量
 * 2、mergeSort方法删掉所有和compareTimes有关的逻辑
 * 3、merge方法用全局compareTimes
 * 4、每100次的判断逻辑：打印本100次耗时+更新eachStartTime（每100次开始的时间）
 */
public class DictionaryAndEssay {
    public static int compareTimes;
    public static long eachStartTime;

    public static void main(String[] args) {
        ArrayList<String> essayArr = getWords();

        long startTime = System.currentTimeMillis();
        eachStartTime = startTime;
        mergeSort(essayArr);
        long endTime = System.currentTimeMillis();

        //essayArr.forEach(System.out::println);

        System.out.println("排序所用总时间：" + (endTime - startTime) + "ms");
        System.out.println("排序总移动/比较次数：" + compareTimes);
    }

    public static ArrayList getWords() {
        String dictionaryFile = "EarnMoney/src/main/java/P11_20210519110/Code01/字典1.txt";
        String essayFile = "EarnMoney/src/main/java/P11_20210519110/Code01/文章1.txt";

        HashSet<String> dicItems = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dictionaryFile))) {
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

    public static void mergeSort(ArrayList<String> arr) {
        if (arr == null || arr.size() < 2) return;

        int N = arr.size();
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) break;

                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) break;
            mergeSize <<= 1;
        }
    }

    public static void merge(ArrayList<String> arr, int L, int M, int R) {
        String[] help = new String[R - L + 1];

        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            int tmp = arr.get(p1).compareToIgnoreCase(arr.get(p2));
            help[i++] = arr.get(p1).compareToIgnoreCase(arr.get(p2)) <= 0 ? arr.get(p1++) : arr.get(p2++);
            compareTimes++;
            if (compareTimes % 100 == 0) {//打印耗时+更新eachStartTime（每100次开始的时间）
                long eachEndTime = System.currentTimeMillis();
                System.out.println("第"+(compareTimes-100)+"次～第"+compareTimes+"次排序用时："
                                    + (eachEndTime - eachStartTime) + "ms");
                eachStartTime = eachEndTime;
            }
        }
        while (p1 <= M) help[i++] = arr.get(p1++);
        while (p2 <= R) help[i++] = arr.get(p2++);

        for (i = 0; i < help.length; i++) {
            arr.set(L + i, help[i]);
        }
    }
}
