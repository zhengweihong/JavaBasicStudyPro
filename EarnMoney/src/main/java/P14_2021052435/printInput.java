package P14_2021052435;

import java.io.*;
import java.util.Scanner;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class printInput {
    public static void main(String[] args) {
        System.out.println("Please Input (q to quit) :");
        Scanner scan = new Scanner(System.in);
        String fileName = "EarnMoney/src/main/java/P14_2021052435/a.txt";
        String input;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            while (!"q".equals(input = scan.nextLine())) {
                bw.append(input);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
