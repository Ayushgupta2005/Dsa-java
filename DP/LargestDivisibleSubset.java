package DP;

/*
 * Problem: Largest Divisible Subset - length only (LeetCode 368)
 *
 * Sort first: in a divisible subset, each element must divide the next, so
 * sorting means we only ever need to look BACKWARD for a valid predecessor
 * - same shape as LIS. dp[i] = size of the largest divisible subset ENDING
 * at index i. For each i, check every earlier j; if nums[i] % nums[j] == 0,
 * i can extend that subset. Take the best extension, or start fresh (1).
 * Answer is the max over the whole dp array, since the subset can end
 * anywhere.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class LargestDivisibleSubset {

    // Practice only the length first
    public int largestDivisibleSubset(int[] nums) {

        java.util.Arrays.sort(nums);

        int dp[] = new int[nums.length];

        dp[0]=1;

        for(int i=1; i<nums.length; i++){
            int max=0;
            int j=i-1;

            while(j>=0){
                if(nums[i]%nums[j]==0){
                max = Math.max(max,dp[j]);
                j--;
                }
                else{
                    j--;
                }
            }
            dp[i]=max+1;
        }

        int max=0;

        for(int i=0; i<dp.length; i++){
            max = Math.max(dp[i],max);

        }
        return max;

    }

    public static void main(String[] args) {
        LargestDivisibleSubset obj = new LargestDivisibleSubset();
        System.out.println(obj.largestDivisibleSubset(new int[]{1,2,3}));   // Expected: 2
        System.out.println(obj.largestDivisibleSubset(new int[]{1,2,4,8})); // Expected: 4
    }
}
