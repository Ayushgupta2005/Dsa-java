import java.util.Arrays;

/*
 * Problem: Kth Largest Element in an Array (LeetCode 215) - sort
 *
 * Sort ascending, then reverse in place with two pointers so the array
 * reads largest to smallest. The k-th largest is then simply index k-1.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)  (in place, ignoring the sort)
 */
public class KthLargestElementSort {
    public int findKthLargest(int[] nums, int k) {

    Arrays.sort(nums);

    int i=0;
    int j=nums.length-1;

    while(i<j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        i++;
        j--;
    }

    return nums[k-1];

    }

    public static void main(String[] args) {
        KthLargestElementSort obj = new KthLargestElementSort();
        System.out.println(obj.findKthLargest(new int[]{3,2,1,5,6,4}, 2));         // Expected: 5
        System.out.println(obj.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));   // Expected: 4
    }
}
