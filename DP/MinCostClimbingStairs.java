package DP;

import java.util.*;

public class MinCostClimbingStairs {

    public static int[] dp;
    public static int climb(int[] cost, int idx) {

        if (idx >= cost.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int ans = cost[idx] + Math.min(climb(cost, idx + 1), climb(cost, idx + 2));

        dp[idx] = ans;

        return ans;
    }

    public static int minCostClimbingStairs(int[] cost) {

        dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);

        return Math.min(climb(cost, 0), climb(cost, 1));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();

        int[] cost = new int[n];

        System.out.println("Enter cost of each stair:");

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        int ans = minCostClimbingStairs(cost);

        System.out.println("Minimum cost to reach the top: " + ans);

        sc.close();
    }
}
