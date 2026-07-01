import java.util.Arrays;
import java.util.List;

/*
 * Problem: Count Pairs Whose Sum is Less than Target (LeetCode 2824)
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class LC_2824_CountPairsSumLessThanTarget {
    public int countPairs(List<Integer> nums, int target) {
        int count =0;

        for(int i=0; i<nums.size(); i++){
            for(int j=i+1; j<nums.size(); j++){
                if(nums.get(i)+nums.get(j)<target){
                    count++;
                }

            }
        }
        return count;

    }

    public static void main(String[] args) {
        LC_2824_CountPairsSumLessThanTarget obj = new LC_2824_CountPairsSumLessThanTarget();
        System.out.println(obj.countPairs(Arrays.asList(-1,1,2,3,1), 2)); 
        System.out.println(obj.countPairs(Arrays.asList(-6,2,5,-2,-7,-1,3), -2)); 
    }
}
