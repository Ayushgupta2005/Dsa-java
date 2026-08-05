package DP;

import java.util.*;

public class UniquePathsII {

    static int[][] dp;

    public static int paths(int i, int j, int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n)
            return 0;

        if (grid[i][j] == 1)
            return 0;

        if (i == m - 1 && j == n - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = paths(i + 1, j, grid) + paths(i, j + 1, grid);

        dp[i][j] = ans;

        return ans;
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1)
            return 0;

        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;

        dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return paths(0, 0, obstacleGrid);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();

        int[][] obstacleGrid = new int[m][n];

        System.out.println("Enter the grid (0 = free, 1 = obstacle):");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacleGrid[i][j] = sc.nextInt();
            }
        }

        int ans = uniquePathsWithObstacles(obstacleGrid);

        System.out.println("Number of Unique Paths: " + ans);

        sc.close();
    }
}