package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Subsets (LeetCode 78)
 * Time Complexity: O(n * 2^n)
 * Space Complexity: O(n) recursion stack (excluding output)
 */
public class Subsets {

    public static void subsetss(ArrayList<Integer> list, int[] nums, int idx, ArrayList<List<Integer>> ans) {

        if (nums.length == idx) {
            ans.add(new ArrayList<>(list));
            return;
        }

        subsetss(list, nums, idx + 1, ans);
        list.add(nums[idx]);
        subsetss(list, nums, idx + 1, ans);
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {

        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        subsetss(list, nums, 0, ans);
        return ans;

    }

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(obj.subsets(nums));
    }
}
