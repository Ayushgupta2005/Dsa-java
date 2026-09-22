package PriorityQueue;

import java.util.PriorityQueue;
// GFG question
public class MinCostOfRopes {

    public static int minCost(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int ans = 0;

        while (pq.size() > 0) {

            int a = pq.remove();

            if (pq.size() == 0) {
                break;
            }

            int b = pq.remove();

            ans = ans + a + b;

            pq.add(a + b);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 6};

        int ans = minCost(arr);

        System.out.println("Minimum Cost: " + ans);
    }
}