package Linked_List;

/*
 * Problem: Partition List (LeetCode 86)
 *
 * Split the list into two chains built off two dummy nodes: one for values
 * < x and one for values >= x, preserving relative order. Then stitch the
 * first chain's tail to the second chain's head and null-terminate.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class PartitionList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode t1 = dummy1;
        ListNode t2 = dummy2;

        ListNode current =head;

        while(current!=null){
            if(current.val<x){
                t1.next = current;
                t1=t1.next;
                current = current.next;
            }
            else{
                t2.next = current;
                t2 = t2.next;
                current = current.next;
            }
        }

        ListNode head2 = dummy2.next;
        t1.next = head2;
        t2.next = null;
        return dummy1.next;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        PartitionList obj = new PartitionList();

        // List: 1 -> 4 -> 3 -> 2 -> 5 -> 2 , x = 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        print(obj.partition(head, 3)); // Expected: 1 -> 2 -> 2 -> 4 -> 3 -> 5

        // List: 2 -> 1 , x = 2
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);

        print(obj.partition(head2, 2)); // Expected: 1 -> 2
    }
}
