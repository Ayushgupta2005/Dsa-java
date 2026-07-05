package MultiDimentional_Arrays;

/*
 * Problem: Max Increase to Keep City Skyline (LeetCode 807)
 *
 * A building at (i, j) can be raised at most to min(rowMax[i], colMax[j])
 * without changing the skyline seen from any of the four sides. Sum the
 * gains min(rowMax[i], colMax[j]) - grid[i][j] over every cell.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int n = grid.length;

        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxIncreaseKeepingSkyline obj = new MaxIncreaseKeepingSkyline();
        int[][] grid = {
            {3, 0, 8, 4},
            {2, 4, 5, 7},
            {9, 2, 6, 3},
            {0, 3, 1, 0}
        };
        System.out.println(obj.maxIncreaseKeepingSkyline(grid)); // Expected: 35
    }
}
