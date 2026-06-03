package Binary_Search;

public class FindSingleNumber {
    public static int singleNumber(int[] nums) {

        int a =0;

        for(int i=0; i<nums.length; i++){
            a= a^nums[i];

        }
        return a;
        
    }

    public static void main(String[] args) {
        
        int arr[] = {4,1,2,1,2};
        int sol = singleNumber(arr);
        System.out.println(sol);
    }
}
    
