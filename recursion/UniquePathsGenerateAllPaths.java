/*
 * Problem: Unique Paths (LeetCode 62) - Generate All Paths
 * Time Complexity: O(2^(m+n)) - explores every path
 * Space Complexity: O(m + n) recursion stack
 */
public class UniquePathsGenerateAllPaths {

    // cr, cc = current row/col   |   lr, lc = last (target) row/col
    public static int paths(int cr, int cc, int lr, int lc) {
        if (cr == lr && cc == lc) return 1;
        if (cr > lr || cc > lc) return 0; // IMPORTANT: went out of bounds

        int right = paths(cr, cc + 1, lr, lc);
        int down = paths(cr + 1, cc, lr, lc);
        return right + down;
    }

    public static int uniquePaths(int m, int n) {
        return paths(0, 0, m - 1, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));// 28
        System.out.println(uniquePaths(3, 2)); //  3
    }
}
