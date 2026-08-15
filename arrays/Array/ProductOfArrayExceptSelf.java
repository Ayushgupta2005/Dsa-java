import java.util.Arrays;

/*
 * Problem: Product of Array Except Self (LeetCode 238)
 *
 * answer[i] = (product of everything left of i) * (product of everything
 * right of i), so nums[i] is skipped without ever dividing. Build the
 * prefix products left-to-right and the suffix products right-to-left
 * (both seeded with 1, the empty product), then multiply them pairwise.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0]=1;

        int cursum = 1;

        for(int i=1; i<left.length; i++){
            cursum = cursum *nums[i-1];
            left[i]=cursum;
        }

        right[right.length-1]=1;

        cursum=1;

        for(int i=right.length-2; i>=0; i--){
            cursum = cursum* nums[i+1];
            right[i]=cursum;
        }

        int ans[]= new int[nums.length];

        for(int i=0; i<ans.length; i++){
            ans[i]= left[i]*right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(obj.productExceptSelf(new int[]{1,2,3,4})));    // Expected: [24, 12, 8, 6]
        System.out.println(Arrays.toString(obj.productExceptSelf(new int[]{-1,1,0,-3,3}))); // Expected: [0, 0, 9, 0, 0]
    }
}
