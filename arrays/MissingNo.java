public class MissingNo {

    // leetcode 268
    public static int missingNumber(int[] nums) {

        int sum =0;
        for(int i=0; i<nums.length; i++ ){
            sum = sum + nums[i];
        }

        int n = nums.length;
        n= (n*(n+1))/2;
        sum = n-sum;
        return sum;

        
    }
    public static void main(String [] args){
        
    }
    
}
