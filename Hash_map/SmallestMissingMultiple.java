package Hash_map;

import java.util.HashSet;

/*
 * Problem: Smallest missing positive multiple of k
 * (source unconfirmed - no verified LeetCode ID for this exact signature)
 *
 * Put every array value in a HashSet, then walk i = 1, 2, 3... checking
 * whether k*i is present, returning the first multiple of k that is not.
 *
 * Time Complexity: O(n + m)  m = number of multiples checked before a miss
 * Space Complexity: O(n)
 */
public class SmallestMissingMultiple {

    public int missingMultiple(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int i=1;

        while(set.contains(k*i)){
            i++;
        }

        return k*i;

    }

    public static void main(String[] args) {
        SmallestMissingMultiple obj = new SmallestMissingMultiple();
        System.out.println(obj.missingMultiple(new int[]{1,2,3,4}, 1));    // Expected: 5
        System.out.println(obj.missingMultiple(new int[]{2,4,8,16}, 2));   // Expected: 6
        System.out.println(obj.missingMultiple(new int[]{5,10,15}, 5));    // Expected: 20
    }
}
