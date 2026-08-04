package DP;

import java.util.*;

public class MinimumPathSumTabulation {

    public static int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];

        int sum = 0;

        for (int i = 0; i < grid[0].length; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }

        sum = 0;

        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
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