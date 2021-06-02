package P20_2021060230;

import java.util.*;

public class A6_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a positive integer:");
        int number = in.nextInt();
        if (isPalindrome(number))
            System.out.println(number + " is Palindrome");
        else
            System.out.println(number + " is not palindrome");
        in.close();
    }

    public static int reverse(int number) {
        int result = 0;
        while (number!=0) {
            if (result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10)
                return 0;
            int temp = number%10;
            number/=10;
            result = result * 10 + temp;
        }
        return result;
    }

    public static boolean isPalindrome(int number) {
        if (number == reverse(number))
            return true;
        else {
            return false;
        }
    }
}
