import java.util.Arrays;

/*
 * Problem: Minimum Number of 3-Consecutive Bit Flips
 * (a k=3 specialization of "K-Consecutive Bit Flips" - LeetCode 995 takes k
 * as a parameter; this version hardcodes the window to size 3)
 *
 * Greedy, left to right: a 0 can only ever be fixed by flipping a window
 * that STARTS at it, since any earlier window has already been decided.
 * So whenever nums[i] is 0, flip the 3-window [i, i+2] in place and count
 * it. If a 0 is found with fewer than 3 elements remaining, it can never
 * be fixed -> -1.
 *
 * Time Complexity: O(n)  (each index enters at most one flip window)
 * Space Complexity: O(1)  (in place)
 */
public class MinOperationsFlipWindow3 {
    public int minOperations(int[] nums) {

        int count=0;
        int i=0;

        while(i<nums.length){

            if(nums[i]==0){
                if(i+2>=nums.length) return -1;
                int a=i+2;

                for(int j=i; j<=a; j++){
                    if(nums[j]==0) nums[j]=1;
                    else if(nums[j]==1) nums[j]=0;
                }
                count++;
            }
            i++;
        }
        return count;

    }

    public static void main(String[] args) {
        MinOperationsFlipWindow3 obj = new MinOperationsFlipWindow3();
        System.out.println(obj.minOperations(new int[]{0,1,1,1,0,0}));     // Expected: 3
        System.out.println(obj.minOperations(new int[]{0,1,1,1}));         // Expected: -1
        System.out.println(obj.minOperations(new int[]{0,0,0,1,0,1,1,0})); // Expected: 3
    }
}
