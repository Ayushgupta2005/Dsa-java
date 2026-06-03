package Binary_Search;

public class Leetcode_1793 {
    public static int maximumScore(int[] nums, int k) {

    int i= k;
    int j= k;

    int ans = nums[k];

    int minVal = nums[k];

    while(i>=0 && j<nums.length){

        minVal= Math.min(minVal, Math.min(nums[i], nums[j]));

        ans = Math.max(ans, minVal * (j-i+1));

        int left;

        if(i>0){
            left =nums[i-1];
        }
        else{
            left =0;
        }
        int right;

        if(j<nums.length-1){
            right = nums[j+1];
        }
        else{
            right =0;
        }

        if(left>right){
            i--;
        }
        else{
            j++;
        }
    }
    return ans;
        
    }

    public static void main(String[] args) {
        int arr[] = {1,4,3,7,4,5};
        int ans = maximumScore(arr,3);
        System.out.println(ans);
        

    }
}
