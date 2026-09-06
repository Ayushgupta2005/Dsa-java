package DP;

import java.util.*;

public class DistinctSubsequnces {

    static int[][] dp;

    public static int solve(int i, int j, String s, String t) {

        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            int pick = solve(i + 1, j + 1, s, t);
            int skip = solve(i + 1, j, s, t);

            dp[i][j] = pick + skip;
            return dp[i][j];
        }

        dp[i][j] = solve(i + 1, j, s, t);
        return dp[i][j];
    }

    public static int numDistinct(String s, String t) {

        dp = new int[s.length()][t.length()];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, s, t);
    }

    public static void main(String[] args) {

        String s = "rabbbit";
        String t = "rabbit";

        System.out.println(numDistinct(s, t));
    }
}
