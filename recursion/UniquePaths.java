/*
 * Problem: Unique Paths (LeetCode 62)
 *
 * Time Complexity: O(2^(m+n))
 * Space Complexity: O(m + n) recursion stack
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        } else {
            return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // Expected: 28
        System.out.println(uniquePaths(3, 2)); // Expected: 3
    }
}
