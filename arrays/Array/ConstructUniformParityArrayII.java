package arrays.Array;

/*
 * Problem: Construct Uniform Parity Array II (LeetCode 3876)
 *
 * If the global minimum is odd, it's automatically the smallest odd value
 * too, so no even element can ever be smaller than it -> always constructible.
 * If the global minimum is even, any odd element in the array is guaranteed
 * to be larger than it, which breaks constructibility -> false as soon as
 * one is found.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ConstructUniformParityArrayII {

    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums1.length; i++){
            min = Math.min(min, nums1[i]);
        }

        if(min%2!=0){
           return true;
        }

        if(min%2==0){

            for(int i=0; i<nums1.length; i++){
                 if(nums1[i]==min) continue;
                if(nums1[i]%2!=0) return false;
                else continue;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        ConstructUniformParityArrayII obj = new ConstructUniformParityArrayII();

        System.out.println(obj.uniformArray(new int[]{1,4,7})); // Expected: true
        System.out.println(obj.uniformArray(new int[]{2,3}));   // Expected: false
        System.out.println(obj.uniformArray(new int[]{2,4,6})); // Expected: true
    }
}
