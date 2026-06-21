package recursion;

/*
 * Problem: Subset Sum - check if any subset adds up to a target sum
 * Time Complexity: O(2^n)
 * Space Complexity: O(n) recursion stack
 */
public class SubsetSum {

    public static boolean check(int ans, int arr[], int sum, int idx){

        if(sum==ans){
            return true;
        }
        if(idx ==arr.length){
            return false;
        }

        return check(ans+arr[idx],arr,sum,idx+1) || check(ans,arr,sum,idx+1);
    }

    static Boolean isSubsetSum(int arr[], int sum) {

        return check(0,arr,sum,0);


    }

    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        System.out.println(isSubsetSum(arr, 9));  // Expected: true  (4 + 5)
        System.out.println(isSubsetSum(arr, 30)); // Expected: false
    }
}
