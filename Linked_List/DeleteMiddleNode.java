package Linked_List;

/*
 * Problem: Delete the Middle Node of a Linked List (LeetCode 2095) - slow/fast pointers
 *
 * Delete the middle node (index floor(n/2), 0-based). Uses two pointers:
 * fast moves twice as fast as slow, so when fast reaches the end, slow sits
 * just before the middle - then unlink slow.next. fast starts at head.next.next
 * to leave slow one step before the node to delete.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class DeleteMiddleNode {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode slow= head;
        ListNode fast =head.next.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        DeleteMiddleNode obj = new DeleteMiddleNode();

        // List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 , delete middle (index 3 -> value 4)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        print(obj.deleteMiddle(head)); // Expected: 1 -> 2 -> 3 -> 5 -> 6
    }
}
