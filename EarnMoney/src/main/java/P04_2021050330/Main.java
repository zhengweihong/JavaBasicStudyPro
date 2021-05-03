package P04_2021050330;

import java.io.*;
import java.util.*;

/**
 * @author not me
 * The class to execute the program
 */
public class Main {

    public static void main(String[] args) {
        // map of <word, occurrence>
        Map<String, Integer> wordMap = new HashMap<>();
        // the total number of words
        int totalWords = 0;
        // read words from file
        try (FileReader fr = new FileReader("EarnMoney/src/main/java/P04_2021050330/test.txt");
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                // split line by space
                String[] words = line.split(" ");
                for (String word : words) {
                    String lowWord = word.toLowerCase();
                    totalWords += 1;
                    // update the map
                    if (wordMap.containsKey(lowWord)) {
                        wordMap.put(lowWord, wordMap.get(lowWord) + 1);
                    } else {
                        wordMap.put(lowWord, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // sort the map by occurrence
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        // output the result
        System.out.println("     WORD\t\tFREQUENCY");
        System.out.println("     ====\t\t=========");
        for (int i = list.size() - 1; i >= list.size() - 15; i--) {
            System.out.printf("%8s\t\t%8.2f%%\n", list.get(i).getKey(), list.get(i).getValue() * 100.0 / totalWords);
        }
    }

}