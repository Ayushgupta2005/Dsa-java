package Linked_List;

/*
 * Problem: Remove Duplicates from Sorted List II (LeetCode 82) - two pointer, in place
 *
 * Remove ALL nodes that have duplicates, keeping only values that appear
 * exactly once. A dummy node handles the case where the head itself is a
 * duplicate. t is the tail of the kept list; i scans: if i is unique
 * (next is null or different), append it; otherwise j skips the whole
 * duplicate run and i jumps past it without being appended.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesSortedListIITwoPointer {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        ListNode i = head;

        while(i!=null){
            if(i.next==null || i.val !=i.next.val){
                t.next = i;
                t=i;
                i = i.next;
            }
            else{
                ListNode j = i.next ;
                while(j!=null && j.val == i.val){

                    j= j.next;
                }
                i=j;
            }
        }

        t.next = i;
        return dummy.next;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
        if (head == null) System.out.println("empty");
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedListIITwoPointer obj = new RemoveDuplicatesSortedListIITwoPointer();

        // List: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        print(obj.deleteDuplicates(head)); // Expected: 1 -> 2 -> 5

        // List: 1 -> 1 -> 1 -> 2 -> 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);

        print(obj.deleteDuplicates(head2)); // Expected: 2 -> 3
    }
}
