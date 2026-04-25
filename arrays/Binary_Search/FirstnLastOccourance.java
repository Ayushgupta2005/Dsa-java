public class FirstnLastOccourance {
    public static int[] searchRange(int[] nums, int target) {

        if(nums.length==0){
            int arr[] ={-1,-1};
            return arr;
        }

        int i=0;
        int j=nums.length-1;

        int leftposition=-1;

        while(i<=j){
            int mid = i+(j-i)/2;
            if(nums[mid]==target){
                leftposition =mid;
                j= mid-1;
            }
            else if(nums[mid]>target){
                j =mid -1;
            
            }
            else{
                i=mid+1;
            }
        }

        int rightposition=-1;

        i=0;
        j= nums.length-1;

        while(i<=j){
            int mid = i+(j-i)/2;
            if(nums[mid]==target){
                rightposition =mid;
                i= mid+1;
            }
            else if(nums[mid]>target){
                j =mid -1;
            
            }
            else{
                i=mid+1;
            }
        }
        int arr4[] = {leftposition, rightposition};
        return arr4;
        
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,5,5,6,6};
        int sol[] = searchRange(arr,6);

    }
}

