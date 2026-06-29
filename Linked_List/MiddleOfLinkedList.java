package Linked_List;

/*
 * Problem: Middle of the Linked List (LeetCode 876).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MiddleOfLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {

        int count =1;
        ListNode t = head;

        while(t!=null){
            t=t.next;
            count++;
        }
        t=head;

        if(count%2!=0){
            count = count+1;
        }
        count = count/2;

        for(int i=1; i<count; i++){
            t=t.next;
        }
        return t;

    }

    public static void main(String[] args) {
        MiddleOfLinkedList obj = new MiddleOfLinkedList();

        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(obj.middleNode(head).val); // Expected: 3

        // List: 1 -> 2 -> 3 -> 4 -> 5 -> 6  (two middles -> return the second)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        System.out.println(obj.middleNode(head2).val); 
    }
}
