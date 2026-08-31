package DP;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Largest Divisible Subset - full reconstruction (LeetCode 368)
 *
 * Same dp[] as the length-only version (dp[i] = size of the largest
 * divisible subset ending at i). To rebuild the actual subset: find the
 * index with the max dp value and start there, then repeatedly walk
 * backward to a j where dp[j] == dp[current]-1 AND nums[current] % nums[j]
 * == 0 - that j is exactly the predecessor this subset was built from.
 * Stop once dp[current] == 1 (no predecessor).
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class LargestDivisibleSubsetFull {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        if(nums.length==1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            return list;
        }

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

        for(int i=0; i<nums.length; i++){
            System.out.print(dp[i]+ " ");
        }

        ArrayList<Integer> ans = new ArrayList<>();

        int max=0;
        int maxIdx =0;

        for(int i=0; i<dp.length; i++){
            if(dp[i]>max){
                max = dp[i];
                maxIdx = i;
            }
        }

        ans.add(nums[maxIdx]);

        int current =maxIdx;

        while(dp[current]!=1){

            int j=current-1;
            while(j>=0){
                if(dp[j]==dp[current]-1 && nums[current]%nums[j]==0){
                    ans.add(nums[j]);
                    current=j;
                    break;
                }
                j--;
            }
        }
        return ans;


    }

    public static void main(String[] args) {
        LargestDivisibleSubsetFull obj = new LargestDivisibleSubsetFull();
        System.out.println();
        System.out.println(obj.largestDivisibleSubset(new int[]{1,2,3}));
        System.out.println();
        System.out.println(obj.largestDivisibleSubset(new int[]{1,2,4,8}));
    }
}
