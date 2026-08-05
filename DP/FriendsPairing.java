package DP;

import java.util.*;

public class FriendsPairing {

    public static int[] dp;

    public static int friends(int n) {

        if (n == 1 || n == 2)
            return n;

        if (dp[n] != -1)
            return dp[n];

        int ans = friends(n - 1) + (n - 1) * friends(n - 2);

        dp[n] = ans;

        return ans;
    }

    public static int countFriendsPairings(int n) {

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return friends(n);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of friends: ");
        int n = sc.nextInt();

        int ans = countFriendsPairings(n);

        System.out.println("Number of ways to pair friends: " + ans);

        sc.close();
    }
}
