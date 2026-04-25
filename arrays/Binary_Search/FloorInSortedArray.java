package Binary_Search;

public class FloorInSortedArray {
    // find the index (0-based) of the largest element in arr[]
    // that is less than or equal to x.
    // Time complexity (log n) ----> Binary Search Algorithm 


    public static int findFloor(int[] arr, int x){
        int i=0; 
        int j=arr.length-1;
        int idx =-1;
        
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]>x){
                j=mid-1;
            }
            else if(arr[mid]<=x){
                idx =mid;
                i=mid+1;
            }
        }
    return idx;
        
    }

    public static void main(String[] args) {
        
        int arr[] ={1,2,8,10,10,19};

        int ans = findFloor(arr, 5);

        System.out.println(ans);


    }
        
    }
    
