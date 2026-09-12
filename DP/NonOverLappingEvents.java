package DP;

import java.util.*;

public class NonOverLappingEvents {

    static int[][][] dp;

    public static int findMax(int[][] events, int i, int prev, int k) {

        if (i == events.length || k == 0) return 0;

        if (dp[i][prev + 1][k] != -1) {
            return dp[i][prev + 1][k];
        }

        if (prev == -1) {
            int pick = events[i][2] + findMax(events, i + 1, i, k - 1);
            int skip = findMax(events, i + 1, prev, k);

            return dp[i][prev + 1][k] = Math.max(pick, skip);
        }

        if (events[i][0] <= events[prev][1]) {
            return dp[i][prev + 1][k] =
                    findMax(events, i + 1, prev, k);
        }

        int pick = events[i][2] + findMax(events, i + 1, i, k - 1);
        int skip = findMax(events, i + 1, prev, k);

        return dp[i][prev + 1][k] = Math.max(pick, skip);
    }

    public static int maxTwoEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int n = events.length;

        dp = new int[n][n + 1][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return findMax(events, 0, -1, 2);
    }

    public static void main(String[] args) {

        int[][] events = {
            {1, 3, 2},
            {4, 5, 2},
            {2, 4, 3}
        };

        System.out.println(maxTwoEvents(events));
    }
}
