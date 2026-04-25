package Binary_Search;

public class Leetcode_2529 {
    //  return the maximum between the number of positive integers and the number of negative integers.
    public static int maximumCount(int[] nums) {

        int i=0;
        int j=nums.length-1;

        int nidx =-1;

        while(i<=j){
            int mid =i+(j-i)/2;
            if(nums[mid]<0){
                nidx=mid;
                i=mid+1;
            }
            else if(nums[mid]>=0){
                j=mid-1;
            }
        }
        i=0;
        j=nums.length-1;
        int pidx=-1;

        while(i<=j){
            int mid =i+(j-i)/2;
            if(nums[mid]<=0){
                i=mid+1;
            }
            else if(nums[mid]>0){
                pidx =mid;
                j=mid-1;
            }

        }
        if(nidx ==-1 && pidx==-1){
            return 0;
        }

        if(nidx==-1){
            return nums.length-pidx;
        }
        else if(pidx ==-1){
            return nidx+1;
        }
        

        int a = nums.length -pidx;
        int b = nidx+1;

        if(a>b){
            return a;
        }
        else{
            return b;
        }
        
    }
    public static void main(String[] args) {
        
        int arr[] = {-2,-1,-1,1,2,3};  // [-3,-2,-1,0,0,1,2] & // [5,20,66,1314]

        int sol = maximumCount(arr);
        System.out.println(sol);
    }
    
}
