
// Leetcode 1539. Kth Missing Positive Number

// arr = [2,3,4,7,11], k = 5   Output: 9 
// arr = [1,2,3,4], k = 2.     Output: 6
public class KthMissingNo {

    public static int findKthPositive(int[] arr, int k) {

        int l=0;
        int h=arr.length-1;

        while(l<=h){
            int mid = (l+h)/2;

            int correctNo=mid+1;

            int missing = arr[mid]-correctNo;

            if(missing>=k){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l+k;
        
    }

    public static void main(String[] args) {
        
        int arr[] = {2,3,4,7,11};
        System.out.println(findKthPositive(arr,5));

    }
}