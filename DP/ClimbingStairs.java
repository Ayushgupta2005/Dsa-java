package DP;

import java.util.*;

public class ClimbingStairs {

    static int[] dp;

    public static int find(int n) {

        if (dp[n] != -1)
            return dp[n];

        if (n == 1 || n == 2)
            return n;

        int ans = find(n - 1) + find(n - 2);

        dp[n] = ans;

        return ans;
    }

    public static int climbStairs(int n) {

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return find(n);
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
