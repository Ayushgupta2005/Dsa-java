package bit_manipulation;

/*
 * Problem: Find Xor-Beauty of Array (LeetCode 2527)
 *
 * The xor-beauty of the array reduces to the XOR of all elements
 * (all the effective-value terms cancel out except the XOR of nums).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class XorBeauty {
    public int xorBeauty(int[] nums) {
        int a=nums[0];

        for(int i=1; i<nums.length; i++){
            a=a^nums[i];
        }

        return a;
    }

    public static void main(String[] args) {
        XorBeauty obj = new XorBeauty();
        System.out.println(obj.xorBeauty(new int[]{1,4})); // Expected: 5
        System.out.println(obj.xorBeauty(new int[]{15,45,20,2,34,35,5,44,32,30})); // Expected: 34
    }
}
