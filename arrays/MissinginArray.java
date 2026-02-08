// You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n
// (inclusive). This array represents a permutation of the integers from 1 to n with one element
// missing. Your task is to identify and return the missing element.


// Input: arr[] = [1, 2, 3, 5]
// Output: 4
// Explanation: All the numbers from 1 to 5 are present except 4.

public class MissinginArray {
    public static int missingNum(int arr[]){
        int n= arr.length +1;
        int sum=0;
        
        for (int i=0; i<arr.length; i++){
            sum=sum+arr[i];
        }
        int maxsum=0;
        
        for(int i=1; i<=n; i++){
            maxsum = maxsum +i;
        }
         
        return maxsum - sum;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,5};
        System.out.println(missingNum(arr));
    }
    }

    
//Time Complexity  O(N)

// Geek For Geeks question 