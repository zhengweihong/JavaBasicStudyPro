package P01_BasicGrammar.C06_RegularDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class RegularDemo {
    public static void main(String[] args) {
        String temp = "To match these Words";
        Matcher m = Pattern.compile("\\w+").matcher(temp);
        while (m.find()) {
            String word = m.group().toLowerCase();
            System.out.println(word);
        }
    }
}
