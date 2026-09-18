package DP;

import java.util.*;

public class MinStrengthOfLength {

    public static int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int[] dp = new int[n];

        int INF = n + 1;

        for (int i = 0; i < n; i++) {
            dp[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int len = right - left + 1;

                if (left > 0 && dp[left - 1] != INF) {
                    ans = Math.min(ans, len + dp[left - 1]);
                }

                if (right == 0) {
                    dp[right] = len;
                } else {
                    dp[right] = Math.min(dp[right - 1], len);
                }

            } else {

                if (right > 0) {
                    dp[right] = dp[right - 1];
                }
            }
        }

        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int result = minSumOfLengths(arr, target);

        System.out.println("Minimum sum of lengths: " + result);

        sc.close();
    }
}