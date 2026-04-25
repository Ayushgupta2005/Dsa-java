import java.util.*;

public class CheckArraySort {

    // Function to check if array is sorted (non-decreasing)
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Function to print array
    public static void printArray(int[] arr) {
        System.out.print("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Test Case 1 (Sorted)
        int[] arr1 = {1, 2, 3, 4, 5};

        // Test Case 2 (Not Sorted)
        int[] arr2 = {1, 3, 2, 5, 4};

        // Print and check
        printArray(arr1);
        System.out.println("Is Sorted: " + isSorted(arr1));

        System.out.println();

        printArray(arr2);
        System.out.println("Is Sorted: " + isSorted(arr2));
    }
}