/*
 * Problem: Unique Paths (LeetCode 62)
 * Without memoization TLE on large inputs:
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        return helper(m, n, memo);
    }

    public static int helper(int m, int n, int[][] memo) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        memo[m][n] = helper(m - 1, n, memo) + helper(m, n - 1, memo);
        return memo[m][n];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); 
        System.out.println(uniquePaths(3, 2)); 
    }
}
