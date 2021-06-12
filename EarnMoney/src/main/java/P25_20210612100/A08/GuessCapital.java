package P25_20210612100.A08;

import java.util.Scanner;

/**
 * @author : ZWH 6/12/21
 * @version : 1.0
 */
public class GuessCapital {
    public static void main(String[] args) {
        String[][] proAndCap = {
            {"Alberta","Edmonton"},
            {"British Columbia","Victoria"},
            {"Manitoba","Winnipeg"},
            {"New Brunswick","Fredericton"},
            {"Newfoundland and Labrador","St. John's"},
            {"Nova Scotia","Halifax"},
            {"Ontario","Toronto"},
            {"Prince Edward Island" ,"Charlottetown"},
            {"Quebec","Quebec City"},
            {"Saskatchewan","Regina"}
        };

        int count = 0;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < proAndCap.length ; i++) {
            System.out.print("What is the capital of "+proAndCap[i][0]+"?");
            String str = in.nextLine();
            if (proAndCap[i][1].compareToIgnoreCase(str) == 0) {
                count++;
            }
        }
        System.out.println("You got "+count+" question(s) right.");
        in.close();
    }
}
