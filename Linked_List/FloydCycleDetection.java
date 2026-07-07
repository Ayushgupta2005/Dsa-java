package Linked_List;

/*
 * Problem: Linked List Cycle II (LeetCode 142) - Floyd's Cycle Detection
 *
 * Phase 1: slow (x1) and fast (x2) pointers - if they meet, a cycle exists.
 * Phase 2: reset a pointer p to head; move p and slow one step at a time -
 * they meet exactly at the cycle's starting node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FloydCycleDetection {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        ListNode p = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                while(slow!= p){
                    slow=slow.next;
                    p = p.next;
                }
                return slow;
            }
        }
        return null;

    }

    public static void main(String[] args) {
        FloydCycleDetection obj = new FloydCycleDetection();

        // List: 3 -> 2 -> 0 -> -4 , tail connects back to node 2 (cycle start)
        ListNode head = new ListNode(3);
        ListNode cycleStart = new ListNode(2);
        head.next = cycleStart;
        cycleStart.next = new ListNode(0);
        cycleStart.next.next = new ListNode(-4);
        cycleStart.next.next.next = cycleStart; // creates the cycle

        ListNode ans = obj.detectCycle(head);
        System.out.println(ans != null ? ans.val : "null"); // Expected: 2

        // List with no cycle: 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(obj.detectCycle(head2)); // Expected: null
    }
}
