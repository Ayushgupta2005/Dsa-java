package sliding_window;

/*
 * Problem: Longest Subarray of 1's After Deleting One Element (LeetCode 1493)
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LongestSubarrayAfterDeletingOne {
    public int longestSubarray(int[] nums) {
        int max=0;
        int i=0;
        int j=0;
        int p=0;

        while(j<nums.length){

            while(p<nums.length && nums[p]!=0){
            p++;
        }
        if(p==nums.length){
            max = Math.max(max, p-1-i);
            break;
        }
        j=p+1;

            while(j<nums.length && nums[j]!= 0){
                j++;
            }

            int count = j-i-1;
            max = Math.max(max, count);

            i=p+1;
            p=j;
        }
        return max;

    }

    public static void main(String[] args) {
        LongestSubarrayAfterDeletingOne obj = new LongestSubarrayAfterDeletingOne();
        System.out.println(obj.longestSubarray(new int[]{1,1,0,1}));       
        System.out.println(obj.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1})); 
        System.out.println(obj.longestSubarray(new int[]{1,1,1}));         
    }
}
