import java.util.HashMap;

/*
 * Problem: Unique Paths (LeetCode 62) - Memoization
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class UniquePathsMemoization {

    public static int paths(int m, int n, HashMap<String, Integer> map) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int a;
        int b;

        String str1 = (m - 1) + "," + n;
        if (map.containsKey(str1)) {
            a = map.get(str1);
        } else {
            a = paths(m - 1, n, map);
            map.put(str1, a);
        }

        String str2 = m + "," + (n - 1);
        if (map.containsKey(str2)) {
            b = map.get(str2);
        } else {
            b = paths(m, n - 1, map);
            map.put(str2, b);
        }

        return a + b;
    }

    public static int uniquePaths(int m, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        return paths(m, n, map);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // Expected: 28
        System.out.println(uniquePaths(3, 2)); // Expected: 3
    }
}
