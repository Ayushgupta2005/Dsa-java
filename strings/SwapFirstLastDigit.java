//Write a program to swap the first and last digit of a number. 
package strings;

import java.util.Scanner;

public class SwapFirstLastDigit {

    static int swapDigits(int n) {
        String s = Integer.toString(n);

        if (s.length() == 1) {
            return n;   
        }

        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);

        String middle = s.substring(1, s.length() - 1);
        String result = last + middle + first;

        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(swapDigits(n));
        sc.close();
    }
}
