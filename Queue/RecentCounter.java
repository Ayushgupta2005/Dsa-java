package Queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem: Number of Recent Calls (LeetCode 933)
 *
 * Design a class that counts how many ping() calls landed in the last 3000
 * milliseconds (inclusive), given calls arrive in non-decreasing order of t.
 * Push every timestamp onto a queue; before answering, evict everything
 * from the front that has fallen outside the [t-3000, t] window. The
 * queue's size after eviction is the answer.
 *
 * Time Complexity: O(1) amortized per ping (each timestamp is queued and
 * dequeued at most once)
 * Space Complexity: O(n) worst case (window size)
 */
public class RecentCounter {


    Queue<Integer> q = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        q.add(t);
        int a=t-3000;

        while(q.size()>0 && q.peek()<a){
            q.remove();
        }
        return q.size();
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));    // Expected: 1
        System.out.println(counter.ping(100));  // Expected: 2
        System.out.println(counter.ping(3001)); // Expected: 3
        System.out.println(counter.ping(3002)); // Expected: 3 (1 falls outside [2, 3002])
    }
}
