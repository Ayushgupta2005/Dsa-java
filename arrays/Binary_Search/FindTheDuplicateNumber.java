package Binary_Search;

/*
 * Problem: Find the Duplicate Number (LeetCode 287)
 *
 * Binary search on the VALUE range [1..n] (not on indices). For a candidate
 * value mid, count how many numbers in the array are <= mid. If that count
 * is greater than mid, the duplicate lies in [low..mid]; otherwise it lies
 * in [mid+1..high]. This finds the duplicate without modifying the array
 * and in O(1) extra space.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int i=0;
        int j=nums.length-1;

        while(i<j){
            int count =0;
            int mid =i+(j-i)/2;

            for(int l=0; l<nums.length; l++){
                if(nums[l]<=mid){
                    count = count +1;
                }
            }
            if(count>mid){
                j=mid;
            }
            else{
                i=mid+1;
            }


        }
        return i;

    }

    public static void main(String[] args) {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        System.out.println(obj.findDuplicate(new int[]{1,3,4,2,2})); // Expected: 2
        System.out.println(obj.findDuplicate(new int[]{3,1,3,4,2})); // Expected: 3
    }
}
