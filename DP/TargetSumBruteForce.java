package DP;

/*
 * Problem: Target Sum (LeetCode 494) - plain recursion
 *
 * Every number gets either a '+' or a '-' sign. Branch on both choices at
 * each index and count the leaf paths whose running sum equals target.
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(n) recursion stack
 */
public class TargetSumBruteForce {
    public static int find(int sum, int[] nums, int target,int i){

        if(i==nums.length){
            if(sum==target) return 1;
            else{
                return 0;
            }
        }

        int a=find(sum-nums[i],nums,target,i+1);
        int b=find(sum+nums[i],nums,target,i+1);

        return a+b;

    }
    public int findTargetSumWays(int[] nums, int target) {

        return find(0,nums,target,0);

    }

    public static void main(String[] args) {
        TargetSumBruteForce obj = new TargetSumBruteForce();
        System.out.println(obj.findTargetSumWays(new int[]{1,1,1,1,1}, 3)); // Expected: 5
        System.out.println(obj.findTargetSumWays(new int[]{1}, 1));         // Expected: 1
    }
}
