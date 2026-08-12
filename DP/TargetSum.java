package DP;

/*
 * Problem: Target Sum (LeetCode 494) - memoization
 *
 * Same +/- branching as the brute force, memoized on (i, sum). Since sum
 * can go negative, it is shifted by absSum (the total of all |nums[i]|) so
 * it maps into array indices 0 .. 2*absSum.
 *
 * Time Complexity: O(n * sum)  where sum = total of absolute values
 * Space Complexity: O(n * sum)
 */
public class TargetSum {
    static int absSum;
    static int dp[][];
    public static int find(int sum, int[] nums, int target,int i){

        if(i==nums.length){
            if(sum==target) return 1;
            else{
                return 0;
            }
        }
        if(dp[i][sum+absSum]!=-1) return dp[i][sum+absSum];

        int a=find(sum-nums[i],nums,target,i+1);
        int b=find(sum+nums[i],nums,target,i+1);

        int ans= a+b;
        dp[i][sum+absSum]=ans;
        return ans;

    }
    public int findTargetSumWays(int[] nums, int target) {

        absSum=0;
        for(int i=0; i<nums.length; i++){
            absSum = absSum+ Math.abs(nums[i]);
        }

        dp = new int[nums.length][2*absSum+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }

        return find(0,nums,target,0);

    }

    public static void main(String[] args) {
        TargetSum obj = new TargetSum();
        System.out.println(obj.findTargetSumWays(new int[]{1,1,1,1,1}, 3)); // Expected: 5
        System.out.println(obj.findTargetSumWays(new int[]{1}, 1));         // Expected: 1
    }
}
