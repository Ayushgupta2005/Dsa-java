package recursion;

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
        int[] nums = {1, 2, 3};
        ArrayList<List<Integer>> ans = new ArrayList<>();
        subsetss(new ArrayList<>(), nums, 0, ans);
        System.out.println(ans); // Expected: [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
    }
}
