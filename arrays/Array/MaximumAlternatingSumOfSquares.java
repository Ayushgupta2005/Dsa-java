package arrays.Array;

import java.util.Arrays;

/*
 * Problem: Maximum Alternating Sum of Squares (LeetCode 3727)
 *
 * The array can be rearranged freely, so exactly half the squares get a '+'
 * and half a '-'. Since squaring kills the sign, sort by absolute value and
 * pair largest with smallest: the big squares take the plus slots, the small
 * ones take the minus slots. An odd middle element is always added.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class MaximumAlternatingSumOfSquares {

    public long maxAlternatingSum(int[] nums) {
        int arr[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i]<0){
                arr[i]=-1*nums[i];
            }
            else{
                arr[i]=nums[i];
            }
        }
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        long ans=0;

        while(i<j){
            long a = arr[j];
            a=(long)Math.pow(a,2);
            long b = arr[i];
            b=(long)Math.pow(b,2);
            ans = ans+(a-b);
            i++;
            j--;
        }

        if(i==j){
            ans=ans + (long)(Math.pow(arr[i],2));
        }
        return ans;

    }

    public static void main(String[] args) {
        MaximumAlternatingSumOfSquares obj = new MaximumAlternatingSumOfSquares();

        System.out.println(obj.maxAlternatingSum(new int[]{1,2,3}));          // Expected: 12
        System.out.println(obj.maxAlternatingSum(new int[]{1,-1,2,-2,3,-3})); // Expected: 16
    }
}
