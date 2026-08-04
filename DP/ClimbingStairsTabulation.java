package DP;

import java.util.*;

public class ClimbingStairsTabulation {

    public static int climbStairs(int n) {

        if (n == 1 || n == 2)
            return n;

        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stairs: ");
        int n = sc.nextInt();

        int ans = climbStairs(n);

        System.out.println("Number of distinct ways: " + ans);

        sc.close();
    }
}
