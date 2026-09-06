package DP;

public class PalindromicSubstrings {

    public static int countSubstrings(String s) {

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

                if (s.charAt(a) == s.charAt(b) && dp[a + 1][b - 1] != 0) {
                    dp[a][b] = 2 + dp[a + 1][b - 1];
                }
                else {
                    dp[a][b] = 0;
                }

                a++;
                b++;
            }
        }

        int count = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (dp[i][j] > 0) {
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {

        String s = "aaa";

        int ans = countSubstrings(s);

        System.out.println("String: " + s);
        System.out.println("Number of Palindromic Substrings: " + ans);
    }
}
