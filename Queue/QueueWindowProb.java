package Queue;
  import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class QueueWindowProb {


    public static List<Integer> firstNegInt(int[] arr, int k) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        // Store indices of all negative numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                queue.add(i);
            }
        }

        int windows = arr.length - k + 1;

        for (int i = 0; i < windows; i++) {

            while (!queue.isEmpty() && queue.peek() < i) {
                queue.remove();
            }

            if (!queue.isEmpty() && queue.peek() <= i + k - 1) {
                ans.add(arr[queue.peek()]);
            } else {
                ans.add(0);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        List<Integer> result = firstNegInt(arr, k);

        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("Window Size: " + k);
        System.out.println("First Negative in Each Window: " + result);
    }

}
