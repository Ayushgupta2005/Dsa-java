package DP;

/*
 * Problem: Ugly Number II (LeetCode 264)
 *
 * Every ugly number is some earlier ugly number multiplied by 2, 3 or 5.
 * Keep three pointers into the dp array - one per factor - and each step
 * take the smallest of dp[i2]*2, dp[i3]*3, dp[i5]*5. Advancing EVERY
 * pointer that produced the winner (separate ifs, not else-if) is what
 * skips duplicates like 6 = 2*3 = 3*2.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {

        int[] dp = new int[n];

        dp[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for(int i = 1; i < n; i++){

            int a = dp[i2] * 2;
            int b = dp[i3] * 3;
            int c = dp[i5] * 5;

            dp[i] = Math.min(a, Math.min(b, c));

            if(dp[i] == a) i2++;
            if(dp[i] == b) i3++;
            if(dp[i] == c) i5++;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        UglyNumberII obj = new UglyNumberII();
        System.out.println(obj.nthUglyNumber(10));   // 1,2,3,4,5,6,8,9,10,12 -> 12
        System.out.println(obj.nthUglyNumber(1));    // Expected: 1
        System.out.println(obj.nthUglyNumber(7));    // Expected: 8
        System.out.println(obj.nthUglyNumber(1690)); // Expected: 2123366400
    }
}
