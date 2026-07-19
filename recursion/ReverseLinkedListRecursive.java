package recursion;

/*
 * Problem: Reverse Linked List (LeetCode 206) - recursive
 *
 * Detach the head, recursively reverse the rest of the list, then attach
 * the head at the end: the old second node (a) is the reversed tail, so
 * a.next = head finishes the job. b is the new head bubbling up unchanged.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) recursion stack
 */
public class ReverseLinkedListRecursive {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {

        if(head==null || head.next == null){
            return head;
        }

        ListNode a = head.next;

        head.next = null;
        ListNode b=reverseList(a);
        a.next = head;
        return b;
    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedListRecursive obj = new ReverseLinkedListRecursive();

        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(obj.reverseList(head)); // Expected: 5 -> 4 -> 3 -> 2 -> 1
    }
}
