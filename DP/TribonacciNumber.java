package DP;

import java.util.*;

public class TribonacciNumber {

    static int[] dp;

    public static int tri(int n) {

        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        int ans = tri(n - 1) + tri(n - 2) + tri(n - 3);

        dp[n] = ans;

        return ans;
    }

    public static int tribonacci(int n) {

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return tri(n);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int ans = tribonacci(n);

        System.out.println("The " + n + "th Tribonacci number is: " + ans);

        sc.close();
    }
}
