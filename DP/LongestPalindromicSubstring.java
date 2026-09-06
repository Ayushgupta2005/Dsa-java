package DP;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

        int dp[][] = new int[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i > j) {
                    dp[i][j] = -1;
                } 
                else if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {

            int a = 0;
            int b = i + 1;

            for (int j = i + 1; j < dp[0].length; j++) {

                if (s.charAt(a) == s.charAt(b)) {

                    if (b - a == 1) {
                        dp[a][b] = 2;
                    } 
                    else if (dp[a + 1][b - 1] != 0) {
                        dp[a][b] = 2 + dp[a + 1][b - 1];
                    } 
                    else {
                        dp[a][b] = 0;
                    }

                } 
                else {
                    dp[a][b] = 0;
                }

                a++;
                b++;
            }
        }

        int x = 0;
        int y = 0;
        int max = 1;

        for (int i = 0; i < dp.length; i++) {

            int a = 0;
            int b = i + 1;

            for (int j = i + 1; j < dp[0].length; j++) {

                if (dp[a][b] > max) {
                    max = dp[a][b];
                    x = a;
                    y = b;
                }

                a++;
                b++;
            }
        }

        return s.substring(x, y + 1);
    }


    public static void main(String[] args) {

        String s = "babad";

        String ans = longestPalindrome(s);

        System.out.println("String: " + s);
        System.out.println("Longest Palindromic Substring: " + ans);
    }
}
