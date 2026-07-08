package Linked_List;

/*
 * Problem: Remove Duplicates from Sorted List (LeetCode 83) - compact version
 *
 * Single pass: t2 scans ahead; when it differs from t1, relink t1.next to t2
 * and move t1 up. The final t1.next = t2 (null) cuts off a trailing
 * duplicate run.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesSortedListCompact {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null) return null;
        if(head.next == null) return head;

        ListNode t1 = head;
        ListNode t2 = t1.next;

        while(t2!=null){
            if(t1.val == t2.val){
                t2=t2.next;
            }
            else{
                t1.next= t2;
                t1= t2;
            }
        }
        t1.next = t2;
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
        RemoveDuplicatesSortedListCompact obj = new RemoveDuplicatesSortedListCompact();

        // List: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        print(obj.deleteDuplicates(head)); // Expected: 1 -> 2 -> 3
    }
}
