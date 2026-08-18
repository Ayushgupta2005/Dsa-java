/*
 * Problem: Find the Maximum Achievable Number (LeetCode 2769)
 *
 * Each operation moves x down by 1 and num up by 1, closing a gap of 2 per
 * step, so after t operations the largest reachable x is num + 2*t.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class MaximumAchievableNumber {
    public int theMaximumAchievableX(int num, int t) {

        return 2*t+num;

    }

    public static void main(String[] args) {
        MaximumAchievableNumber obj = new MaximumAchievableNumber();
        System.out.println(obj.theMaximumAchievableX(4, 1)); // Expected: 6
        System.out.println(obj.theMaximumAchievableX(3, 2)); // Expected: 7
    }
}
