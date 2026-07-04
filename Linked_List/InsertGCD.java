package Linked_List;

/*
 * Problem: Insert Greatest Common Divisors in Linked List (LeetCode 2807)
 *
 * Time Complexity: O(n log(maxVal))
 * Space Complexity: O(1)  (excluding the inserted nodes)
 */
public class InsertGCD {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int getGcd(int a, int b){
        if(a==0){
            return b;
        }
        return getGcd(b%a,a);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }


        ListNode temp1 = head;
        ListNode temp2 = head.next;

        while(temp2!=null){
        int a = getGcd(temp1.val, temp2.val);

        ListNode n = new ListNode(a);
        n.next = temp2;
        temp1.next = n;

        temp1 = n.next;
        temp2 = temp2.next;

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
        InsertGCD obj = new InsertGCD();

        // List: 18 -> 6 -> 10 -> 3
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        print(obj.insertGreatestCommonDivisors(head));
        //  18 -> 6 -> 6 -> 2 -> 10 -> 1 -> 3
    }
}
