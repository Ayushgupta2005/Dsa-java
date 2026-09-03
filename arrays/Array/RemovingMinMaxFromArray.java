import java.util.Arrays;

/*
 * Problem: Removing Minimum and Maximum From Array (LeetCode 2091)
 *
 * You can only delete from the front or the back. To remove both the min
 * and max, there are exactly 3 strategies: delete everything from the
 * front through the later of the two indices, delete everything from the
 * back through the earlier of the two indices, or delete from BOTH ends
 * (front through the earlier index, back through the later one). Compute
 * the cost of each and take the minimum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemovingMinMaxFromArray {
    public int minimumDeletions(int[] nums) {

        int min=Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        int minIdx =0;
        int maxIdx =0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
                maxIdx=i;
            }

            if(nums[i]<min){
                min = nums[i];
                minIdx = i;
            }

        }

       int greaterIdx = Math.max(minIdx, maxIdx);
       int smallerIdx = Math.min(minIdx,maxIdx);

        int a= nums.length-greaterIdx;
        a=a+1+smallerIdx;

        int chota = nums.length-smallerIdx;

        int aa= Math.min(greaterIdx+1, Math.min(a,chota));
        return aa;

    }

    public static void main(String[] args) {
        RemovingMinMaxFromArray obj = new RemovingMinMaxFromArray();
        System.out.println(obj.minimumDeletions(new int[]{2,10,7,5,4,1,8,6}));      // Expected: 5
        System.out.println(obj.minimumDeletions(new int[]{0,-4,19,1,8,-2,-3,5}));   // Expected: 3
        System.out.println(obj.minimumDeletions(new int[]{101}));                   // Expected: 1
    }
}
