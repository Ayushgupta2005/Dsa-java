package Linked_List;

/*
 * Problem: Rotate List (LeetCode 61) - slow/fast gap pointers
 *
 * Reduce k with k % length, then advance fast k steps ahead. Move slow and
 * fast together until fast is on the tail: slow is now the new tail and
 * slow.next the new head. Link the old tail to the old head and cut at slow.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RotateListSlowFast {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next == null){
            return head;
        }

        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        k = k%length;

        ListNode slow = head;
        ListNode fast = head;

        for(int i=0;i<k;i++){
            if(fast==null){
                fast=head;
            }
            fast = fast.next;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        fast.next =head;
        ListNode ans = slow.next;
        slow.next = null;
        return ans;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        RotateListSlowFast obj = new RotateListSlowFast();

        // List: 1 -> 2 -> 3 -> 4 -> 5 , k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(obj.rotateRight(head, 2)); // Expected: 4 -> 5 -> 1 -> 2 -> 3

        // List: 0 -> 1 -> 2 , k = 4
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);

        print(obj.rotateRight(head2, 4)); // Expected: 2 -> 0 -> 1
    }
}
