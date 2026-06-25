package strings;

/*
 * Problem: Length of the Longest Alphabetical Continuous Substring (LeetCode 2414)
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LongestContinuousIncreasingSubstring {
    public int longestContinuousSubstring(String s) {

        char[] chars = s.toCharArray();

        int max = 1;
        int currentLength = 1;

        for (int j = 1; j < chars.length; j++) {

            if (chars[j] - chars[j - 1] == 1) {
                currentLength++;
                if (currentLength > max) {
                    max = currentLength;
                }
            } else {
                currentLength = 1;
            }
        }
        return max;
    }// Optimised

    public static void main(String[] args) {
        LongestContinuousIncreasingSubstring obj = new LongestContinuousIncreasingSubstring();
        System.out.println(obj.longestContinuousSubstring("abacaba")); // 2
        System.out.println(obj.longestContinuousSubstring("abcde"));   // 5
    }
}
