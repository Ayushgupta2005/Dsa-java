package DP;

import java.util.*;

public class NonOverLappingEventsBinarySearch {

    static int[][] dp;

    public static int findNext(int[][] events, int i) {

        int ans = -1;
        int target = events[i][1];
        int j = events.length;

        while (i < j) {

            int mid = i + (j - i) / 2;

            if (events[mid][0] <= target) {
                i = mid + 1;
            } else {
                ans = mid;
                j = mid;
            }
        }

        return ans;
    }

    public static int findMax(int[][] events, int i, int k) {

        if (i == events.length) return 0;
        if (i == -1) return 0;
        if (k == 0) return 0;

        if (dp[i][k] != -1) return dp[i][k];

        int pick =
                events[i][2] + findMax(events, findNext(events, i), k - 1);

        int skip =
                findMax(events, i + 1, k);

        dp[i][k] = Math.max(pick, skip);

        return dp[i][k];
    }

    public static int maxTwoEvents(int[][] events) {

        dp = new int[events.length][3];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        return findMax(events, 0, 2);
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
