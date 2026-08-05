package DP;

import java.util.*;

public class MinCostClimbingStairsTabulation {

    public static int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
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
