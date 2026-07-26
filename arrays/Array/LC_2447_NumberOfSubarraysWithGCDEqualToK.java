/*
 * Problem: Number of Subarrays With GCD Equal to K (LeetCode 2447)
 * Time Complexity: O(n^2 * log(max)) in the worst case
 * Space Complexity: O(1)
 */
public class LC_2447_NumberOfSubarraysWithGCDEqualToK {

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static int subarrayGCD(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int currentGCD = 0;

            for (int j = i; j < nums.length; j++) {

                currentGCD = gcd(currentGCD, nums[j]);

                if (currentGCD == k) {
                    ans++;
                }

                if (currentGCD < k && currentGCD != 0) {
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {9, 3, 1, 2, 6, 3};
        System.out.println("Output 1: " + subarrayGCD(nums1, 3));

        int[] nums2 = {4};
        System.out.println("Output 2: " + subarrayGCD(nums2, 7));
    }
}
