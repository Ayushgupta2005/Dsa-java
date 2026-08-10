package DP;

import java.util.*;
// TC: O(N)
// A.S: O(N+N) N for stack call and n for array
public class NthFibonacci {

    static int[] dp; 

    public static int fib(int n) {
        if (n == 0 || n == 1)
            return n;

        if (dp[n] != 0)
            return dp[n];

        int ans = fib(n - 1) + fib(n - 2);
        dp[n] = ans;

        return ans;
    }

    static int nthFibonacci(int n) {
        dp = new int[n + 1];
        return fib(n);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int ans = nthFibonacci(n);

        System.out.println("The " + n + "th Fibonacci number is: " + ans);

        sc.close();
    }
}