/*
LeetCode: 560 - Subarray Sum Equals K

Approach:
Prefix Sum + HashMap

Time Complexity: O(n)
Space Complexity: O(n)
*/
    import java.util.*;
public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        int sum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(subarraySum(nums, k));
    }
}