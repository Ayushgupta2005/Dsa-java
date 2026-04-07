import java.util.Arrays;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {

        int arr[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i]=nums[i];       
        }
        Arrays.sort(arr);

        int i=0;
        int j=arr.length-1;
        int a=0;
        int b=0;

        int sol[] = new int[2];

        while(i<j){
            if(arr[i]+arr[j]==target){
                a=arr[i];
                b=arr[j];
                break;
            } else if(arr[i]+arr[j]<target){
                i++;
            } else{
                j--;
            }
        }

        int c=0;
        int d=0;

        for(int k=0; k<nums.length; k++){
    if(nums[k]==a && c==0){
        c=k;
    } 
    else if(nums[k]==b && k!=c){
        d=k;
    }
}

        sol[0]=c;
        sol[1]=d;
        return sol;

    }
}