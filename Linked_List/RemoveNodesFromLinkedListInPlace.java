package Linked_List;

/*
 * Problem: Remove Nodes From Linked List (LeetCode 2487) - reverse, delete in place, reverse back
 *
 * Remove every node with a strictly greater value anywhere to its right.
 * Reverse the list so the condition becomes "keep a running maximum":
 * i is the last kept node, j skips ahead past every smaller node, relink,
 * then reverse back to restore order.
 *
 * Time Complexity: O(n)  (three linear passes: reverse + filter + reverse)
 * Space Complexity: O(1)
 */
public class RemoveNodesFromLinkedListInPlace {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode rotatee(ListNode head){
        ListNode curr = head;

        ListNode prev = null;

        while(curr!=null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;

    }
    public ListNode removeNodes(ListNode head) {

        if(head.next==null){
            return head;
        }

        head = rotatee(head);

        ListNode i = head;
        ListNode j = head.next;
        while(j!=null){

            while(j!=null && j.val<i.val){
                j=j.next;
            }
            i.next = j;
            i=j;
            if(j==null) break;
            j=j.next;
        }

        head = rotatee(head);
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
        RemoveNodesFromLinkedListInPlace obj = new RemoveNodesFromLinkedListInPlace();

        // List: 5 -> 2 -> 13 -> 3 -> 8
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        print(obj.removeNodes(head)); // Expected: 13 -> 8

        // List: 1 -> 1 -> 1 -> 1
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(1);

        print(obj.removeNodes(head2)); // Expected: 1 -> 1 -> 1 -> 1
    }
}
