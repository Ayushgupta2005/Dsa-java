package DP;

import java.util.*;

public class MinimumPathSum {

    public static int[][] dp;

    public static int path(int i, int j, int[][] grid) {

        int m = grid.length - 1;
        int n = grid[0].length - 1;

        if (i > m || j > n)
            return Integer.MAX_VALUE;

        if (i == m && j == n)
            return grid[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = path(i + 1, j, grid);
        int right = path(i, j + 1, grid);

        int ans = grid[i][j] + Math.min(down, right);

        dp[i][j] = ans;

        return ans;
    }

    public static int minPathSum(int[][] grid) {

        dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return path(0, 0, grid);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter grid values:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = minPathSum(grid);

        System.out.println("Minimum Path Sum: " + ans);

        sc.close();
    }
}