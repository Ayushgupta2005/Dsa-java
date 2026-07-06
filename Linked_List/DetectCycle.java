package Linked_List;

import java.util.HashSet;

/*
 * Problem: Linked List Cycle II (LeetCode 142) - HashSet approach
 *
 * Return the node where the cycle begins (or null if no cycle). Walk the
 * list storing each visited node reference in a set; the first node seen
 * twice is the cycle's start.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class DetectCycle {

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

        HashSet<ListNode> set = new HashSet<>();

        ListNode temp = head;

        while(temp!=null){
            if(!set.contains(temp)){
                set.add(temp);
                temp=temp.next;
            }
            else{
                return temp;
            }
        }
        return null;

    }

    public static void main(String[] args) {
        DetectCycle obj = new DetectCycle();

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
