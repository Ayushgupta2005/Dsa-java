package arrays.Array;

/*
 * Problem: Smallest Stable Index I / II (LeetCode 3903 / 3904)
 *
 * Instability at index i is max(nums[0..i]) - min(nums[i..n-1]). Precompute
 * the suffix minimum in one backward pass, then sweep forward carrying the
 * running prefix maximum, returning the first index where the gap is <= k.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SmallestStableIndex {

    public int firstStableIndex(int[] nums, int k) {
        int len = nums.length;
        int[] minPrefix = new int[len];
        int min = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minPrefix[i] = min;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            if (Math.abs(minPrefix[i] - max) <= k)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        SmallestStableIndex obj = new SmallestStableIndex();

        System.out.println(obj.firstStableIndex(new int[]{5,0,1,4}, 3)); // Expected: 3
        System.out.println(obj.firstStableIndex(new int[]{3,2,1}, 1));   // Expected: -1
        System.out.println(obj.firstStableIndex(new int[]{0}, 0));       // Expected: 0
    }
}
