package Linked_List;

/*
 * Problem: Swapping Nodes in a Linked List (LeetCode 1721) - two pointers
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SwapNodes {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapNodes(ListNode head, int k) {

        ListNode temp = head;
        for(int i=1; i<k;i++){
            temp = temp.next;
        }

        ListNode slow = head;
        ListNode fast = head;

        for(int i=0; i<k; i++){
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        int tempp =temp.val;

        temp.val = slow.val;
        slow.val = tempp;

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
        SwapNodes obj = new SwapNodes();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(obj.swapNodes(head, 2)); 
    }
}
