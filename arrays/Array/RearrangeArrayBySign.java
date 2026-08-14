import java.util.Arrays;

/*
 * Problem: Rearrange Array Elements by Sign (LeetCode 2149)
 *
 * Positives and negatives are guaranteed to be equal in count, so positives
 * go to even indices and negatives to odd indices. Two write pointers
 * stepping by 2 keep each sign's original relative order.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the output
 */
public class RearrangeArrayBySign {
    public int[] rearrangeArray(int[] nums) {

        int[] sol = new int[nums.length];

        int pos =0;
        int neg=1;

        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                sol[pos]=nums[i];
                pos = pos+2;
            }
            else{
                sol[neg] = nums[i];
                neg = neg+2;
            }
        }
        return sol;

    }

    public static void main(String[] args) {
        RearrangeArrayBySign obj = new RearrangeArrayBySign();
        System.out.println(Arrays.toString(obj.rearrangeArray(new int[]{3,1,-2,-5,2,-4}))); // Expected: [3, -2, 1, -5, 2, -4]
        System.out.println(Arrays.toString(obj.rearrangeArray(new int[]{-1,1})));           // Expected: [1, -1]
    }
}
