package DP;

import java.util.Arrays;

/*
 * Problem: Russian Doll Envelopes (LeetCode 354)
 *
 * Sort by width ascending, and by height DESCENDING on equal widths so two
 * envelopes of the same width can never nest. Then the answer is just the
 * LIS over the heights.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {


        // sort based on 1st index and if 1st index is same then based on second
        Arrays.sort(envelopes, (a,b)-> (a[0]!=b[0]) ? Integer.compare(a[0],b[0]) : Integer.compare(b[1],a[1]));

        int arr[]= new int[envelopes.length];
        for(int i=0; i<envelopes.length; i++){
            arr[i]=envelopes[i][1];
        }

        int dp[] = new int[arr.length];

        dp[0]=1;

        for(int i=1; i<arr.length; i++){

            int max=0;
            int j=i-1;

            while(j>=0){
                if(arr[j]<arr[i]){
                    max=Math.max(max,dp[j]);
                }
                j--;
        }
         dp[i]=max+1;
    }
    int ans=0;

    for(int i=0; i<dp.length; i++){
        ans=Math.max(ans,dp[i]);
    }
    return ans;
}

    public static void main(String[] args) {
        RussianDollEnvelopes obj = new RussianDollEnvelopes();

        System.out.println(obj.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}})); // Expected: 3
        System.out.println(obj.maxEnvelopes(new int[][]{{1,1},{1,1},{1,1}}));       // Expected: 1
    }
}
