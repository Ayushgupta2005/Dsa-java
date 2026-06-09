
    /*
Problem: Two Furthest Houses With Different Colors (LeetCode 2078)

Time Complexity: O(n)
Space Complexity: O(1)
*/
public class Leetcode_2078 {

    public static int maxDistance(int[] colors) {

        int n = colors.length;
        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            if (colors[i] != colors[n - 1]) {
                max = Math.max(max, n - 1 - i);
                break;
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            if (colors[0] != colors[i]) {
                max = Math.max(max, i);
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] colors = {1, 1, 1, 6, 1, 1, 1};

        System.out.println("Maximum Distance: " + maxDistance(colors));
    }
}