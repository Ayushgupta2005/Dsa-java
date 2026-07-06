package Linked_List;

/*
 * Problem: Remove Duplicates from Sorted List (LeetCode 83)
 *
 * The list is sorted, so duplicates are adjacent. t1 sits on the current
 * distinct node while t2 skips forward past all equal values, then t1.next
 * is relinked to the first different node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesSortedList {

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

        while(t1!=null){
            while(t2!=null && t1.val==t2.val){
                t2=t2.next;
                }

            t1.next = t2;

            if(t2 == null){
                return head;
            }
            t1=t2;
            t2=t2.next;
        }
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
        RemoveDuplicatesSortedList obj = new RemoveDuplicatesSortedList();

        // List: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        print(obj.deleteDuplicates(head)); // Expected: 1 -> 2 -> 3
    }
}
