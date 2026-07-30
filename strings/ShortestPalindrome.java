package strings;
import java.util.*;
public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        int length = s.length();
        String reversedString = new StringBuilder(s).reverse().toString();


        for (int i = 0; i < length; i++) {

            if (s.substring(0, length - i).equals(reversedString.substring(i))) {

                return new StringBuilder(reversedString.substring(0, i))
                        .append(s)
                        .toString();
            }
        }

        return "";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        String ans = shortestPalindrome(s);

        System.out.println("Shortest Palindrome: " + ans);

        sc.close();
    }
}
    