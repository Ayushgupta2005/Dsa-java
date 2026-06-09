 /*
Problem: Partition Array According to Given Pivot (LeetCode 2161)

Time Complexity: O(n)
Space Complexity: O(n)
*/
import java.util.ArrayList;
public class Partition_Array {

    public static int[] pivotArray(int[] nums, int pivot) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                list2.add(nums[i]);
            } else if (nums[i] < pivot) {
                list.add(nums[i]);
            } else {
                count++;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        for (int i = list.size(); i < list.size() + count; i++) {
            nums[i] = pivot;
        }

        int a = 0;
        for (int i = list.size() + count; i < list.size() + count + list2.size(); i++) {
            nums[i] = list2.get(a);
            a++;
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        int[] result = pivotArray(nums, pivot);

        System.out.print("Output: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
    
