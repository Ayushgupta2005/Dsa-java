package recursion;

/*
 * Problem: Binary Search using recursion (LeetCode 704)
 * Time Complexity: O(log n)
 * Space Complexity: O(log n) recursion stack
 */
public class BinarySearchRecursive {


    public static int bs(int[] nums, int target, int i, int j){
        int mid = i+(j-i)/2;
        if(j<i){
            return -1;
        }
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]<=target){
            return bs(nums, target,mid+1, j);
        }
        else{
            return bs(nums, target, i, mid-1);
        }

    }
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length-1);
    }
}
