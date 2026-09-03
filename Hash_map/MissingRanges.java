package Hash_map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * Problem: Missing Ranges (LeetCode 163)
 *
 * Put every present value in a HashSet, then walk lower..upper. Whenever a
 * value is missing, keep advancing while values stay missing to find the
 * full run, and record it as [start, end] (a lone missing value becomes
 * [x, x]).
 *
 * Time Complexity: O(n + (upper - lower))
 * Space Complexity: O(n)
 */
public class MissingRanges {

    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {


        ArrayList<List<Integer>> ans = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int i=lower;

        while(i<=upper){

              if (set.contains(i)) {
                i++;
                continue;
            }

            int start = i;
             while (i <= upper && !set.contains(i)) {
                i++;
            }
            int end = i - 1;

            ArrayList<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end);

            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        MissingRanges obj = new MissingRanges();

        System.out.println(obj.findDisappearedNumbers(new int[]{0,1,3,50,75}, 0, 99));
        // Expected: [[2, 2], [4, 49], [51, 74], [76, 99]]

        System.out.println(obj.findDisappearedNumbers(new int[]{}, 1, 1));
        // Expected: [[1, 1]]
    }
}
