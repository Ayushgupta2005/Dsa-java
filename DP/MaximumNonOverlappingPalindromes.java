package DP;

import java.util.Arrays;

public class MaximumNonOverlappingPalindromes {

    public static int[][] dp;

    static boolean check(String s, int a, int b) {

        int i = a;
        int j = b;

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static int solve(String s, int k, int i, int j) {

        if (j >= s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (check(s, i, j)) {

            int take = 1 + solve(s, k, j + 1, j + k);
            int grow = solve(s, k, i, j + 1);
            int slide = solve(s, k, i + 1, j + 1);

            int ans = Math.max(take, Math.max(grow, slide));

            dp[i][j] = ans;
            return ans;

        } else {

            int grow = solve(s, k, i, j + 1);
            int slide = solve(s, k, i + 1, j + 1);

            int ans = Math.max(grow, slide);

            dp[i][j] = ans;
            return ans;
        }
    }

    public static int maxPalindromes(String s, int k) {

        dp = new int[s.length() + 1][s.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, k, 0, k - 1);
    }

    public static void main(String[] args) {

        String s = "abaccdbbd";
        int k = 3;

        int ans = maxPalindromes(s, k);

        System.out.println(
            "Maximum Number of Non-overlapping Palindromes: " + ans
        );
    }
}
