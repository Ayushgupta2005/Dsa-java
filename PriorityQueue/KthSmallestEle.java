package PriorityQueue;

import java.util.PriorityQueue;

public class KthSmallestEle {

    public static int kthSmallest(int[] arr, int k)  {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }

        return pq.peek();
    }

    public static void main(String[] args) {

        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int ans = kthSmallest(arr, k);

        System.out.println("Kth smallest element: " + ans);
    }
}