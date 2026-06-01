package Binary_Search;
// Leetcode 154
public class MinInRotatedSortedArray {

    public static int findMin(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {

            if (nums[i] < nums[j]) {
                return nums[i];
            }

            int mid = i + (j - i) / 2;

            if (nums[mid] > nums[j]) {
                i = mid + 1;
            }
            else if (nums[mid] < nums[j]) {
                j = mid;
            }
            else {
                // Cannot determine the side due to duplicates
                j--;
            }
        }

        return nums[i];
    }
    public static void main(String[] args) {
        int arr[] = {2,2,2,0,1};
        System.out.println(findMin(arr));
    }

    
}
