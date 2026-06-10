    /*
 * Problem: Sum of Variable Length Subarrays
 *
 * Given an integer array nums of size n.
 *
 * For each index i:
 * start = max(0, i - nums[i])
 *
 * Consider the subarray nums[start...i].
 * Return the total sum of all such subarrays.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
import java.util.*;

public class LC_3427_SumOfVariableLengthSubarrays {

    public static int subarraySum(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int start = Math.max(0, i - nums[i]);

            if (start == 0) {
                ans += prefix[i];
            } else {
                ans += prefix[i] - prefix[start - 1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1};
        System.out.println("Output 1: " + subarraySum(nums1));
        // Expected: 11

        int[] nums2 = {3, 1, 1, 2};
        System.out.println("Output 2: " + subarraySum(nums2));
        // Expected: 13

        int[] nums3 = {};
        System.out.println("Output 3: " + subarraySum(nums3));
        // Expected: 0
    }
}
    
