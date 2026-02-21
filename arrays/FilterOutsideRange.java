
    import java.util.*;


    // Given an array of integers and two integers low and high, return all the elements that are NOT in between low and high (inclusive).
public class FilterOutsideRange {

    public static int[] filterOutsideRange(int[] arr, int low, int high) {
        List<Integer> result = new ArrayList<>();

        for (int num : arr) {
            if (num < low || num > high) {
                result.add(num);
            }
        }

        // Convert List to array
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 10, 15, 20, 25};
        int low = 6;
        int high = 20;

        int[] ans = filterOutsideRange(arr, low, high);

        System.out.println("Elements outside range:");
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
