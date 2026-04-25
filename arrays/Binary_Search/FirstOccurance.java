package Binary_Search;

public class FirstOccurance {

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,3,4,4,5,5,5,6};

        int i=0; 
        int j=arr.length -1;
        int index =0;
        int target =5;

        while(i<=j){
            int mid = i+(j-i)/2;

            if(arr[mid]==target){
                index = mid;
                j=mid-1;
            }
            else if (arr[mid]>target){
                j=mid-1;

            }
            else{
                i=mid+1;
            }

        }
        System.out.println("First occourance of target " + index);

    }
    
}
