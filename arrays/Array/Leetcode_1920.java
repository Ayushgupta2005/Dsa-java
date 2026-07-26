

public class Leetcode_1920 {

    public static int[] buildArray(int[] nums) {

        int sol[] = new int[nums.length];

        for(int i=0; i<nums.length; i++){

            sol[i]=nums[nums[i]];

        }
        return sol;
        
    }

public static void main(String[] args) {
    
    int arr[] = {0,2,1,5,3,4};

    int ans[] = new int[arr.length];
    ans = buildArray(arr);

    for(int i=0; i<ans.length; i++){
        System.out.print(ans[i]+ " ");
    }
    
}
    
}