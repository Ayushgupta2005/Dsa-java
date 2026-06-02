package Binary_Search;

// Leetcode 162
public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        if(nums.length==1){
            return 0;
        }

        int i=0;
        int j=nums.length-1;

        while(i<=j){
            int mid = i+(j-i)/2;

            if(i==j){
                return i;
            }
            if(nums[mid]<nums[mid+1]){
                i=mid+1;
            }
            else if(nums[mid]>nums[mid+1]){
                j=mid;
            }
        }
        return i;
        
    }
    
}
