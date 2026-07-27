package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Problem: Subsets II (LeetCode 90)
 * Time Complexity: O(n * 2^n)
 * Space Complexity: O(n) recursion stack (excluding output)
 */
public class SubsetsII {

    public static void generate( List<Integer> list, int[] nums, int idx,List<List<Integer>> ans ){

        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        generate(list, nums, idx+1, ans);
        list.add(nums[idx]);
        generate(list,nums,idx+1, ans);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        generate(list, nums, 0, ans);

        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans2 = new ArrayList<>();

        for(int i=0; i<ans.size(); i++){
            if(!set.contains(ans.get(i))){
                set.add(ans.get(i));
                ans2.add(ans.get(i));
            }
        }
        return ans2;

    }

    public static void main(String[] args) {
        SubsetsII obj = new SubsetsII();
        int[] nums = {1, 2, 2};
        System.out.println(obj.subsetsWithDup(nums));
    }
}
