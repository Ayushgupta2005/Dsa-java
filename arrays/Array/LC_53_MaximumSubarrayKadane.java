/*
 * Problem: Maximum Subarray (LeetCode 53) - Kadane's Algorithm
 *
 * At each index decide: extend the running subarray (cursum + nums[i]) or
 * start fresh from nums[i]. Track the best sum seen so far.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LC_53_MaximumSubarrayKadane {
    public int maxSubArray(int[] nums) {

        int cursum =nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++){
            cursum = Math.max(cursum+nums[i],nums[i]);
            sum = Math.max(sum, cursum);
        }

        return sum;

    }

    public static void main(String[] args) {
        LC_53_MaximumSubarrayKadane obj = new LC_53_MaximumSubarrayKadane();
        System.out.println(obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // Expected: 6
        System.out.println(obj.maxSubArray(new int[]{1}));                     // Expected: 1
        System.out.println(obj.maxSubArray(new int[]{5,4,-1,7,8}));            // Expected: 23
    }
}
