package Linked_List;

/*
 * Problem: Odd Even Linked List (LeetCode 328)
 *
 * Group all odd-position nodes together followed by the even-position nodes,
 * preserving relative order. Split the list by position parity into two
 * chains built off two dummy nodes, terminate the even chain, then attach
 * it after the odd chain.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class OddEvenList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode t1 = dummy1;
        ListNode t2 = dummy2;
        int i=1;
        ListNode curr = head;

        while(curr!=null){
            if(i%2!=0){
                t1.next = curr;
                t1=t1.next;
                curr = curr.next;
                i++;
            }
            else{
                t2.next = curr;
                t2=t2.next;
                curr = curr.next;
                i++;
            }

        }

        t2.next = null;
        ListNode head2 = dummy2.next;

        t1.next = head2;
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
        OddEvenList obj = new OddEvenList();

        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(obj.oddEvenList(head)); // Expected: 1 -> 3 -> 5 -> 2 -> 4

        // List: 2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next.next = new ListNode(7);

        print(obj.oddEvenList(head2)); // Expected: 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4
    }
}
