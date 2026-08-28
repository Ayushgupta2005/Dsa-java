import java.util.PriorityQueue;

/*
 * Problem: Kth Largest Element in an Array (LeetCode 215) - min-heap
 *
 * Keep a min-heap of size k as the elements are scanned. Whenever the heap
 * grows past k, pop the smallest - so the heap always holds the k largest
 * elements seen so far, and its top is the k-th largest overall once the
 * whole array has been processed.
 *
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */
public class KthLargestElementHeap {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){

            q.add(nums[i]);
            if(q.size()>k){
                q.remove();
            }
        }
        return q.peek();

    }

    public static void main(String[] args) {
        KthLargestElementHeap obj = new KthLargestElementHeap();
        System.out.println(obj.findKthLargest(new int[]{3,2,1,5,6,4}, 2));         // Expected: 5
        System.out.println(obj.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));   // Expected: 4
    }
}
