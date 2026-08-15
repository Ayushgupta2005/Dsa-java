import java.util.Arrays;

/*
 * Problem: Plus One (LeetCode 66)
 *
 * Walk from the last digit: if it is below 9, increment and return - no
 * carry beyond that point. Otherwise it becomes 0 and the carry continues
 * left. If every digit was 9, the result is 1 followed by all zeros, which
 * needs an array one slot longer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)  (O(n) only in the all-nines case)
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;

                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        System.out.println(Arrays.toString(obj.plusOne(new int[]{1,2,3})));   // Expected: [1, 2, 4]
        System.out.println(Arrays.toString(obj.plusOne(new int[]{4,3,2,1}))); // Expected: [4, 3, 2, 2]
        System.out.println(Arrays.toString(obj.plusOne(new int[]{9})));       // Expected: [1, 0]
        System.out.println(Arrays.toString(obj.plusOne(new int[]{9,9,9})));   // Expected: [1, 0, 0, 0]
    }
}
