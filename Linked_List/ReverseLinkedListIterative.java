package Linked_List;

/*
 * Problem: Reverse Linked List (LeetCode 206) - iterative pointer reversal
 *
 * Walk the list once, flipping each node's next pointer backwards:
 * save current.next, point current.next to prev, advance prev and current.
 * When current falls off the end, prev is the new head.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ReverseLinkedListIterative {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode prev = null;

        ListNode current = head;

        while(current!=null){
            ListNode temp = current.next;

            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedListIterative obj = new ReverseLinkedListIterative();

        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(obj.reverseList(head)); // Expected: 5 -> 4 -> 3 -> 2 -> 1
    }
}
