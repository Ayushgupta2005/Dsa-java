import java.util.HashSet;

/*
 * Problem: Smallest Missing Integer Greater Than Sequential Prefix Sum (LeetCode 2996)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LC_2996_SmallestMissingInteger {
    public int missingInteger(int[] nums) {

        if(nums.length==1){
            return nums[0]+1;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int sum2=nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++){
            if(sum+1==nums[i]){
                sum =sum+1;
                sum2=sum2+sum;
            }
            else{
                break;
            }
        }

        while(true){
            if(!set.contains(sum2)){
                return sum2;
            }
            else{
                sum2++;
            }
        }

    }
}
