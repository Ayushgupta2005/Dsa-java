package Linked_List;

/*
 * Problem: Maximum Twin Sum of a Linked List (LeetCode 2130)
 *
 * Twin pairs are (i, n-1-i). Find the middle with slow/fast pointers, cut
 * the list in half, reverse the second half, then walk both halves together
 * taking the max pair sum. List length is guaranteed even.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaximumTwinSum {

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

    public int pairSum(ListNode head) {

        ListNode slow= head;
        ListNode fast = head;

        while(fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
         ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverseList(head2);

        int max=0;

        while(head!=null && head2!=null){
            max = Math.max(head.val + head2.val, max);
            head = head.next;
            head2 = head2.next;

        }
        return max;


    }

    public static void main(String[] args) {
        MaximumTwinSum obj = new MaximumTwinSum();

        // List: 5 -> 4 -> 2 -> 1  -> twins (5,1) and (4,2)
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(obj.pairSum(head)); // Expected: 6

        // List: 4 -> 2 -> 2 -> 3
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);

        System.out.println(obj.pairSum(head2)); // Expected: 7
    }
}
