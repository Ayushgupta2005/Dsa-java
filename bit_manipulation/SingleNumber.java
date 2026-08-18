package bit_manipulation;

/*
 * Problem: Single Number (LeetCode 136)
 *
 * Every element appears twice except one. XOR is its own inverse
 * (x ^ x == 0) and order-independent, so XOR-ing everything cancels all
 * the pairs and leaves the lone element.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {

        int a=nums[0];

        for(int i=1; i<nums.length; i++){
            a=a^nums[i];
        }
        return a;

    }

    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.singleNumber(new int[]{2,2,1}));      // Expected: 1
        System.out.println(obj.singleNumber(new int[]{4,1,2,1,2}));  // Expected: 4
        System.out.println(obj.singleNumber(new int[]{1}));          // Expected: 1
    }
}
