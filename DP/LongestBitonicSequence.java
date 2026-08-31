package DP;

/*
 * Problem: Longest Bitonic Subsequence (GeeksforGeeks)
 *
 * A bitonic subsequence strictly increases then strictly decreases. dp1[i]
 * = length of the longest increasing subsequence ENDING at i (standard
 * LIS DP). dp2[i] is computed the same way but on the REVERSED array, then
 * reversed back - so dp2[i] ends up meaning "length of the longest
 * DEcreasing subsequence STARTING at i" (an increasing run in reverse is a
 * decreasing run forwards). For each index i as the peak, the bitonic
 * length through it is dp1[i] + dp2[i] - 1 (i is shared by both halves).
 *
 * NOTE: indices where dp1[i]==1 or dp2[i]==1 are skipped entirely, so a
 * peak must have at least one element strictly before AND after it. This
 * means a fully monotonic array (no true peak) returns 0 here, rather than
 * n as in formulations that allow a trivial one-sided run.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class LongestBitonicSequence {
    public static int longestBitonicSequence(int n, int[] nums) {

        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];

        dp1[0]=1;
        dp2[0]=1;

        for(int i=1; i<nums.length; i++){

            int j=i-1;
            int max=0;

            while(j>=0){
                if(nums[j]<nums[i]){
                    max = Math.max(max,dp1[j]);
                }
                j--;
            }
            dp1[i]=max+1;
        }

        int a=0;
        int nums2[]= new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            nums2[a]=nums[i];
            a++;
        }



        for(int i=1; i<nums.length; i++){

            int j=i-1;
            int max=0;

            while(j>=0){
                if(nums2[j]<nums2[i]){
                    max = Math.max(max,dp2[j]);
                }
                j--;
            }
            dp2[i]=max+1;
        }

        int x=0;
        int y=dp2.length-1;

        while(x<y){
            int temp = dp2[x];
            dp2[x]=dp2[y];
            dp2[y]=temp;
            x++;
            y--;
        }

        int max=0;
        for(int i=0; i<nums.length; i++){
            if(dp1[i]==1 || dp2[i]==1) continue;
            max = Math.max(dp1[i]+dp2[i],max);
        }
        if(max<=0) return 0;
        else return max-1;


    }

    public static void main(String[] args) {
        System.out.println(longestBitonicSequence(8, new int[]{1,11,2,10,4,5,2,1})); // Expected: 6
        System.out.println(longestBitonicSequence(6, new int[]{12,11,40,5,3,1}));    // Expected: 5
    }
}
