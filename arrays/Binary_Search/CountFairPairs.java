package Binary_Search;

import java.util.Arrays;

/*
 * Problem: Count the Number of Fair Pairs (LeetCode 2563)
 *
 * A pair (i, j) with i < j is fair if lower <= nums[i] + nums[j] <= upper.
 * Sort the array, then for each i binary-search the range of valid partners
 * to its right: the count is (upperBound for upper-nums[i]) - (lowerBound for
 * lower-nums[i]).
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)  (ignoring the sort)
 */
public class CountFairPairs {

    public static int lowerBound(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static int upperBound(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);

        long count = 0;

        for (int i = 0; i < nums.length; i++) {

            int min = lower - nums[i];
            int max = upper - nums[i];

            int lb = lowerBound(nums, i + 1, min);
            int ub = upperBound(nums, i + 1, max);

            count += (ub - lb);
        }

        return count;
    }

    public static void main(String[] args) {
        CountFairPairs obj = new CountFairPairs();
        System.out.println(obj.countFairPairs(new int[]{0,1,7,4,4,5}, 3, 6)); // Expected: 6
        System.out.println(obj.countFairPairs(new int[]{1,7,9,2,5}, 11, 11)); // Expected: 1
    }
}
