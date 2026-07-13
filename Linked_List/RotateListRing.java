package Linked_List;

/*
 * Problem: Rotate List (LeetCode 61) - ring approach (circularize then cut)
 *
 * Rotate the list right by k. Count the length, reduce k with k % count,
 * link the tail back to the head to form a ring, then the new head is
 * (count - k) steps from the old head and the new tail is the node just
 * before it - cut the ring there.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RotateListRing {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if(head==null){
            return null;
        }

        ListNode temp = head;
        int count =0;

        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if(k>0){
        k = k%count;
        }

        temp = head;
        while(temp.next!=null){
            temp= temp.next;
        }

        temp.next = head;
        temp = head;
        for(int i=0; i<count -k; i++){
            temp = temp.next;
        }
        ListNode ans = head;
        for(int i=0; i<count-k-1; i++){
            ans= ans.next;
        }
        ans.next = null;
        return temp;

    }

    static void print(ListNode head) {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + (t.next != null ? " -> " : "\n"));
            t = t.next;
        }
    }

    public static void main(String[] args) {
        RotateListRing obj = new RotateListRing();

        // List: 1 -> 2 -> 3 -> 4 -> 5 , k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        print(obj.rotateRight(head, 2)); // Expected: 4 -> 5 -> 1 -> 2 -> 3

        // List: 0 -> 1 -> 2 , k = 4
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);

        print(obj.rotateRight(head2, 4)); // Expected: 2 -> 0 -> 1
    }
}
