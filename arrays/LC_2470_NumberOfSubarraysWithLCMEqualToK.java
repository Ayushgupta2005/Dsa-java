/*
 * Problem: Number of Subarrays With LCM Equal to K (LeetCode 2470)
 * Time Complexity: O(n^2 * log(max)) in the worst case
 * Space Complexity: O(1)
 */
public class LC_2470_NumberOfSubarraysWithLCMEqualToK {

    public static int calgdc(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return calgdc(b % a, a);
        }
    }

    public static int checklcm(int a, int b) {
        int gdc = calgdc(a, b);
        return (a * b) / gdc;
    }

    public static int subarrayLCM(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                ans = ans + 1;
            }
            int currentLcm = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                currentLcm = checklcm(currentLcm, nums[j]);
                if (currentLcm == k) {
                    ans = ans + 1;
                } else if (currentLcm > k) {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 6, 2, 7, 1};
        System.out.println("Output 1: " + subarrayLCM(nums1, 6));

        int[] nums2 = {3};
        System.out.println("Output 2: " + subarrayLCM(nums2, 2));
    }
}
