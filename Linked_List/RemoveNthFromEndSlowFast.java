package Linked_List;

/*
 * Problem: Remove Nth Node From End of List (LeetCode 19) - slow/fast, one pass
 *
 * Time Complexity: O(L)  (single pass)
 * Space Complexity: O(1)
 */
public class RemoveNthFromEndSlowFast {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        if(fast==null){
            head = head.next;
            return head;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
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
        if (head == null) System.out.println("empty");
    }

    public static void main(String[] args) {
        RemoveNthFromEndSlowFast obj = new RemoveNthFromEndSlowFast();

        // List: 1 -> 2 -> 3 -> 4 -> 5 
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(obj.removeNthFromEnd(head, 2)); 
    }
}
