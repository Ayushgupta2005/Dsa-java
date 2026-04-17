package strings;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {

        int max = 0;
        int a = 0, b = 0;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder();

            for (int j = i; j < s.length(); j++) {
                str.append(s.charAt(j));

                String original = str.toString();
                String reversed = new StringBuilder(original).reverse().toString();

                if (original.equals(reversed)) {
                    int length = original.length();
                    if (length > max) {
                        max = length;
                        a = i;
                        b = j;
                    }
                }
            }
        }
        return s.substring(a, b + 1);
    }

public static void main(String[] args) {
    
    String s= "babcd";
    String sol = longestPalindrome(s);

    System.out.println(sol);
}
}
// Time complexity: O(n cube)
// brute force