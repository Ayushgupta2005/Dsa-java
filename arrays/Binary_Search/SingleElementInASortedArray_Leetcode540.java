package Binary_Search;

public class SingleElementInASortedArray_Leetcode540 {
    public int singleNonDuplicate(int[] nums) {

        if(nums.length ==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }

        if(nums[nums.length-1]!=nums[nums.length-2]){
            return nums[nums.length-1];
        }


        int i=0;
        int j= nums.length-1;

        while(i<=j){
            int mid = i+(j-i)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!= nums[mid-1]){
                return nums[mid];
            }

            int f=mid;
            int s=mid;

            if(nums[mid-1]==nums[mid]){
                f=mid-1;
            }
            else{
                s=mid+1;
            }

            int leftcount =f-i;
            int rightcount = j-s;

            if(leftcount%2==0){
                i=s+1;
            }
            else{
                j=f-1;
            }

        }
        return -1;
        
    }
}
