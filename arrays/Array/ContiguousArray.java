import java.util.*;
  /*
 * LeetCode 525 - Contiguous Array
 *
 * Problem:
 * Given a binary array nums, return the maximum length of a contiguous
 * subarray with an equal number of 0 and 1.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ContiguousArray {

class Solution {

    public static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                sum += 1;
            } else {
                sum -= 1;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 0, 1, 1, 0, 1, 1};

        int answer = findMaxLength(nums);

        System.out.println("Maximum Length = " + answer);
    }
}
    
}
