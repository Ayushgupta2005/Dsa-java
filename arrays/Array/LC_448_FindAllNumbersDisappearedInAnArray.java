    /*
 * LeetCode 448 - Find All Numbers Disappeared in an Array
 * Problem:
 * Given an array nums of length n where nums[i] is in the range [1, n],
 * return all the numbers in the range [1, n] that do not appear in nums.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (excluding the output list)
 */

    import java.util.*;

public class LC_448_FindAllNumbersDisappearedInAnArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        // Mark visited numbers
        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> answer = findDisappearedNumbers(nums);

        System.out.println("Missing Numbers: " + answer);
        // [5, 6]
    }
}

