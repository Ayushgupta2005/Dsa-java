package sliding_window;

/*
 * Problem: Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold (LeetCode 1343)
 *
 * Fixed-size sliding window: keep the running sum of a window of size k,
 * slide by adding the entering element and removing the leaving one,
 * and count windows whose average (sum / k) is >= threshold.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class NumSubarraysAvgGEThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        if (arr.length < k) return 0;

        int sum=0;
        int count =0;

        for(int i=0; i<k; i++){
            sum = sum+arr[i];
        }

        if(sum/k>=threshold){
            count++;
        }

        for(int i=k; i<arr.length; i++){
            sum = sum + arr[i];
            sum = sum - arr[i-k];

            if(sum/k>=threshold){
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        NumSubarraysAvgGEThreshold obj = new NumSubarraysAvgGEThreshold();
        System.out.println(obj.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4)); // Expected: 3
        System.out.println(obj.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3, 5)); // Expected: 6
    }
}
