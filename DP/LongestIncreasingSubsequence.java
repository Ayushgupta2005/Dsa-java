package DP;

/*
 * Problem: Longest Increasing Subsequence (LeetCode 300)
 *
 * dp[i] = length of the longest increasing subsequence ENDING at index i.
 * For each i, look back at every earlier index j; if nums[j] < nums[i],
 * this element could extend that subsequence, so dp[i] can be dp[j] + 1.
 * Take the best such extension (or just itself if none qualify). The
 * answer is the max over the whole dp array, not dp[n-1], since the
 * longest subsequence can end anywhere.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        int dp[] = new int[nums.length];

        dp[0]=1;

        for(int i=1; i<dp.length; i++){

            int max=0;
            int j=i-1;

            while(j>=0){
                if(nums[j]<nums[i]){
                    max=Math.max(max,dp[j]);
                }
                j--;
            }

            dp[i]=max+1;
        }

        int max=0;
        for(int i=0; i<dp.length; i++){
            max= Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); // Expected: 4
        System.out.println(obj.lengthOfLIS(new int[]{0,1,0,3,2,3}));         // Expected: 4
        System.out.println(obj.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));       // Expected: 1
    }
}
