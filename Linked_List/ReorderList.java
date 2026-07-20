package Linked_List;

/*
 * Problem: Reorder List (LeetCode 143)
 *
 * Reorder L0->L1->...->Ln into L0->Ln->L1->Ln-1->... in place.
 * Find the middle (slow/fast), cut, reverse the second half, then
 * interleave the two halves alternately off a dummy node, attaching any
 * leftover first-half node at the end.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ReorderList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

     public static ListNode reverseList(ListNode head) {


        ListNode prev = null;

        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev =curr;
            curr = temp;
        }

        return prev;
    }
    public void reorderList(ListNode head) {

        if(head==null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverseList(head2);

        int i=1;

        ListNode cur1 = head;
        ListNode cur2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;

        while(cur2!=null){
            if(i%2!=0){
                t.next = cur1;
                t=t.next;
                cur1= cur1.next;
                i++;
            }
            else{
                t.next = cur2;
                t=t.next;
                cur2 = cur2.next;
                i++;
            }

        }

        if(cur1==null){
            while(cur2!=null){
                t.next = cur2;
                t=t.next;
                cur2 = cur2.next;
            }
        }
        else{
            t.next = cur1;
            t=t.next;
            cur1 = cur1.next;
        }

        t.next = null;
        head = dummy.next;


    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        ReorderList obj = new ReorderList();

        // List: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        obj.reorderList(head);
        print(head); // Expected: 1 -> 4 -> 2 -> 3

        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        obj.reorderList(head2);
        print(head2); // Expected: 1 -> 5 -> 2 -> 4 -> 3
    }
}
