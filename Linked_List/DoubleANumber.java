package Linked_List;

/*
 * Problem: Double a Number Represented as a Linked List (LeetCode 2816)
 *
 * Reverse the list so digits run least-significant first, double each digit
 * carrying into the next, append a final carry node if needed, then reverse
 * back. Note (val*2)%10 is at most 8 and the carry is at most 1, so the
 * digit sum never exceeds 9.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the built result
 */
public class DoubleANumber {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {


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

    public ListNode doubleIt(ListNode head) {

        ListNode listt = reverseList(head);

        int carry=0;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        ListNode cur = listt;

        while(cur!=null){
            int a = cur.val *2;
            int c = (a%10) + carry;
            carry = a/10;
            ListNode b = new ListNode(c);
            temp.next = b;
            temp = temp.next;
            cur = cur.next;
        }

        if(carry!=0){
            ListNode l = new ListNode(carry);
            temp.next = l;
            temp = temp.next;
        }
        temp.next=null;

        ListNode ans = reverseList(dummy.next);
        return ans;
    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    static ListNode build(int... vals) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        for (int v : vals) { t.next = new ListNode(v); t = t.next; }
        return dummy.next;
    }

    public static void main(String[] args) {
        DoubleANumber obj = new DoubleANumber();

        print(obj.doubleIt(build(1,8,9)));   // 189 * 2 = 378  -> 3 -> 7 -> 8
        print(obj.doubleIt(build(9,9,9)));  // 999 * 2 = 1998 -> 1 -> 9 -> 9 -> 8
        print(obj.doubleIt(build(0)));      // 0 * 2 = 0      -> 0
    }
}
