package Hash_map;

import java.util.HashMap;

/*
 * Problem: Two Sum (LeetCode 1) - HashMap solution
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        // HashMap solution

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int a = target - nums[i];

            if(!map.containsKey(a)){
                map.put(nums[i],i);
            }
            else{
                int arr[] = {map.get(a),i};
                return arr;
            }
        }
        int arr[] = {0,0};
                return arr;

    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] res = obj.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res[0] + ", " + res[1]); // Expected: 0, 1
    }
}
