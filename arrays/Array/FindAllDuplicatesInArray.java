import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Find All Duplicates in an Array (LeetCode 442)
 *
 * Values are in [1, n], so each value v can mark index v-1. Flip the sign
 * at that index the first time v is seen; if it is already negative, v has
 * been seen before and is a duplicate. Uses no extra space beyond output.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)  (excluding the output list)
 */
public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]);

            if(nums[idx-1]>0){
                nums[idx-1]=-nums[idx-1];
            }
            else{
                ans.add(idx);
            }


        }
        return ans;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInArray obj = new FindAllDuplicatesInArray();
        System.out.println(obj.findDuplicates(new int[]{4,3,2,7,8,2,3,1})); // Expected: [2, 3]
        System.out.println(obj.findDuplicates(new int[]{1,1,2}));           // Expected: [1]
        System.out.println(obj.findDuplicates(new int[]{1}));               // Expected: []
    }
}
