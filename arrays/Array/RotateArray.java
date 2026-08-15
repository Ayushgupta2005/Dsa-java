import java.util.Arrays;

/*
 * Problem: Rotate Array (LeetCode 189)
 *
 * Rotate right by k using three reversals: reverse the whole array, then
 * reverse the first k elements, then reverse the rest. k is reduced mod n
 * since rotating by n is a no-op.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RotateArray {
    static public void rotatee(int arr[], int n, int m){
        int start=n;
        int end = m;
        int temp=0;

        while (start < end){
            temp = arr[start];

            arr[start]= arr[end];
            arr[end]=temp;

            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotatee(nums, 0, nums.length-1);
        rotatee(nums, 0 , k-1);
        rotatee(nums , k, nums.length-1);
    }

    public static void main(String[] args) {
        RotateArray obj = new RotateArray();

        int[] a = {1,2,3,4,5,6,7};
        obj.rotate(a, 3);
        System.out.println(Arrays.toString(a)); // Expected: [5, 6, 7, 1, 2, 3, 4]

        int[] b = {-1,-100,3,99};
        obj.rotate(b, 2);
        System.out.println(Arrays.toString(b)); // Expected: [3, 99, -1, -100]

        int[] c = {1,2};
        obj.rotate(c, 2);
        System.out.println(Arrays.toString(c)); // Expected: [1, 2]  (k % n == 0)
    }
}
